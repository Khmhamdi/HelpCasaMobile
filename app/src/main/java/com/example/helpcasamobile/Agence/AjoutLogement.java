package com.example.helpcasamobile.Agence;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.helpcasamobile.ManipData.LogementDataExchange;
import com.example.helpcasamobile.Model.Logement;
import com.example.helpcasamobile.R;
import com.squareup.picasso.Picasso;

public class AjoutLogement extends AppCompatActivity implements View.OnClickListener{

    private ImageView imageView;
    RadioButton chkVt,chkLc,chkApp,chkVilla,chkTr,chkBur;
    CheckBox chkMeubl;
    long res;
    private EditText editTextUrl;
    LogementDataExchange LDE = new LogementDataExchange(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ajout_logement);

        chkLc = findViewById(R.id.RBLC);
        chkVt = findViewById(R.id.RBVT);

        chkApp = findViewById(R.id.RBApp);
        chkVilla = findViewById(R.id.RBVilla);
        chkTr = findViewById(R.id.RBTr);
        chkBur = findViewById(R.id.RBBur);

        chkMeubl = findViewById(R.id.chkMeublAj);

        findViewById(R.id.btnEnregistrerLgm).setOnClickListener(this);
        findViewById(R.id.btnAnnulerLgm).setOnClickListener(this);

        imageView = findViewById(R.id.image_view);

        editTextUrl = findViewById(R.id.editTextUrl);
        Button buttonLoad = findViewById(R.id.buttonLoad);

        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editTextUrl.getText().toString();
                Picasso.get().load(url).into(imageView);
            }
        });

    }

    @Override
    public void onClick(View v) {
        String meuble;
        Intent intent;
        if(v.getId() == R.id.btnEnregistrerLgm){

            String typeLogement;
                if (chkApp.isChecked()) {
                    typeLogement = "Appartement";
                } else if (chkVilla.isChecked()) {
                    typeLogement = "Villa";
                } else if (chkTr.isChecked()) {
                    typeLogement = "Terrain";
                }else {
                    typeLogement ="Bureau";
                }
            String typeAnnonce;
                if (chkLc.isChecked()) {
                    typeAnnonce = "Location";
                } else {
                    typeAnnonce ="Vente";
                }
            String gouv = ((EditText) findViewById(R.id.etGouvernorat)).getText().toString();
            String ville = ((EditText) findViewById(R.id.etVilleLgm)).getText().toString();
            String adresse = ((EditText) findViewById(R.id.etAdresseLgm)).getText().toString();
            int superficie = Integer.parseInt(((EditText) findViewById(R.id.etSuperficie)).getText().toString());
            int nbrChm = Integer.parseInt(((EditText) findViewById(R.id.etNbrChambre)).getText().toString());
            String desc = ((EditText) findViewById(R.id.etDescription)).getText().toString();
            float prix = Float.parseFloat(((EditText) findViewById(R.id.etPrix)).getText().toString());
            String dtAnn = (((EditText) findViewById(R.id.etDtAnnonce)).getText().toString());
            int validite = Integer.parseInt(((EditText) findViewById(R.id.etValidite)).getText().toString());
            int idProp = Integer.parseInt(((EditText) findViewById(R.id.etIdPropLgm)).getText().toString());

            if(chkMeubl.isChecked()){
                meuble = "oui";
            }else{
                meuble = "non";
            }

            String imgURL =editTextUrl.getText().toString();
            if(imgURL == ""){
                imgURL="null";
            }

            Logement logement = new Logement(typeLogement,typeAnnonce,gouv,ville,adresse,superficie,nbrChm,desc,prix,dtAnn,validite,idProp,0,meuble,imgURL,"En cours",0);

            res = LogementDataExchange.addLogement(logement);
            if(res == -1){
                Toast.makeText(this, "Ajout avec succès", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Erreur dans l'ajout", Toast.LENGTH_SHORT).show();
            }

            intent = new Intent(this, ListImmobiliers.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.btnAnnulerLgm){
            intent = new Intent(this, AccueilAgency.class);
            startActivity(intent);
        }
    }
}