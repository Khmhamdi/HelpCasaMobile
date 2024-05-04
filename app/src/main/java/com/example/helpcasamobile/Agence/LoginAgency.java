package com.example.helpcasamobile.Agence;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helpcasamobile.Agence.AccueilAgency;
import com.example.helpcasamobile.R;

public class LoginAgency extends AppCompatActivity implements View.OnClickListener {
    EditText login, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_agency);

        login = findViewById(R.id.etLgAg);
        pass = findViewById(R.id.etPassAg);

        findViewById(R.id.btnLoginAg).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
/*        if(v.getId()==R.id.btnLoginAg){
            if(login.getText().toString().equals("test@test.com") && pass.getText().toString().equals("123")){
                Toast.makeText(this, "Authentification avec succès", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, AccueilAgency.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Erreur authentification !!", Toast.LENGTH_SHORT).show();
            }
        }*/
        intent = new Intent(this, AccueilAgency.class);
        startActivity(intent);

    }
}