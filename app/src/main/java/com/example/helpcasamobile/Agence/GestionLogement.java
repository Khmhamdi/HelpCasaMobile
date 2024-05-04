package com.example.helpcasamobile.Agence;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helpcasamobile.ManipData.LogementDataExchange;
import com.example.helpcasamobile.Model.Logement;
import com.example.helpcasamobile.R;
import com.squareup.picasso.Picasso;

public class GestionLogement extends AppCompatActivity implements View.OnClickListener{
    private int idLgReq;
    private String typeLogementReq, typeAnnonceReq, gouvernoratReq, villeReq, adresseReq;
    private int superficieReq, nbrChambreReq;
    private String descriptionReq;
    private float prixReq;
    private String dtAnnonceReq;
    private int validiteReq, idPropReq;
    private String meubleReq, urlImgReq, etatReq;
    private int idAchetReq, idUserReq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gestion_logment);

        TextView idLgm = findViewById(R.id.idGl);

        RadioButton chkApp = findViewById(R.id.RBAppGl);
        RadioButton chkVilla = findViewById(R.id.RBVillaGl);
        RadioButton chkTr = findViewById(R.id.RBTrGl);
        RadioButton chkBur = findViewById(R.id.RBBurGl);
        RadioButton chkLc = findViewById(R.id.RBLCGl);
        RadioButton chkVt = findViewById(R.id.RBVTGl);

        EditText superf = findViewById(R.id.etSuperficieGl);
        EditText nbChm = findViewById(R.id.etNbrChambreGl);
        EditText gouve = findViewById(R.id.etGouvernoratGl);
        EditText vill = findViewById(R.id.etVilleGl);
        EditText adrss = findViewById(R.id.etAdresseGl);
        EditText descp =findViewById(R.id.etDescriptionGl);
        EditText prx = findViewById(R.id.etPrixGl);
        EditText ann = findViewById(R.id.etDtAnnonceGl);
        EditText val = findViewById(R.id.etValiditeGl);
        EditText idPrp = findViewById(R.id.etIdPropGl);
        TextView etat = findViewById(R.id.etatGL);

        CheckBox chkMbl = findViewById(R.id.chkMeublGl);

        EditText urlimg = findViewById(R.id.editTextUrlGl);


        ImageView imageView = findViewById(R.id.image_viewGl);

        Intent intent = getIntent();
        if (intent != null) {
            String id = intent.getStringExtra("id");
            String typLgm = intent.getStringExtra("typLgm");
            String typAnn = intent.getStringExtra("typAnn");
            String gouv = intent.getStringExtra("gouv");
            String ville = intent.getStringExtra("ville");
            String adrs = intent.getStringExtra("adrs");
            String sup = intent.getStringExtra("sup");
            String nbCh = intent.getStringExtra("nbCh");
            String desc = intent.getStringExtra("desc");
            String prix = intent.getStringExtra("prix");
            String dtAnn = intent.getStringExtra("dtAnn");
            String valid = intent.getStringExtra("valid");
            String idProp = intent.getStringExtra("idProp");
            String meuble = intent.getStringExtra("meuble");
            String img = intent.getStringExtra("img");
            String eta = intent.getStringExtra("etat");

            // Utiliser les données récupérées pour initialiser les vues de votre activité

            idLgm.setText(id);

            if (typLgm.equals("Appartement")) {
                chkApp.setChecked(true);
            } else if (typLgm.equals("Villa")) {
                chkVilla.setChecked(true);
            } else if (typLgm.equals("Terrain")) {
                chkTr.setChecked(true);
            }else {
                chkBur.setChecked(true);
            }

            if (typAnn.equals("Location")) {
                chkLc.setChecked(true);
            }else {
                chkVt.setChecked(true);
            }

            superf.setText(sup);
            nbChm.setText(nbCh);
            gouve.setText(gouv);
            vill.setText(ville);
            adrss.setText(adrs);
            descp.setText(desc);
            prx.setText(prix);
            ann.setText(dtAnn);
            val.setText(valid);
            idPrp.setText(idProp);
            etat.setText(eta);

            if (meuble.equals("oui")) {
                chkMbl.setChecked(true);
            }else{
                chkMbl.setChecked(false);
            }
            if (img != null && !img.isEmpty()){
                urlimg.setText(img);
                Picasso.get().load(img).into(imageView);
            }

        }

        ((Button) findViewById(R.id.btnEnregistrerGl)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnAnnulerGl)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnSuppGl)).setOnClickListener(this);

        String etatAnn= ((TextView) findViewById(R.id.etatGL)).getText().toString();
        if(etatAnn.equals("Réservé(e)")|| etatAnn.equals("Cloturée")) {
            ((Button) findViewById(R.id.btnSuppGl)).setEnabled(false);
            ((Button) findViewById(R.id.btnEnregistrerGl)).setEnabled(false);
        }

        EditText editTextUrl = findViewById(R.id.editTextUrlGl);
        Button buttonLoad = findViewById(R.id.buttonLoadGl);

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

        RadioButton chkApp = findViewById(R.id.RBAppGl);
        RadioButton chkVilla = findViewById(R.id.RBVillaGl);
        RadioButton chkTr = findViewById(R.id.RBTrGl);
        RadioButton chkBur = findViewById(R.id.RBBurGl);

        RadioButton chkLc = findViewById(R.id.RBLCGl);
        RadioButton chkVt = findViewById(R.id.RBVTGl);

        CheckBox chkMblReq = findViewById(R.id.chkMeublGl);

        idLgReq = Integer.parseInt(((TextView) findViewById(R.id.idGl)).getText().toString());


        if (chkApp.isChecked()) {
            typeLogementReq = "Appartement";
        } else if (chkVilla.isChecked()) {
            typeLogementReq = "Villa";
        } else if (chkTr.isChecked()) {
            typeLogementReq = "Terrain";
        }else {
            typeLogementReq ="Bureau";
        }

        if (chkLc.isChecked()) {
            typeAnnonceReq = "Location";
        } else {
            typeAnnonceReq ="Vente";
        }

        gouvernoratReq = ((EditText) findViewById(R.id.etGouvernoratGl)).getText().toString();
        villeReq = ((EditText) findViewById(R.id.etVilleGl)).getText().toString();
        adresseReq = ((EditText) findViewById(R.id.etAdresseGl)).getText().toString();
        superficieReq = Integer.parseInt(((EditText) findViewById(R.id.etSuperficieGl)).getText().toString());
        nbrChambreReq = Integer.parseInt(((EditText) findViewById(R.id.etNbrChambreGl)).getText().toString());
        descriptionReq = ((EditText) findViewById(R.id.etDescriptionGl)).getText().toString();
        prixReq = Float.parseFloat(((EditText) findViewById(R.id.etPrixGl)).getText().toString());
        dtAnnonceReq = ((EditText) findViewById(R.id.etDtAnnonceGl)).getText().toString();
        validiteReq = Integer.parseInt(((EditText) findViewById(R.id.etValiditeGl)).getText().toString());
        idPropReq = Integer.parseInt(((EditText) findViewById(R.id.etIdPropGl)).getText().toString());
        etatReq=((TextView) findViewById(R.id.etatGL)).getText().toString();
        if(chkMblReq.isChecked()){
            meubleReq = "oui";
        }else{
            meubleReq = "non";
        }


        if((((EditText) findViewById(R.id.editTextUrlGl)).getText().toString()) != null){
            urlImgReq = ((EditText) findViewById(R.id.editTextUrlGl)).getText().toString();
        }else{
            urlImgReq="None";
        }
        idAchetReq = 0;
        idUserReq = 0;
        Logement lgmReq = new Logement(typeLogementReq,typeAnnonceReq,gouvernoratReq,villeReq,adresseReq,superficieReq,nbrChambreReq,descriptionReq,prixReq,dtAnnonceReq,validiteReq,idPropReq,idAchetReq,meubleReq,urlImgReq,etatReq,idUserReq);


        Intent intent;
        if(v.getId()==R.id.btnEnregistrerGl){
            int res = LogementDataExchange.updateLogement(idLgReq, lgmReq);
            if (res !=0){
                Toast.makeText(this, "Mise à jour avec succès ", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, ListImmobiliers.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "Problème dans la mise à jour ", Toast.LENGTH_SHORT).show();
            }
        }

        if(v.getId()==R.id.btnAnnulerGl){
            intent = new Intent(this, ListImmobiliers.class);
            startActivity(intent);
        }

        if(v.getId()==R.id.btnSuppGl){
            showDeleteConfirmationDialog();
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
                int res = LogementDataExchange.deleteLogement(idLgReq);
                if (res != 0) {
                    Toast.makeText(GestionLogement.this, "Suppression avec succès", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(GestionLogement.this, ListImmobiliers.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(GestionLogement.this, "Problème de suppression", Toast.LENGTH_SHORT).show();
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