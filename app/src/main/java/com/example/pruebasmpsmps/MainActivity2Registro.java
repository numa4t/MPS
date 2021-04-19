package com.example.pruebasmpsmps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class MainActivity2Registro extends AppCompatActivity {

    Button btnCrearUsuario;

    private String dni, name, lastName, email;

    private EditText db_ci, db_nombre, db_apellido, db_mail;

    private static final String TAG = "mpsusers";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_registro);

        db_ci = (EditText) findViewById(R.id.editTextNumberCI);
        db_nombre = (EditText) findViewById(R.id.editTextNombre);
        db_apellido = (EditText) findViewById(R.id.editTextApellido);
        db_mail = (EditText) findViewById(R.id.editTextTextEmail);



        btnCrearUsuario = findViewById(R.id.buttonCrearUsuario);


        btnCrearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dni = db_ci.getText().toString();
                name = db_nombre.getText().toString();
                lastName = db_apellido.getText().toString();
                email = db_mail.getText().toString();

                Map<String, Object> users = new HashMap<>();

                users.put("CI", dni);
                users.put("Nombre", name);
                users.put("Apellido", lastName);
                users.put("Email", email);


                db.collection("users")
                        .add(users)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "Documento agregado con:  " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error al agregar datos", e);
                            }
                        });


                Intent intent = new Intent(MainActivity2Registro.this,MenuUsuario.class);
                intent.putExtra("ci",dni);
                intent.putExtra("name",name);
                intent.putExtra("lastname",lastName);
                intent.putExtra("email",email);
                startActivity(intent);




            }
        });
    }

        }



