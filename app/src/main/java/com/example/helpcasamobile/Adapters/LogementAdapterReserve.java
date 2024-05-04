package com.example.helpcasamobile.Adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpcasamobile.Agence.ListImmobiliersReserves;
import com.example.helpcasamobile.ManipData.LogementDataExchange;
import com.example.helpcasamobile.Model.Logement;
import com.example.helpcasamobile.R;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class LogementAdapterReserve extends RecyclerView.Adapter<LogementAdapterReserve.ImmobilierViewHolder>{

    private Context context;
    private List<Logement> listLgm;
    float commission;
    float commProp, commAchet;

    public LogementAdapterReserve(Context context, List<Logement> listLgm) {
        this.context = context;
        this.listLgm = listLgm;
    }

    @NonNull
    @Override
    public LogementAdapterReserve.ImmobilierViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerviewlogment, parent, false);
        return new LogementAdapterReserve.ImmobilierViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ImmobilierViewHolder holder, @SuppressLint("RecyclerView") int position) {

        if(listLgm.isEmpty()){

            holder.tvIdLgm.setText("Aucun Bien disponible");
            holder.tvTypLgm.setVisibility(View.GONE);
            holder.tvTypAnn.setVisibility(View.GONE);
            holder.tvGouvern.setVisibility(View.GONE);
            holder.imvLgm.setVisibility(View.GONE);
        }else {
            final Logement lgm = listLgm.get(position);

            String idStr = String.valueOf(lgm.getIdLogement());
            String img = String.valueOf(lgm.getImage());
            holder.tvIdLgm.setText(idStr);
            holder.tvTypLgm.setText(lgm.getTypeLogement());
            holder.tvTypAnn.setText(lgm.getTypeAnnonce());
            holder.tvGouvern.setText(lgm.getGouvernorat());

            if (img != null && !img.isEmpty()) {
                Picasso.get().load(img).into(holder.imvLgm);
            }

            if(lgm.getEtat().equals("Réservé(e)")){
                holder.btnValiderAnn.setVisibility(View.VISIBLE);
                holder.btnAnnulerAnn.setVisibility(View.VISIBLE);
            }

            //Code du click sur le bouton valider
            holder.btnValiderAnn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    float montant= lgm.getPrix();

                    if(lgm.getTypeAnnonce().equals("Location")){

                        if(montant>0 && montant<=300){
                            commission = (float) (montant*0.05);
                            commProp = commission;
                            commAchet=commission;

                        } else if (montant>300 && montant<=500) {
                            commission = (float) (montant*0.1);
                            commProp = commission;
                            commAchet=commission;

                        }else{
                            commission = (float) (montant*0.15);
                            commProp = commission;
                            commAchet=commission;
                        }
                    }
                    if(lgm.getTypeAnnonce().equals("Vente")){
                        if(montant>0 && montant<=100000){
                            commission = (float) (montant*0.01);
                            commProp = commission*2/3;
                            commAchet=commission*1/3;

                        } else if (montant>100000 && montant<=300000) {
                            commission = (float) (montant*0.02);
                            commProp = commission*2/3;
                            commAchet=commission*1/3;

                        }else{
                            commission = (float) (montant*0.03);
                            commProp = commission*2/3;
                            commAchet=commission*1/3;
                        }
                    }
                    //Enregistrement des commissions calculées
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Veuillez confirmer votre ID ici svp!");

                    final EditText input = new EditText(context);
                    input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    builder.setView(input);

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int idLgm = lgm.getIdLogement();
                            int idAgent = Integer.parseInt(input.getText().toString());
                            Calendar calendar = Calendar.getInstance();
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            String dateValidation = dateFormat.format(calendar.getTime());
                            String etat = "Cloturée";

                            //Modification de l'etat à cloturée
                            LogementDataExchange.validerOperation(idLgm,idAgent,dateValidation,commProp,commAchet,etat);

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

            //Code du click sur le bouton annuler
            holder.btnAnnulerAnn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LogementDataExchange.updateEtatLogement(Integer.parseInt(idStr),"En cours");

                }
            });


/*            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, GestionLogement.class);

                    // Passer les données du client via l'intent
                    intent.putExtra("id", idStr);
                    intent.putExtra("typLgm", lgm.getTypeLogement());
                    intent.putExtra("typAnn", lgm.getTypeAnnonce());
                    intent.putExtra("gouv", lgm.getGouvernorat());
                    intent.putExtra("ville", lgm.getVille());
                    intent.putExtra("adrs", lgm.getAdresse());
                    intent.putExtra("sup", String.valueOf(lgm.getSuperficie()));
                    intent.putExtra("nbCh", String.valueOf(lgm.getNbrChambre()));
                    intent.putExtra("desc", lgm.getDescription());
                    intent.putExtra("prix", String.valueOf(lgm.getPrix()));
                    intent.putExtra("dtAnn", lgm.getDtAnnonce());
                    intent.putExtra("valid", String.valueOf(lgm.getValidite()));
                    intent.putExtra("idClt", String.valueOf(lgm.getIdClient()));
                    intent.putExtra("meuble", lgm.getMeuble());
                    intent.putExtra("img", lgm.getImage());
                    intent.putExtra("etat", lgm.getEtat());


                    context.startActivity(intent);
                }
            });*/
        }
    }

    @Override
    public int getItemCount() {
        return listLgm.size();
    }

    public static class ImmobilierViewHolder extends RecyclerView.ViewHolder{
        TextView tvIdLgm, tvTypLgm, tvTypAnn, tvGouvern;
        ImageView imvLgm;
        Button btnValiderAnn, btnAnnulerAnn;

        public ImmobilierViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdLgm = itemView.findViewById(R.id.tvIdLgmrv);
            tvTypLgm = itemView.findViewById(R.id.tvTypLgm);
            tvTypAnn = itemView.findViewById(R.id.tvTypAnn);
            tvGouvern = itemView.findViewById(R.id.tvGouvern);
            imvLgm = itemView.findViewById(R.id.imUriLgm);
            btnValiderAnn = itemView.findViewById(R.id.btnValidReserv);
            btnAnnulerAnn = itemView.findViewById(R.id.btnAnnulReserv);


        }
    }
}