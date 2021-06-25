package ma.tdi.tinghir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class SpinnerDemoActivity extends AppCompatActivity {

    Spinner spGroupes;
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);

        spGroupes = (Spinner)findViewById(R.id.spGroupes);
        tvTest = (TextView) findViewById(R.id.tvTest);

        try {
            SimpleAdapter adapter = new SimpleAdapter(
                    SpinnerDemoActivity.this,
                    getDatas(),
                    R.layout.spinner_simple_layout_1,
                    new String[] {"Nom", "Prenom", "DateNaissance"},
                    new int[] {R.id.tvNomP, R.id.tvPrenomP, R.id.tvNaissanceP}
            );
            spGroupes.setAdapter(adapter);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    // Fetch data from source(api, data base, files, .....)
    private List<HashMap<String, Object>> getDatas() throws ParseException {
        List<HashMap<String, Object>> personnes = new ArrayList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        HashMap<String, Object> pers = new HashMap<>();
        pers.put("Nom", "Karim");
        pers.put("Prenom", "Amine");
        pers.put("DateNaissance", formatter.format(formatter.parse("22/07/1997")));
        personnes.add(pers);

        pers = new HashMap<>();
        pers.put("Nom", "Youssef");
        pers.put("Prenom", "Mohamed");
        pers.put("DateNaissance", formatter.parse("16/02/2000"));
        personnes.add(pers);

        pers = new HashMap<>();
        pers.put("Nom", "Yassine");
        pers.put("Prenom", "Omar");
        pers.put("DateNaissance", formatter.parse("30/12/1988"));
        personnes.add(pers);

        pers = new HashMap<>();
        pers.put("Nom", "Abdallah");
        pers.put("Prenom", "Rabie");
        pers.put("DateNaissance", formatter.parse("26/01/1996"));
        personnes.add(pers);

        return personnes;
    }

}