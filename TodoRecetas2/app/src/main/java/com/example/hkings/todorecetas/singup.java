package com.example.hkings.todorecetas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class singup extends AppCompatActivity {


    EditText nombre;
    EditText correo;
    EditText clave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        nombre = (EditText) findViewById(R.id.cnombre);
        correo = (EditText) findViewById(R.id.ccorreo);
        clave = (EditText) findViewById(R.id.ccontrasena);





        findViewById(R.id.btnsingup).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String A = nombre.getText().toString();
                String B = correo.getText().toString();
                String C = clave.getText().toString();

                Intent i = new Intent(singup.this, singupcomplete.class);
                i.putExtra("nombre", A);
                i.putExtra("correo", B);
                i.putExtra("clave", C);
                startActivity(i);
            }
        }) );



    }
}
