package com.prodevsmx.rider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;


public class ActivityLogin extends AppCompatActivity{

    LoginButton loginButton;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.prodevsmx.rider",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.login_button);
        //Se declaran los permisos que van a ser utilizados por la API GRAPH
        loginButton.setReadPermissions(Arrays.asList("public_profile, user_friends"));
        //Se le anexa al botón de login un callback el cual es manejado abajo
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            Intent actionToDo;
            @Override
            public void onSuccess(LoginResult loginResult) {
                //si el inicio de sesión fué exitoso, se envía al usuario a la pantalla de carga
                actionToDo = new Intent(ActivityLogin.this, ActivityLand.class);
                actionToDo.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(actionToDo);
                finish();
            }
            @Override
            public void onCancel() {
                //se le muestra al usuario un mensaje de que su solicitud fue cancelada
                Toast.makeText(ActivityLogin.this, "Ups, login request was cancelled", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onError(FacebookException error) {
                //si hay algun tipo de error con la solicitud (en general) se le muestra al usuario
                Toast.makeText(ActivityLogin.this, "Sorry, something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //este método se útiliza para saber que fue la respuesta que se recibió de la solicitud
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    private void fetchUserInfo(){
        //se revisa si el token tiene una instancia para saber si el usuario está iniciado
        final AccessToken token = AccessToken.getCurrentAccessToken();
        if (token != null){
            //en caso de si tener instancia, ergo usuario logeado, se procede a mandarlo a la pantalla de Land, el contenido en sí
            Intent userIsLogged = new Intent(ActivityLogin.this, ActivityLand.class);
            startActivity(userIsLogged);
            finish();
        }
        //en caso de que no exista la instancia no se hace nada, no se manda al usuario y se muestra la interfaz para que el usuario pueda hacer login
        //con su cuentra de facebook
    }

    @Override
    protected void onResume() {
        super.onResume();
        //justo al abrir la aplicación se manda a hacer la comprobación si el usuario tiene la sesión iniciada
        fetchUserInfo();
    }

}

