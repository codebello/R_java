package ma.tdi.tinghir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.util.List;

import ma.tdi.tinghir.adapters.GroupesAdapter;
import ma.tdi.tinghir.adapters.StagiairesAdapter;
import ma.tdi.tinghir.dao.Data;
import ma.tdi.tinghir.objects.Groupe;
import ma.tdi.tinghir.objects.Stagiaire;

public class StagiairesActivity extends AppCompatActivity {
    Spinner spGroupes, spStagiaires;

    List<Stagiaire> stagiaires;
    List<Groupe> groupes;


    public static final String TAG = "TAG_STG_GRP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagiaires);

        spGroupes = (Spinner)findViewById(R.id.spGroupes);
        spStagiaires = (Spinner)findViewById(R.id.spStagiaires);

        try {
            Data.load2();
            groupes = Data.getGroupes();

            GroupesAdapter adapterG = new GroupesAdapter(
                StagiairesActivity.this,
                R.layout.spinner_item_groupes,
                groupes
            );
            spGroupes.setAdapter(adapterG);

            spGroupes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Groupe grp = groupes.get(position);
                    stagiaires = Data.getStagiairesParGroupe(grp);

                    StagiairesAdapter adapterS = new StagiairesAdapter(
                            StagiairesActivity.this,
                            R.layout.spinner_item_stagiaires,
                            stagiaires
                    );
                    spStagiaires.setAdapter(adapterS);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        } catch (ParseException ex) {
            Toast
            .makeText(StagiairesActivity.this, "Le chargement des données a echoué.", Toast.LENGTH_SHORT)
            .show();
            Log.e(TAG, "onCreate: Appel de Data.load2() non reussi.");
        } catch (Exception ex) {
            Toast
            .makeText(StagiairesActivity.this, ex.getMessage(), Toast.LENGTH_SHORT)
            .show();
            Log.e(TAG, "onCreate: " + ex.getMessage());
        }

    }
}