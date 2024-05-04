package com.example.helpcasamobile.Agence;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpcasamobile.Adapters.RechercheLogementAdapter;
import com.example.helpcasamobile.ManipData.LogementDataExchange;
import com.example.helpcasamobile.Model.Logement;
import com.example.helpcasamobile.R;

import java.util.ArrayList;
import java.util.List;



public class RechercheLogement extends AppCompatActivity {
    RecyclerView recyclerViewImmobilier;
    RecyclerView.LayoutManager layoutManager;
    RechercheLogementAdapter logementAdapter;
    private Spinner spinnerTypLgm, spinnerTypAnn, spinnerGouv, spinnerVilles, spinnerNbChm;
    private EditText etSrfMinRch, etSrfMaxRch, etPrixMinRch, etPrixMaxRch;
    private CheckBox chkMeublRch, chkPhotoRch;
    private ArrayList<String> villes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_logement);

        spinnerTypLgm = findViewById(R.id.spnTypLgmRch);
        spinnerTypAnn = findViewById(R.id.spnTypAnnRch);
        spinnerGouv = findViewById(R.id.spnGouvRch);
        spinnerVilles = findViewById(R.id.spnVilleRch);
        spinnerNbChm = findViewById(R.id.spnNbChmRch);
        etSrfMinRch = findViewById(R.id.etSrfMinRch);
        etSrfMaxRch = findViewById(R.id.etSrfMaxRch);
        etPrixMinRch = findViewById(R.id.etPrixMinRch);
        etPrixMaxRch = findViewById(R.id.etPrixMaxRch);
        chkMeublRch = findViewById(R.id.chkMeublRch);
        chkPhotoRch = findViewById(R.id.chkPhotoRch);

        // Initialiser les spinners
        ArrayAdapter<String> adapterLgm = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.enumTypeLgm));
        adapterLgm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTypLgm.setAdapter(adapterLgm);

        ArrayAdapter<String> adapterAnn = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.enumTypeAnnonce));
        adapterAnn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTypAnn.setAdapter(adapterAnn);

        ArrayAdapter<String> adapterGouv = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.enumGouvernorat));
        adapterGouv.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGouv.setAdapter(adapterGouv);

        villes = LogementDataExchange.SelectDistinctVilles();
        ArrayAdapter<String> adapterVille = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, villes);
        adapterVille.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVilles.setAdapter(adapterVille);

        ArrayAdapter<String> adapterChm = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.enumNbrChm));
        adapterChm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNbChm.setAdapter(adapterChm);

        if (spinnerTypLgm != null && spinnerTypAnn != null && spinnerGouv != null && spinnerVilles != null) {
            filterImmobilier();
        } else {
            // Gérer le cas où un spinner est null
            Toast.makeText(this, "Un spinner est null", Toast.LENGTH_SHORT).show();
        }

        // Ajouter les écouteurs
        addListeners();

        // Appeler la méthode pour configurer le RecyclerView
        setupRecyclerView();
    }

    private void addListeners() {
        spinnerTypLgm.setOnItemSelectedListener(spinnerItemSelectedListener);
        spinnerTypAnn.setOnItemSelectedListener(spinnerItemSelectedListener);
        spinnerGouv.setOnItemSelectedListener(spinnerItemSelectedListener);
        spinnerVilles.setOnItemSelectedListener(spinnerItemSelectedListener);
        spinnerNbChm.setOnItemSelectedListener(spinnerItemSelectedListener);
/*        etSrfMinRch.addTextChangedListener(textWatcher);
        etSrfMaxRch.addTextChangedListener(textWatcher);
        etPrixMinRch.addTextChangedListener(textWatcher);
        etPrixMaxRch.addTextChangedListener(textWatcher);*/

/*        chkMeublRch.setOnCheckedChangeListener(checkBoxCheckedChangeListener);
        chkPhotoRch.setOnCheckedChangeListener(checkBoxCheckedChangeListener);*/
    }

    private AdapterView.OnItemSelectedListener spinnerItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            filterImmobilier();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            // Do nothing
        }
    };

/*    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            filterImmobilier();
        }

        @Override
        public void afterTextChanged(Editable s) {}
    };*/

/*    private CompoundButton.OnCheckedChangeListener checkBoxCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            filterImmobilier();
        }
    };*/

    private void setupRecyclerView() {
        recyclerViewImmobilier = findViewById(R.id.rcvimmorech);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewImmobilier.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewImmobilier.getContext(), DividerItemDecoration.VERTICAL);
        recyclerViewImmobilier.addItemDecoration(dividerItemDecoration);

        // Get the initial list of logements
        ArrayList<Logement> biens = LogementDataExchange.getAllLogements();
        ArrayList<Logement> listLgm = LogementDataExchange.filtrerImmo(biens,null,null,null,null,0,999999999,0,0,999999999);

        // Check if the list is not empty
        if (!listLgm.isEmpty() && listLgm != null) {
            // Create and set up the adapter
            logementAdapter = new RechercheLogementAdapter(this, listLgm);
            recyclerViewImmobilier.setAdapter(logementAdapter);
            Toast.makeText(this, "Nombre de logements trouvés : "+listLgm.size(), Toast.LENGTH_SHORT).show();
        } else {
            // Show a message indicating no logements found
            Toast.makeText(this, "Aucun logement trouvé.", Toast.LENGTH_SHORT).show();
        }
    }

    private void filterImmobilier() {

        ArrayList<Logement> biens = LogementDataExchange.getAllLogements();

/*        int surfMin;
        if(Integer.parseInt(etSrfMinRch.getText().toString().trim()) >=0){
            surfMin = Integer.parseInt(etSrfMinRch.getText().toString().trim());
        }else {
            surfMin=0;
        }

        int surfMax;
        if(Integer.parseInt(etSrfMaxRch.getText().toString().trim()) >=0){
            surfMax = Integer.parseInt(etSrfMaxRch.getText().toString().trim());
        }else {
            surfMax=0;
        }

        int nbChm;
        if(Integer.parseInt(spinnerNbChm.getSelectedItem().toString()) >=0){
            nbChm = Integer.parseInt(spinnerNbChm.getSelectedItem().toString());
        }else {
            nbChm=0;
        }

        Float prMin;
        if(Float.parseFloat(etPrixMinRch.getText().toString().trim()) >=0){
            prMin = Float.parseFloat(etPrixMinRch.getText().toString().trim());
        }else {
            prMin= (float) 0;
        }

        Float prMax;
        if(Float.parseFloat(etPrixMaxRch.getText().toString().trim()) >=0){
            prMax = Float.parseFloat(etPrixMaxRch.getText().toString().trim());
        }else {
            prMax= (float) 0;
        }*/

        List<Logement> filteredList = LogementDataExchange.filtrerImmo(biens,
                (String) spinnerTypLgm.getSelectedItem(),
                (String) spinnerTypAnn.getSelectedItem(),
                (String) spinnerGouv.getSelectedItem(),
                (String) spinnerVilles.getSelectedItem(),
                Integer.parseInt(etSrfMinRch.getText().toString().trim()),
                Integer.parseInt(etSrfMaxRch.getText().toString().trim()),
                Integer.parseInt(spinnerNbChm.getSelectedItem().toString()),
                Float.parseFloat(etPrixMinRch.getText().toString().trim()),
                Float.parseFloat(etPrixMaxRch.getText().toString().trim()));

        // Update the adapter with the filtered list
        if (logementAdapter != null) {
            logementAdapter.updateData(filteredList);
            Toast.makeText(this, "Nombre de logements trouvés : " + filteredList.size(), Toast.LENGTH_SHORT).show();
        }
    }
}
