package com.example.helpcasamobile.Agence;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpcasamobile.Adapters.LogementAdapter;
import com.example.helpcasamobile.ManipData.LogementDataExchange;
import com.example.helpcasamobile.Model.Logement;
import com.example.helpcasamobile.R;

import java.util.List;

public class ListImmobiliers extends AppCompatActivity {
    RecyclerView recyclerViewImmobilier;
    RecyclerView.LayoutManager layoutManager;
    LogementAdapter logementAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_immobiliers);

        LogementDataExchange LDE = new LogementDataExchange(this);
        recyclerViewImmobilier = findViewById(R.id.rcvimmo);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewImmobilier.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewImmobilier.getContext(), DividerItemDecoration.VERTICAL);
        recyclerViewImmobilier.addItemDecoration(dividerItemDecoration);

        // Get the list of clients from ClientDataExchange
        List<Logement> listLgm = LogementDataExchange.getAllLogements();

        // Check if the list of clients is not empty
        if (!listLgm.isEmpty() && listLgm != null) {
            // Create and set up the adapter
            logementAdapter = new LogementAdapter(this, listLgm);
            recyclerViewImmobilier.setAdapter(logementAdapter);
            Toast.makeText(this, "Nombre de logements trouvés : "+listLgm.size(), Toast.LENGTH_SHORT).show();
        } else {
            // Show a message indicating no clients found
            Toast.makeText(this, "Aucun logement trouvé.", Toast.LENGTH_SHORT).show();
        }

        Button rechercher = findViewById(R.id.btnRechLgm);

        rechercher.setOnClickListener(new View.OnClickListener() {
            Intent intent;
            @Override
            public void onClick(View v) {
                intent = new Intent(ListImmobiliers.this, RechercheLogement.class);
                startActivity(intent);
            }
        });

        ((ImageView) findViewById(R.id.homeLgm)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListImmobiliers.this, AccueilAgency.class);
                startActivity(intent);
            }
        });


    }
}