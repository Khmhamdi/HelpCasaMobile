package com.example.helpcasamobile.Agence;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helpcasamobile.ManipData.ClientDataExchange;
import com.example.helpcasamobile.Model.Client;
import com.example.helpcasamobile.R;

public class ProfileClient extends AppCompatActivity implements View.OnClickListener{
    int idClReq;
    String civlreq;
    String nomreq;
    String prenreq;
    String rsreq;
    String adrsreq;
    String vilreq;
    String cpreq;
    String tmreq;
    String tfreq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_client);

        findViewById(R.id.etIdClient).setVisibility(View.GONE);
        findViewById(R.id.etEmail).setEnabled(false);
        // Récupérer les données du client depuis l'intent
        String id = getIntent().getStringExtra("id");
        String email = getIntent().getStringExtra("email");
        String civilite = getIntent().getStringExtra("civilite");
        String nom = getIntent().getStringExtra("nom");
        String prenom = getIntent().getStringExtra("prenom");
        String rs = getIntent().getStringExtra("rs");
        String adrs = getIntent().getStringExtra("adrs");
        String ville = getIntent().getStringExtra("ville");
        String cp = getIntent().getStringExtra("cp");
        String tm = getIntent().getStringExtra("tm");
        String tf = getIntent().getStringExtra("tf");

        // Récupérer les références des EditText dans le layout
        // Définir le texte pour chaque EditText avec les données récupérées
        ((TextView) findViewById(R.id.etIdClient)).setText(id);
        ((EditText) findViewById(R.id.etEmail)).setText(email);
        ((EditText) findViewById(R.id.etCivilite)).setText(civilite);
        ((EditText) findViewById(R.id.etNom)).setText(nom);
        ((EditText) findViewById(R.id.etPrenom)).setText(prenom);
        ((EditText) findViewById(R.id.etRaisonSociale)).setText(rs);
        ((EditText) findViewById(R.id.etAdresse)).setText(adrs);
        ((EditText) findViewById(R.id.etVille)).setText(ville);
        ((EditText) findViewById(R.id.etCp)).setText(cp);
        ((EditText) findViewById(R.id.etTelMobile)).setText(tm);
        ((EditText) findViewById(R.id.etTelFix)).setText(tf);

        //Récupération des informations si une modification est effectuée
        //String idclreq = findViewById(R.id.etIdClient).toString();

        // Récupération des valeurs des EditText et stockage dans les variables de classe

        findViewById(R.id.btnModClt).setOnClickListener(this);
        findViewById(R.id.btnSupClt).setOnClickListener(this);
        findViewById(R.id.btnAnnulClt).setOnClickListener(this);
        findViewById(R.id.homeCl).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        idClReq = Integer.parseInt(((TextView) findViewById(R.id.etIdClient)).getText().toString());
        civlreq = ((EditText) findViewById(R.id.etCivilite)).getText().toString();
        nomreq = ((EditText) findViewById(R.id.etNom)).getText().toString();
        prenreq = ((EditText) findViewById(R.id.etPrenom)).getText().toString();
        rsreq = ((EditText) findViewById(R.id.etRaisonSociale)).getText().toString();
        adrsreq = ((EditText) findViewById(R.id.etAdresse)).getText().toString();
        vilreq = ((EditText) findViewById(R.id.etVille)).getText().toString();
        cpreq = ((EditText) findViewById(R.id.etCp)).getText().toString();
        tmreq = ((EditText) findViewById(R.id.etTelMobile)).getText().toString();
        tfreq = ((EditText) findViewById(R.id.etTelFix)).getText().toString();
        Client clt = new Client(civlreq,nomreq,prenreq,rsreq,adrsreq,vilreq,cpreq,tmreq,tfreq);
        Intent intent;

        if(v.getId()==R.id.btnModClt){
            int res = ClientDataExchange.updateClient(idClReq, clt);
            if (res !=0){
                Toast.makeText(this, "Mise à jour avec succès ", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, ListClient.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "Problème dans la mise à jour ", Toast.LENGTH_SHORT).show();
            }
        }

        if(v.getId()==R.id.btnSupClt){
            showDeleteConfirmationDialog();
        }

        if(v.getId()==R.id.btnAnnulClt){
            intent = new Intent(this, ListClient.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.homeCl){
            intent = new Intent(this, AccueilAgency.class);
            startActivity(intent);
        }

    }

    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation de suppression");
        builder.setMessage("Voulez-vous vraiment supprimer cet élément ?");
        builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Effectuer la suppression
                int res = ClientDataExchange.deleteClient(idClReq);
                if (res != 0) {
                    Toast.makeText(ProfileClient.this, "Suppression avec succès", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ProfileClient.this, ListClient.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ProfileClient.this, "Problème de suppression", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss(); // Fermer la boîte de dialogue
            }
        });
        builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Fermer la boîte de dialogue
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}