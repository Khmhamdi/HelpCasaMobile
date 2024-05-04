package com.example.helpcasamobile.Adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.helpcasamobile.Model.Client;
import com.example.helpcasamobile.Agence.ProfileClient;
import com.example.helpcasamobile.R;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder> {

    private Context context;
    private List<Client> listClt;

    public ClientAdapter(Context context, List<Client> listClt) {
        this.context=context;
        this.listClt = listClt;
    }

    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerviewclient, parent, false);
        return new ClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, @SuppressLint("RecyclerView") int position) {

        if (listClt.isEmpty()) {
            // Si la liste est vide, afficher un message
            holder.tvIdClient.setText("Aucun client disponible");
            holder.tvEmailClient.setVisibility(View.GONE);
            holder.tvCiviliteClient.setVisibility(View.GONE);
            holder.tvNomClient.setVisibility(View.GONE);
            holder.tvPrenomClient.setVisibility(View.GONE);
        } else {

            final Client client = listClt.get(position);

            String idStr = String.valueOf(client.getIdClient());
            holder.tvIdClient.setText(idStr);
            holder.tvEmailClient.setText(client.getEmail());
            holder.tvCiviliteClient.setText(client.getCivilite());
            holder.tvNomClient.setText(client.getNom());
            holder.tvPrenomClient.setText(client.getPrenom());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ProfileClient.class);
                    // Passer les données du client via l'intent
                    intent.putExtra("id", idStr);
                    intent.putExtra("email", client.getEmail());
                    intent.putExtra("civilite", client.getCivilite());
                    intent.putExtra("nom", client.getNom());
                    intent.putExtra("prenom", client.getPrenom());
                    intent.putExtra("rs", client.getRaisonSociale());
                    intent.putExtra("adrs", client.getAdresse());
                    intent.putExtra("ville", client.getVille());
                    intent.putExtra("cp", client.getCp());
                    intent.putExtra("tm", client.getTelMobile());
                    intent.putExtra("tf", client.getTelFix());
                    // Démarrer l'activité ProfileClient
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listClt.size();
    }

    public static class ClientViewHolder extends RecyclerView.ViewHolder {
        TextView tvIdClient, tvEmailClient, tvCiviliteClient, tvNomClient, tvPrenomClient;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdClient = itemView.findViewById(R.id.tvIdCltrv);
            tvEmailClient = itemView.findViewById(R.id.tvEmailClient);
            tvCiviliteClient=itemView.findViewById(R.id.tvCiviliteClient);
            tvNomClient=itemView.findViewById(R.id.tvNomClient);
            tvPrenomClient=itemView.findViewById(R.id.tvPrenomClient);
        }
    }
}


