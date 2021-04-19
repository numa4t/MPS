package com.example.pruebasmpsmps;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.pruebasmpsmps.MainActivity2Registro;
import com.google.firebase.database.ValueEventListener;


public class MenuUsuario extends AppCompatActivity {

    private TextView mtextLastName, mtextName, mtextCI, bienvenido, mMail;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference referencia = database.getReference();

        bienvenido = (TextView) findViewById(R.id.bien);
        mtextName = (TextView) findViewById(R.id.textName);
        mtextCI = (TextView) findViewById(R.id.editTextNumberCI);
        mtextLastName = (TextView) findViewById(R.id.textLastName);
        mMail = (TextView) findViewById(R.id.editTextTextEmail);

        String ci = getIntent().getStringExtra("ci");
        mtextCI.setText(ci);

        String name = getIntent().getStringExtra("name");
        mtextName.setText(name);

        String lastname = getIntent().getStringExtra("lastname");
        mtextLastName.setText(lastname);

        String bien = getIntent().getStringExtra("name");
        bienvenido.setText("Bienvend@ "+ bien);

        String mail = getIntent().getStringExtra("email");
        mMail.setText(mail);



        /*referencia.child("users").equalTo(R.id.editTextNumberCI).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) { /*Con esto accedo a ciertos atributos del objeto users
                if (snapshot.exists()) {
                    String Nombre = snapshot.child("Nombre").getValue().toString();
                    String Apellido = snapshot.child("Apellido").getValue().toString();
                    String CI = snapshot.child("CI").getValue().toString();
                    String bien = snapshot.child("Nombre").getValue().toString();
                    mtextName.setText(Nombre);
                    mtextLastName.setText(Apellido);
                    mtextCI.setText(CI);
                    bienvenido.setText("Bienvend@ "+ bien);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });*/
    }
}


