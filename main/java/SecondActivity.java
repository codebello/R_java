package ma.tdi.tinghir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    CheckBox cbAmazigh, cbArabe, cbAnglais;
    TextView tvLangues, tvPays, tvCouleur, tvCouleur2;
    RadioButton rdMaroc, rdAlgerie, rdTunisie;
    Spinner spCouleurs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        cbAmazigh = (CheckBox)findViewById(R.id.cbAmazigh);
        cbArabe = (CheckBox)findViewById(R.id.cbArabe);
        cbAnglais = (CheckBox)findViewById(R.id.cbAnglais);
        tvLangues = (TextView) findViewById(R.id.tvLangues);

        rdMaroc = (RadioButton)findViewById(R.id.rdMaroc);
        rdAlgerie = (RadioButton)findViewById(R.id.rdAlgerie);
        rdTunisie = (RadioButton)findViewById(R.id.rdTunisie);
        tvPays = (TextView) findViewById(R.id.tvPays);

        spCouleurs = (Spinner)findViewById(R.id.spCouleurs);
        tvCouleur = (TextView) findViewById(R.id.tvCouleur);
        tvCouleur2 = (TextView) findViewById(R.id.tvCouleur2);


        spCouleurs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvCouleur2.setText(position + " : " + parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void Visualiser(View view) {
        ArrayList<String> langues = new ArrayList<>();

        if(cbAmazigh.isChecked()) {
            langues.add(cbAmazigh.getText().toString());
        }
        if(cbArabe.isChecked()) {
            langues.add(cbArabe.getText().toString());
        }
        if(cbAnglais.isChecked()) {
            langues.add(cbAnglais.getText().toString());
        }

        if(langues.size() > 0) {
        tvLangues.setText(
                    langues
                    .toString()
                    .replace("[", "")
                    .replace("]", "")
        );
        } else {
            tvLangues.setText("Aucune langue sélectionnée");
        }
    }

    public void Visualiser2(View view) {
        if(rdMaroc.isChecked()) {
            tvPays.setText(rdMaroc.getText().toString());
        } else if(rdAlgerie.isChecked()) {
            tvPays.setText(rdAlgerie.getText().toString());
        } else {
            tvPays.setText(rdTunisie.getText().toString());
        }
    }

    public void Visualiser3(View view) {
        tvCouleur.setText(spCouleurs.getSelectedItem().toString());
    }
}