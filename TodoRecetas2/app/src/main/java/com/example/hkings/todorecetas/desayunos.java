package com.example.hkings.todorecetas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class desayunos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desayunos);



        LeadsFragment leadsFragment = (LeadsFragment)
                getSupportFragmentManager().findFragmentById(R.id.leads_container);

        if (leadsFragment == null) {
            leadsFragment = LeadsFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.leads_container, leadsFragment)
                    .commit();
        }











    }
}
