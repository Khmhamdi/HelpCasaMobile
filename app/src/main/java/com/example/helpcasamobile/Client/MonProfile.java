package com.example.helpcasamobile.Client;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.helpcasamobile.ManipData.ClientDataExchange;
import com.example.helpcasamobile.Model.Client;
import com.example.helpcasamobile.R;

public class MonProfile extends AppCompatActivity implements View.OnClickListener {
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
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ClientDataExchange CDE = new ClientDataExchange(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mon_profile);

        Intent intent = getIntent();
        if (intent != null) {
            idClReq = intent.getIntExtra("id",0);
        }
        Client clt = ClientDataExchange.searchClient(idClReq);
        //int idInt = clt.getIdClient();
        ((TextView) findViewById(R.id.etIdClientPr)).setText(String.valueOf(idClReq));
        ((EditText) findViewById(R.id.etEmailPr)).setText(clt.getEmail());
        ((EditText) findViewById(R.id.etCivilitePr)).setText(clt.getCivilite());
        ((EditText) findViewById(R.id.etNomPr)).setText(clt.getNom());
        ((EditText) findViewById(R.id.etPrenomPr)).setText(clt.getPrenom());
        ((EditText) findViewById(R.id.etRaisonSocialePr)).setText(clt.getRaisonSociale());
        ((EditText) findViewById(R.id.etAdressePr)).setText(clt.getAdresse());
        ((EditText) findViewById(R.id.etVillePr)).setText(clt.getVille());
        ((EditText) findViewById(R.id.etCpPr)).setText(clt.getCp());
        ((EditText) findViewById(R.id.etTelMobilePr)).setText(clt.getTelMobile());
        ((EditText) findViewById(R.id.etTelFixPr)).setText(clt.getTelFix());

        //Verrouillage des champs de saisie
        ((EditText) findViewById(R.id.etEmailPr)).setEnabled(false);
        ((EditText) findViewById(R.id.etCivilitePr)).setEnabled(false);
        ((EditText) findViewById(R.id.etNomPr)).setEnabled(false);
        ((EditText) findViewById(R.id.etPrenomPr)).setEnabled(false);
        ((EditText) findViewById(R.id.etRaisonSocialePr)).setEnabled(false);
        ((EditText) findViewById(R.id.etAdressePr)).setEnabled(false);
        ((EditText) findViewById(R.id.etVillePr)).setEnabled(false);
        ((EditText) findViewById(R.id.etCpPr)).setEnabled(false);
        ((EditText) findViewById(R.id.etTelMobilePr)).setEnabled(false);
        ((EditText) findViewById(R.id.etTelFixPr)).setEnabled(false);

        //Les écouteurs des boutons
        ((ImageView) findViewById(R.id.homePr)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnModCltPr)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnValCltPr)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnAnnulCltPr)).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent;

        if(v.getId()==R.id.btnAnnulCltPr){
            Client clt = ClientDataExchange.searchClient(idClReq);
            //Reset Les valeurs par défaut valeurs base de données
            ((TextView) findViewById(R.id.etIdClientPr)).setText(String.valueOf(idClReq));
            ((EditText) findViewById(R.id.etEmailPr)).setText(clt.getEmail());
            ((EditText) findViewById(R.id.etCivilitePr)).setText(clt.getCivilite());
            ((EditText) findViewById(R.id.etNomPr)).setText(clt.getNom());
            ((EditText) findViewById(R.id.etPrenomPr)).setText(clt.getPrenom());
            ((EditText) findViewById(R.id.etRaisonSocialePr)).setText(clt.getRaisonSociale());
            ((EditText) findViewById(R.id.etAdressePr)).setText(clt.getAdresse());
            ((EditText) findViewById(R.id.etVillePr)).setText(clt.getVille());
            ((EditText) findViewById(R.id.etCpPr)).setText(clt.getCp());
            ((EditText) findViewById(R.id.etTelMobilePr)).setText(clt.getTelMobile());
            ((EditText) findViewById(R.id.etTelFixPr)).setText(clt.getTelFix());

            //Verrouillage des champs de saisie
            ((EditText) findViewById(R.id.etCivilitePr)).setEnabled(false);
            ((EditText) findViewById(R.id.etNomPr)).setEnabled(false);
            ((EditText) findViewById(R.id.etPrenomPr)).setEnabled(false);
            ((EditText) findViewById(R.id.etRaisonSocialePr)).setEnabled(false);
            ((EditText) findViewById(R.id.etAdressePr)).setEnabled(false);
            ((EditText) findViewById(R.id.etVillePr)).setEnabled(false);
            ((EditText) findViewById(R.id.etCpPr)).setEnabled(false);
            ((EditText) findViewById(R.id.etTelMobilePr)).setEnabled(false);
            ((EditText) findViewById(R.id.etTelFixPr)).setEnabled(false);
        }

        if(v.getId()==R.id.homePr){
            intent = new Intent(this, PageAccueil.class);
            intent.putExtra("id",idClReq);
            startActivity(intent);
        }

        if(v.getId()==R.id.btnModCltPr){
            ((EditText) findViewById(R.id.etCivilitePr)).setEnabled(true);
            ((EditText) findViewById(R.id.etNomPr)).setEnabled(true);
            ((EditText) findViewById(R.id.etPrenomPr)).setEnabled(true);
            ((EditText) findViewById(R.id.etRaisonSocialePr)).setEnabled(true);
            ((EditText) findViewById(R.id.etAdressePr)).setEnabled(true);
            ((EditText) findViewById(R.id.etVillePr)).setEnabled(true);
            ((EditText) findViewById(R.id.etCpPr)).setEnabled(true);
            ((EditText) findViewById(R.id.etTelMobilePr)).setEnabled(true);
            ((EditText) findViewById(R.id.etTelFixPr)).setEnabled(true);
        }

        if(v.getId()==R.id.btnValCltPr){
            Client clt = new Client();
            clt.setCivilite(((EditText) findViewById(R.id.etCivilitePr)).getText().toString());
            clt.setNom(((EditText) findViewById(R.id.etNomPr)).getText().toString());
            clt.setPrenom(((EditText) findViewById(R.id.etPrenomPr)).getText().toString());
            clt.setRaisonSociale(((EditText) findViewById(R.id.etRaisonSocialePr)).getText().toString());
            clt.setAdresse(((EditText) findViewById(R.id.etAdressePr)).getText().toString());
            clt.setVille(((EditText) findViewById(R.id.etVillePr)).getText().toString());
            clt.setCp(((EditText) findViewById(R.id.etCpPr)).getText().toString());
            clt.setTelMobile(((EditText) findViewById(R.id.etTelMobilePr)).getText().toString());
            clt.setTelFix(((EditText) findViewById(R.id.etTelFixPr)).getText().toString());
            if(clt != null){
                ClientDataExchange.updateClient(idClReq, clt);
                Toast.makeText(this, "modification avec succès", Toast.LENGTH_SHORT).show();
                ((EditText) findViewById(R.id.etCivilitePr)).setEnabled(false);
                ((EditText) findViewById(R.id.etNomPr)).setEnabled(false);
                ((EditText) findViewById(R.id.etPrenomPr)).setEnabled(false);
                ((EditText) findViewById(R.id.etRaisonSocialePr)).setEnabled(false);
                ((EditText) findViewById(R.id.etAdressePr)).setEnabled(false);
                ((EditText) findViewById(R.id.etVillePr)).setEnabled(false);
                ((EditText) findViewById(R.id.etCpPr)).setEnabled(false);
                ((EditText) findViewById(R.id.etTelMobilePr)).setEnabled(false);
                ((EditText) findViewById(R.id.etTelFixPr)).setEnabled(false);

            }else{
                Toast.makeText(this, "modification impossbile", Toast.LENGTH_SHORT).show();
            }

        }

    }
}