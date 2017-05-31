package com.example.hkings.todorecetas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class singin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);





        findViewById(R.id.btnsingin).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(singin.this, bottomnavi.class);

                startActivity(i);
            }
        }) );

    }
}
