package ma.tdi.tinghir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaysVilleActivity extends AppCompatActivity {

    Spinner spPays, spVille;
    TextView tvCapital;

    ArrayList<HashMap<String, Object>> pays = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pays_ville);

        spPays = (Spinner)findViewById(R.id.spPays);
        spVille = (Spinner)findViewById(R.id.spVille);
        tvCapital = (TextView) findViewById(R.id.tvCapital);

        loadData();

        SimpleAdapter adapter = new SimpleAdapter(
                PaysVilleActivity.this,
                pays,
                R.layout.spinner_pays_ville,
                new String[] { "Nom" },
                new int[] { R.id.tvNomPV }
        );
        spPays.setAdapter(adapter);

        spPays.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int idp = Integer.parseInt(pays.get(position).get("Id").toString());
                List<HashMap<String, Object>> villes = findVillesById(idp);
                SimpleAdapter adapter2 = new SimpleAdapter(
                        PaysVilleActivity.this,
                        villes,
                        R.layout.spinner_pays_ville,
                        new String[] { "Nom" },
                        new int[] { R.id.tvNomPV }
                );
                spVille.setAdapter(adapter2);

                spVille.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        int idv = Integer.parseInt(villes.get(position).get("Id").toString());
                        String nomv = villes.get(position).get("Nom").toString();
                        boolean b = estCapital(idp, idv);
                        if(b) {
                            tvCapital.setText(nomv + " est le capital");
                        } else {
                            tvCapital.setText(nomv + " n'est pas le capital");
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void loadData() {

        HashMap<String, Object> pay = null;
        HashMap<String, Object> ville = null;
        ArrayList<HashMap<String, Object>> villes = null;

        pay = new HashMap<>();
        pay.put("Id", 1);
        pay.put("Nom", "Maroc");
        villes = new ArrayList<HashMap<String, Object>>();

        ville = new HashMap<>();
        ville.put("Id", 10);
        ville.put("Nom", "Rabat");
        ville.put("EstCapital", true);
        villes.add(ville);

        ville = new HashMap<>();
        ville.put("Id", 11);
        ville.put("Nom", "Safi");
        ville.put("EstCapital", false);
        villes.add(ville);

        ville = new HashMap<>();
        ville.put("Id", 12);
        ville.put("Nom", "Tanger");
        ville.put("EstCapital", false);
        villes.add(ville);

        pay.put("Villes", villes);
        pays.add(pay);

        pay = new HashMap<>();
        pay.put("Id", 2);
        pay.put("Nom", "Algérie");
        villes = new ArrayList<HashMap<String, Object>>();

        ville = new HashMap<>();
        ville.put("Id", 20);
        ville.put("Nom", "Alger");
        ville.put("EstCapital", true);
        villes.add(ville);

        ville = new HashMap<>();
        ville.put("Id", 21);
        ville.put("Nom", "Oran");
        ville.put("EstCapital", false);
        villes.add(ville);

        ville = new HashMap<>();
        ville.put("Id", 22);
        ville.put("Nom", "Annaba");
        ville.put("EstCapital", false);
        villes.add(ville);

        pay.put("Villes", villes);
        pays.add(pay);

        pay = new HashMap<>();
        pay.put("Id", 3);
        pay.put("Nom", "Tunisie");
        villes = new ArrayList<HashMap<String, Object>>();

        ville = new HashMap<>();
        ville.put("Id", 30);
        ville.put("Nom", "Tunis");
        ville.put("EstCapital", true);
        villes.add(ville);

        ville = new HashMap<>();
        ville.put("Id", 31);
        ville.put("Nom", "Sfax");
        ville.put("EstCapital", false);
        villes.add(ville);

        ville = new HashMap<>();
        ville.put("Id", 33);
        ville.put("Nom", "Sousa");
        ville.put("EstCapital", false);
        villes.add(ville);

        pay.put("Villes", villes);
        pays.add(pay);

    }

    private List<HashMap<String, Object>> findVillesById(int id)
            throws IllegalArgumentException {
        for(int i = 0; i < pays.size(); i++) {
            int idp = Integer.parseInt(pays.get(i).get("Id").toString());
            if(id == idp) {
                return (List<HashMap<String, Object>>)pays.get(i).get("Villes");
            }
        }
        throw new IllegalArgumentException("Aucun Pays avec cet Id ("+ id +")");
    }

    private boolean estCapital(int idp, int idv) {
        List<HashMap<String, Object>> villes = findVillesById(idp);
        for(int i = 0; i < villes.size(); i++) {
            if(Integer.parseInt(villes.get(i).get("Id").toString()) == idv) {
                HashMap<String, Object> ville = (HashMap<String, Object>)villes.get(i);
                if(Boolean.parseBoolean(ville.get("EstCapital").toString())) {
                    return true;
                }
            }
        }
        return false;
    }


}