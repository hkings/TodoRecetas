package com.example.hkings.todorecetas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainPRM extends AppCompatActivity implements View.OnClickListener{
    TextView txtStatus;
    LoginButton login_Button;
    CallbackManager callbackManager;
    Button login,registrar;
    AccessTokenTracker accessTokenTracker;
    ProfileTracker profileTracker;
    boolean fb=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_main_prm);
        initilizecontrols();
        loginWithFB();

        login=(Button)findViewById(R.id.btnsiginprm);
        login.setOnClickListener(this);
        registrar= (Button)findViewById(R.id.btnprm);
        registrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.btnsiginprm:

                Intent i = new Intent(MainPRM.this, singin.class);
                startActivity(i);
                break;

            case R.id.btnprm:

                Intent u = new Intent(MainPRM.this, singup.class);
                startActivity(u);
                break;
        }

    }

    private void initilizecontrols(){
        callbackManager = CallbackManager.Factory.create();
        txtStatus= (TextView)findViewById(R.id.txtStatus);
        login_Button = (LoginButton)findViewById(R.id.login_button);

    }


private void loginWithFB(){

    accessTokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {
        }
    };
    profileTracker = new ProfileTracker() {
        @Override
        protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {

        }
    };
    accessTokenTracker.startTracking();
    profileTracker.startTracking();


    LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            fb=true;
            txtStatus.setText("login success\n"+loginResult.getAccessToken());
            Profile profile = Profile.getCurrentProfile();
            Intent i = new Intent(MainPRM.this, bottomnavi.class);
            i.putExtra("fbbit",fb);
            i.putExtra("name", profile.getFirstName());
            i.putExtra("surname", profile.getLastName());
            i.putExtra("imageUrl", profile.getProfilePictureUri(200,200).toString());
            startActivity(i);

        }

        @Override
        public void onCancel() {
            txtStatus.setText("login cancelled");
        }

        @Override
        public void onError(FacebookException error) {
            txtStatus.setText("login failed"+error.getMessage());
        }
    });
}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }



}
