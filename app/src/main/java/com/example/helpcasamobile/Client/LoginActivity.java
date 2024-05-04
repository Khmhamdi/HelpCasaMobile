package com.example.helpcasamobile.Client;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helpcasamobile.ManipData.ClientDataExchange;
import com.example.helpcasamobile.Model.Client;
import com.example.helpcasamobile.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    String email, pass;
    ClientDataExchange CDE;
    Client clt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.textViewRegister).setOnClickListener(this);
        CDE = new ClientDataExchange(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        if(v.getId() == R.id.btnLogin) {
            email = ((EditText) findViewById(R.id.etlclt)).getText().toString();
            pass = ((EditText) findViewById(R.id.etpclt)).getText().toString();

            clt = CDE.searchClientEmail(email);

            if(clt != null) {
                String dbpass = clt.getPassword();
                int idClt = clt.getIdClient();
                if(dbpass.equals(pass)) {
                    intent = new Intent(this, PageAccueil.class);
                    intent.putExtra("id",idClt);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Erreur d'authentification. Veuillez vérifier vos informations.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Utilisateur non trouvé. Veuillez vous inscrire.", Toast.LENGTH_SHORT).show();
            }
        }

        if(v.getId() == R.id.textViewRegister) {
            intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }



    }
}