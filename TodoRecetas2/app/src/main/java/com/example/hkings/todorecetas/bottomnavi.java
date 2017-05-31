package com.example.hkings.todorecetas;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class bottomnavi extends AppCompatActivity {

    String nombre,apellido,foto;
    boolean fbb;
    se dataFromActivityToFragment;
    //BottomNavigationView bottomNavigationView;
   // BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    recetas recetas1 = new recetas();
                    android.app.FragmentManager rmanager = getFragmentManager();
                    rmanager.beginTransaction().replace(R.id.contentl, recetas1, recetas1.getTag()).commit();
                    return true;
                case R.id.navigation_dashboard:

                    map map1 = new map();
                    android.app.FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.contentl, map1, map1.getTag()).commit();
                    return true;
                case R.id.navigation_notifications:
                    Bundle inBundle = getIntent().getExtras();
                    if (inBundle != null) {
                        String name = inBundle.get("name").toString();
                        String surname = inBundle.get("surname").toString();
                        String imageUrl = inBundle.get("imageUrl").toString();
                        boolean fbbitt = inBundle.getBoolean("fbbit");
                        nombre = name;
                        apellido = surname;
                        foto = imageUrl;
                        fbb = fbbitt;
                    }
                    //
                    if(fbb=true){


                    handler.postDelayed(r, 50);

                    perfil profile = new perfil();
                    android.app.FragmentManager manager2 = getFragmentManager();
                    dataFromActivityToFragment = (se) profile;
                    FragmentTransaction fragmentTransaction = manager2.beginTransaction();
                    fragmentTransaction.replace(R.id.contentl, profile);
                    fragmentTransaction.commit();
                    return true;
                    }else{
                        perfil profile = new perfil();
                        android.app.FragmentManager manager2 = getFragmentManager();
                        manager2.beginTransaction().replace(R.id.contentl, profile, profile.getTag()).commit();
                        return true;
                    }
                    /*
                    perfil profile = new perfil();
                    android.app.FragmentManager manager2 = getFragmentManager();
                    manager2.beginTransaction().replace(R.id.contentl, profile, profile.getTag()).commit();
                    return true;
                    */
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnavi);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        recetas recetas1 = new recetas();
        android.app.FragmentManager rmanager = getFragmentManager();
        rmanager.beginTransaction().replace(R.id.contentl, recetas1, recetas1.getTag()).commit();


    }

    final Handler handler = new Handler();
    final Runnable r = new Runnable() {
        public void run() {
            dataFromActivityToFragment.sendData(nombre,apellido,foto);

        }
    };

    public interface se {
        void sendData(String name ,String lname,String uripic);

    }

}
