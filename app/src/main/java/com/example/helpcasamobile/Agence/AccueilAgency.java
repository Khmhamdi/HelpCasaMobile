package com.example.helpcasamobile.Agence;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helpcasamobile.R;
import com.example.helpcasamobile.Client.RegisterActivity;

public class AccueilAgency extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_accueil_agency);

        Toast.makeText(this, "Bienvenue", Toast.LENGTH_SHORT).show();

        findViewById(R.id.btnAjtClt).setOnClickListener(this);
        findViewById(R.id.btnLCAg).setOnClickListener(this);
        findViewById(R.id.btnAjtLgm).setOnClickListener(this);
        findViewById(R.id.btnListLgm).setOnClickListener(this);
        findViewById(R.id.btnImmoRes).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if(v.getId() == R.id.btnLCAg) {
            intent = new Intent(this, ListClient.class);
            startActivity(intent);
        }

        if(v.getId() == R.id.btnAjtLgm) {
            intent = new Intent(this, AjoutLogement.class);
            startActivity(intent);
        }

        if(v.getId() == R.id.btnAjtClt) {
            intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }

        if(v.getId() == R.id.btnListLgm) {
            intent = new Intent(this, ListImmobiliers.class);
            startActivity(intent);
        }

        if (v.getId()==R.id.btnImmoRes){
            intent = new Intent(this, ListImmobiliersReserves.class);
            startActivity(intent);
        }

    }
}