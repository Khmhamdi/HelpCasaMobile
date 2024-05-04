package com.example.helpcasamobile.Client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpcasamobile.Adapters.LogementAdapterClient;
import com.example.helpcasamobile.ManipData.LogementDataExchange;
import com.example.helpcasamobile.Model.Logement;
import com.example.helpcasamobile.R;
import com.example.helpcasamobile.Agence.RechercheLogement;

import java.util.List;

public class ListImmobiliersClient extends AppCompatActivity {
    int idClt;
    RecyclerView recyclerViewImmobilier;
    RecyclerView.LayoutManager layoutManager;
    LogementAdapterClient logementAdapterClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_immobilier_client);

        Intent intent = getIntent();
        if (intent != null) {
            idClt = intent.getIntExtra("id",0);
        }
        ((TextView) findViewById(R.id.idCltListImmo)).setText(String.valueOf(idClt));

        LogementDataExchange LDE = new LogementDataExchange(this);
        recyclerViewImmobilier = findViewById(R.id.rcvImmoClt);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewImmobilier.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewImmobilier.getContext(), DividerItemDecoration.VERTICAL);
        recyclerViewImmobilier.addItemDecoration(dividerItemDecoration);

        // Get the list of clients from ClientDataExchange
        List<Logement> listLgm = LogementDataExchange.getAllLogements();

        // Check if the list of clients is not empty
        if (!listLgm.isEmpty() && listLgm != null) {
            // Create and set up the adapter
            logementAdapterClient = new LogementAdapterClient(this, listLgm);
            recyclerViewImmobilier.setAdapter(logementAdapterClient);
            Toast.makeText(this, "Nombre de logements trouvés : "+listLgm.size(), Toast.LENGTH_SHORT).show();
        } else {
            // Show a message indicating no clients found
            Toast.makeText(this, "Aucun logement trouvé.", Toast.LENGTH_SHORT).show();
        }

        Button rechercher = findViewById(R.id.btnRechClt);

        rechercher.setOnClickListener(new View.OnClickListener() {
            Intent intent;
            @Override
            public void onClick(View v) {
                intent = new Intent(ListImmobiliersClient.this, RechercheLogement.class);
                startActivity(intent);
            }
        });

        ((ImageView) findViewById(R.id.homeClt)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListImmobiliersClient.this, PageAccueil.class);
                startActivity(intent);
            }
        });

    }
}