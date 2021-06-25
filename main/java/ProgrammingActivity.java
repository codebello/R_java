package ma.tdi.tinghir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;

import java.util.ArrayList;

import ma.tdi.tinghir.adapters.LangagesAdapter;
import ma.tdi.tinghir.dao.Data;
import ma.tdi.tinghir.objects.Langage;

public class ProgrammingActivity extends AppCompatActivity {
    static final String TAG = "Tdi_Tag";
    ArrayList<Langage> langages = null;

    Spinner spLangages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming);

        spLangages = (Spinner)findViewById(R.id.spLangages);

        Data.load();
        langages = (ArrayList<Langage>) Data.getLangages();

        Log.i(TAG, "onCreate: My First Log");
        Log.i(TAG, "onCreate: " + langages.size());
        Log.i(TAG, "onCreate: " + langages);

        LangagesAdapter adapter = new LangagesAdapter(
                ProgrammingActivity.this,
                R.layout.spinner_item_langages,
                langages
        );
        spLangages.setAdapter(adapter);

    }
}