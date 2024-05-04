package com.example.helpcasamobile.Client;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import com.example.helpcasamobile.ManipData.ClientDataExchange;
import com.example.helpcasamobile.Model.Client;
import com.example.helpcasamobile.R;

public class RegisterActivity extends AppCompatActivity {

    RadioButton chkMr;
    RadioButton chkMme;
    RadioButton chkMlle;
    long res;
    ClientDataExchange CDE = new ClientDataExchange(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        chkMr = findViewById(R.id.RBMr);
        chkMme = findViewById(R.id.RBMme);
        chkMlle = findViewById(R.id.RBMlle);

        Button validateAccountCreation = findViewById(R.id.btnValidClt);
        validateAccountCreation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = ((EditText) findViewById(R.id.editTextEmail)).getText().toString();
                String psswrd = ((EditText) findViewById(R.id.editTextPassword)).getText().toString();
                String civilite;
                if (chkMr.isChecked()) {
                    civilite = "M.";
                } else if (chkMme.isChecked()) {
                    civilite = "Mme";
                } else if (chkMlle.isChecked()) {
                    civilite = "Mlle";
                }else {
                    civilite ="Sté";
                }
                String nom = ((EditText) findViewById(R.id.editTextName)).getText().toString();
                String prenom = ((EditText) findViewById(R.id.editTextPrenom)).getText().toString();
                String RS = ((EditText) findViewById(R.id.editTextRaisonSociale)).getText().toString();
                String adresse = ((EditText) findViewById(R.id.editTextAdresse)).getText().toString();
                String ville = ((EditText) findViewById(R.id.editTextVille)).getText().toString();
                String cp = ((EditText) findViewById(R.id.editTextCP)).getText().toString();
                String tm = ((EditText) findViewById(R.id.editTextTelMobil)).getText().toString();
                String tf = ((EditText) findViewById(R.id.editTextTelFix)).getText().toString();

                Client clt = new Client(email, psswrd, civilite, nom, prenom, RS, adresse, ville, cp, tm, tf);
                if (ClientDataExchange.emailExists(email)) {
                    // Si l'email existe déjà
                    res = 23;
                }else{
                    res = ClientDataExchange.addClient(clt);
                    goToMainActivity();
                }
            }

            private void goToMainActivity() {
                if (res == -1) {
                    setResult(RESULT_OK);
                } else if (res == 0) {
                    setResult(RESULT_CANCELED);
                } else if (res == 1) {
                    setResult(RESULT_FIRST_USER);
                } else {
                    setResult(23);
                }
                finish();
            }

        });
    }
}
