package com.example.hkings.todorecetas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class singupcomplete extends AppCompatActivity {



    TextView nombree;
    TextView correoo;
    TextView clavee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singupcomplete);



        nombree = (TextView)findViewById(R.id.txtnombre);
        correoo = (TextView)findViewById(R.id.txtcorreo);
        clavee = (TextView)findViewById(R.id.txtclave);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {

            String nn = extras.getString("nombre");
            String cc = extras.getString("correo");
            String pp = extras.getString("clave");

            nombree.setText(nn);
            correoo.setText(cc);
            clavee.setText(pp);
        }

        findViewById(R.id.btncomplete).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(singupcomplete.this, bottomnavi.class);

                startActivity(i);
            }
        }) );




    }
}
