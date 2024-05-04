package com.example.helpcasamobile;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helpcasamobile.Agence.LoginAgency;
import com.example.helpcasamobile.Client.LoginActivity;
import com.example.helpcasamobile.Client.RegisterActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final static int ACCOUNT_CREATION_ACTIVITY_ID=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnLoginAgence).setOnClickListener(this);
        findViewById(R.id.btnRegister).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;

        if (v.getId() == R.id.btnLogin) {
            intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        if (v.getId() == (R.id.btnRegister)) {
            intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivityForResult(intent, ACCOUNT_CREATION_ACTIVITY_ID);
        }
        if (v.getId() == (R.id.btnLoginAgence)) {
            intent = new Intent(this, LoginAgency.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACCOUNT_CREATION_ACTIVITY_ID) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Compte créé avec succès", Toast.LENGTH_LONG).show();
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Impossible de créer un compte. Contactez votre administrateur", Toast.LENGTH_LONG).show();
            } else if (resultCode == Activity.RESULT_FIRST_USER) {
                Toast.makeText(this, "Premier Utilisateur", Toast.LENGTH_LONG).show();
            } else if (resultCode == 23) {
                Toast.makeText(this, "Compte exist déjà!", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "Autre Erreur", Toast.LENGTH_LONG).show();
            }
        }
    }

}