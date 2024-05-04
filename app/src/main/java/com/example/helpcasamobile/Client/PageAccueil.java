package com.example.helpcasamobile.Client;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helpcasamobile.Client.ListImmobiliersClient;
import com.example.helpcasamobile.R;


public class PageAccueil extends AppCompatActivity implements View.OnClickListener{
    int idClt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page_accueil);
        Toast.makeText(this, "Bienvenue", Toast.LENGTH_SHORT).show();

        ((Button) findViewById(R.id.btnListImmo)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnProfile)).setOnClickListener(this);

        Intent intent = getIntent();
        if (intent != null) {
            idClt = intent.getIntExtra("id",0);
        }
        ((TextView) findViewById(R.id.idCltPA)).setText(String.valueOf(idClt));
    }

    @Override
    public void onClick(View v) {

        int idCltInt = Integer.parseInt(((TextView) findViewById(R.id.idCltPA)).getText().toString());
        Intent intent;

        if(v.getId()==R.id.btnListImmo){
            intent = new Intent(this, ListImmobiliersClient.class);
            intent.putExtra("id", idCltInt);
            startActivity(intent);
        }

        if(v.getId()==R.id.btnProfile){
            intent = new Intent(this, MonProfile.class);
            intent.putExtra("id", idCltInt);
            startActivity(intent);
        }

        }
}