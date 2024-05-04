package com.example.helpcasamobile.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpcasamobile.Agence.GestionLogement;
import com.example.helpcasamobile.Model.Logement;
import com.example.helpcasamobile.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RechercheLogementAdapter extends RecyclerView.Adapter<LogementAdapter.ImmobilierViewHolder> {
    private Context context;
    private List<Logement> listLgm;

    public RechercheLogementAdapter(Context context, List<Logement> listLgm) {
        this.context = context;
        this.listLgm = listLgm;
    }

    @NonNull
    @Override
    public LogementAdapter.ImmobilierViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerviewlogment, parent, false);
        return new LogementAdapter.ImmobilierViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LogementAdapter.ImmobilierViewHolder holder, @SuppressLint("RecyclerView") int position) {

        if (listLgm.isEmpty()) {

            holder.tvIdLgm.setText("Aucun Bien disponible");
            holder.tvTypLgm.setVisibility(View.GONE);
            holder.tvTypAnn.setVisibility(View.GONE);
            holder.tvGouvern.setVisibility(View.GONE);
            holder.imvLgm.setVisibility(View.GONE);
        } else {
            final Logement lgm = listLgm.get(position);

            String idStr = String.valueOf(lgm.getIdLogement());
            String img =lgm.getImage();
            holder.tvIdLgm.setText(idStr);
            holder.tvTypLgm.setText(lgm.getTypeLogement());
            holder.tvTypAnn.setText(lgm.getTypeAnnonce());
            holder.tvGouvern.setText(lgm.getGouvernorat());

            if (img != null && !img.isEmpty()) {
                Picasso.get().load(img).into(holder.imvLgm);
            } else {
                holder.imvLgm.setVisibility(View.GONE);
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
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
                    intent.putExtra("idClt", String.valueOf(lgm.getIdProp()));
                    intent.putExtra("meuble", lgm.getMeuble());
                    intent.putExtra("img", lgm.getImage());
                    intent.putExtra("etat", lgm.getEtat());

                    // Démarrer l'activité ProfileClient
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listLgm.size();
    }

    public void updateData(List<Logement> logements) {
        this.listLgm.clear();
        this.listLgm.addAll(logements);
        notifyDataSetChanged();
    }

    public static class ImmobilierViewHolder extends RecyclerView.ViewHolder {
        TextView tvIdLgm, tvTypLgm, tvTypAnn, tvGouvern;
        ImageView imvLgm;

        public ImmobilierViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdLgm = itemView.findViewById(R.id.tvIdLgmrv);
            tvTypLgm = itemView.findViewById(R.id.tvTypLgm);
            tvTypAnn = itemView.findViewById(R.id.tvTypAnn);
            tvGouvern = itemView.findViewById(R.id.tvGouvern);
            imvLgm = itemView.findViewById(R.id.imUriLgm);


        }
    }
}