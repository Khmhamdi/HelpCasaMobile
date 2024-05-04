package com.example.helpcasamobile.Client;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helpcasamobile.ManipData.LogementDataExchange;
import com.example.helpcasamobile.R;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DetailsAnnonce extends AppCompatActivity implements View.OnClickListener {
    TextView idLgm, typLgm, typAnn, superf, nbChm, gouv, ville, adrs, desc, prix, dtAnn, valid, idProp, etat;
    CheckBox chkMeuble;
    ImageView img;
    LogementDataExchange LDE = new LogementDataExchange(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details_annonce);

        findViewById(R.id.btnAnnulerDA).setOnClickListener(this);
        Button boutonReserver = findViewById(R.id.btnReservDA);

        idLgm = findViewById(R.id.tvIdDA);
        typLgm = findViewById(R.id.tvTypLgmDA);
        typAnn = findViewById(R.id.tvTypAnnDA);
        superf = findViewById(R.id.tvSuperficieDA);
        nbChm = findViewById(R.id.tvNbrChambreDA);
        gouv = findViewById(R.id.tvGouvernoratDA);
        ville = findViewById(R.id.tvVilleDA);
        adrs = findViewById(R.id.tvAdresseDA);
        desc = findViewById(R.id.tvDescriptionDA);
        prix = findViewById(R.id.tvPrixDA);
        dtAnn = findViewById(R.id.tvDtAnnonceDA);
        valid = findViewById(R.id.tvValiditeDA);
        chkMeuble = findViewById(R.id.chkMeublDA);
        idProp = findViewById(R.id.tvIdPropDA);
        img = findViewById(R.id.image_viewDA);
        etat = findViewById(R.id.etatDA);

        Intent intent = getIntent();
        if (intent != null) {

            String meubleIntent = intent.getStringExtra("meuble");
            String imgIntent = intent.getStringExtra("img");

            // Utiliser les données récupérées pour initialiser les vues de votre activité

            idLgm.setText(intent.getStringExtra("id"));
            typLgm.setText(intent.getStringExtra("typLgm"));
            typAnn.setText(intent.getStringExtra("typAnn"));
            gouv.setText(intent.getStringExtra("gouv"));
            ville.setText(intent.getStringExtra("ville"));
            superf.setText(intent.getStringExtra("sup"));
            nbChm.setText(intent.getStringExtra("nbCh"));
            adrs.setText(intent.getStringExtra("adrs"));
            desc.setText(intent.getStringExtra("desc"));
            prix.setText(intent.getStringExtra("prix"));
            dtAnn.setText(intent.getStringExtra("dtAnn"));
            valid.setText(intent.getStringExtra("valid"));
            idProp.setText(intent.getStringExtra("idClt"));
            etat.setText(intent.getStringExtra("etat"));

            if (meubleIntent.equals("oui")) {
                chkMeuble.setChecked(true);
            }else{
                chkMeuble.setChecked(false);
            }

            if(imgIntent!=null && !imgIntent.isEmpty()){
                Picasso.get().load(imgIntent).into(img);
            }

        }

        String etatAnn= ((TextView) findViewById(R.id.etatDA)).getText().toString();
        if(etatAnn.equals("Réservé(e)")|| etatAnn.equals("Cloturée")) {
            boutonReserver.setEnabled(false);
        }


        boutonReserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(DetailsAnnonce.this);
                builder.setTitle("Veuillez confirmer votre ID ici svp!");

                final EditText input = new EditText(DetailsAnnonce.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        int idClientAch = Integer.parseInt(input.getText().toString());
                        int idLgmReq = Integer.parseInt(((TextView) findViewById(R.id.tvIdDA)).getText().toString());
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String dateReserv = dateFormat.format(calendar.getTime());

                        String etat ="Réservé(e)";
                        LogementDataExchange.reserverAnnonce(idLgmReq,idClientAch,dateReserv,etat);
                        finish();
                        startActivity(getIntent());


                    }
                });
                builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                // Afficher la boîte de dialogue
                builder.show();
            }
        });


    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnAnnulerDA){
            Intent intent = new Intent(this, ListImmobiliersClient.class);
            startActivity(intent);
        }
    }
}


