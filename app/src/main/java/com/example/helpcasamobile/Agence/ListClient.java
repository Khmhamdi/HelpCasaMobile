package com.example.helpcasamobile.Agence;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.helpcasamobile.Adapters.ClientAdapter;
import com.example.helpcasamobile.ManipData.ClientDataExchange;
import com.example.helpcasamobile.Model.Client;
import com.example.helpcasamobile.Client.PageAccueil;
import com.example.helpcasamobile.R;

import java.util.List;


public class ListClient extends AppCompatActivity{
    RecyclerView recyclerViewClient;
    RecyclerView.LayoutManager layoutManager;
    ClientAdapter clientAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ClientDataExchange CDE = new ClientDataExchange(this);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_client);

        recyclerViewClient = findViewById(R.id.rcvclients);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewClient.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewClient.getContext(), DividerItemDecoration.VERTICAL);
        recyclerViewClient.addItemDecoration(dividerItemDecoration);

        // Get the list of clients from ClientDataExchange
        List<Client> listClt = ClientDataExchange.getAllClients();

        // Check if the list of clients is not empty
        if (!listClt.isEmpty()) {
            // Create and set up the adapter
            clientAdapter = new ClientAdapter(this, listClt);
            recyclerViewClient.setAdapter(clientAdapter);
            Toast.makeText(this, "Nombre de clients trouvés : "+listClt.size(), Toast.LENGTH_SHORT).show();
        } else {
            // Show a message indicating no clients found
            Toast.makeText(this, "Aucun client trouvé.", Toast.LENGTH_SHORT).show();
        }

        findViewById(R.id.homeCl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListClient.this, PageAccueil.class);
                startActivity(intent);
            }
        });
    }
}



