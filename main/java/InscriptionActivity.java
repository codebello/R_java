package ma.tdi.tinghir;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class InscriptionActivity extends AppCompatActivity {

    EditText etPrenom, etNom, etEmail, etPassword;
    RadioButton rdMarocain, rdEtranger;
    CheckBox cbSport, cbCinema, cbJeux;
    Button btnInscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        etPrenom = (EditText)findViewById(R.id.etPrenom);
        etNom = (EditText)findViewById(R.id.etNom);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPassword = (EditText)findViewById(R.id.etPassword);

        rdMarocain = (RadioButton)findViewById(R.id.rdMarocain);
        rdEtranger = (RadioButton)findViewById(R.id.rdEtranger);

        cbSport = (CheckBox)findViewById(R.id.cbSport);
        cbCinema = (CheckBox)findViewById(R.id.cbCinema);
        cbJeux = (CheckBox)findViewById(R.id.cbJeux);

        btnInscription = (Button)findViewById(R.id.btnInscription);

        btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> erreurs = getValidationErrors();
                StringBuilder sb = new StringBuilder();
                if(erreurs.size() == 0) {
                    sb.append(getResources().getString(R.string.prenom) + etPrenom.getText().toString() + "\n");
                    sb.append(getResources().getString(R.string.nom) + etNom.getText().toString() + "\n");
                    sb.append(getResources().getString(R.string.email) + etEmail.getText().toString() + "\n");
                    sb.append(getResources().getString(R.string.password) + etPassword.getText().toString() + "\n");

                    if(rdMarocain.isChecked()) {
                        sb.append(getResources().getString(R.string.nationalite) + rdMarocain.getText().toString() + "\n");
                    } else {
                        sb.append(getResources().getString(R.string.nationalite) + rdEtranger.getText().toString() + "\n");
                    }
                    String loisirs = "";
                    if(cbSport.isChecked()) {
                        loisirs += cbSport.getText().toString() + ", ";
                    }
                    if(cbCinema.isChecked()) {
                        loisirs += cbCinema.getText().toString() + ", ";
                    }
                    if(cbJeux.isChecked()) {
                        loisirs += cbJeux.getText().toString() + ", ";
                    }
                    sb.append(getResources().getString(R.string.loisirs) + loisirs);

                }
                else {
                    for(int i = 0; i < erreurs.size(); i++) {
                        sb.append(erreurs.get(i) + "\n");
                    }
                }
                /*
                Toast
                .makeText(InscriptionActivity.this, sb.toString(), Toast.LENGTH_LONG)
                .show();
                 */

                AlertDialog.Builder builder = new AlertDialog.Builder(InscriptionActivity.this);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast
                        .makeText(InscriptionActivity.this, "OK", Toast.LENGTH_LONG)
                        .show();
                    }
                });
                builder.setNegativeButton(R.string.non, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast
                        .makeText(InscriptionActivity.this, "Non", Toast.LENGTH_LONG)
                        .show();
                    }
                });
                builder.setNeutralButton(R.string.annuler, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast
                        .makeText(InscriptionActivity.this, "Annuler", Toast.LENGTH_LONG)
                        .show();
                    }
                });
                builder.setMessage(sb.toString());
                builder.setTitle(R.string.infos);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    private ArrayList<String> getValidationErrors() {
        ArrayList<String> erreurs = new ArrayList<>();

        if(etPrenom.getText().toString().trim().equals("")) {
            erreurs.add(getResources().getString(R.string.et_hint_prenom));
        }
        if(etNom.getText().toString().trim().equals("")) {
            erreurs.add(getResources().getString(R.string.et_hint_nom));
        }
        if(etEmail.getText().toString().trim().equals("")) {
            erreurs.add(getResources().getString(R.string.et_hint_email));
        }
        if(etPassword.getText().toString().trim().equals("")) {
            erreurs.add(getResources().getString(R.string.et_hint_password));
        }

        if(!rdMarocain.isChecked() && !rdEtranger.isChecked()) {
            erreurs.add(getResources().getString(R.string.rd_nationalite_obligatoire));
        }

        return  erreurs;
    }
}