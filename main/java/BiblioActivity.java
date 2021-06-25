package ma.tdi.tinghir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BiblioActivity extends AppCompatActivity {

    static final String TAG = "TAG_JSON";

    private String nom = "";
    private List<HashMap<String, Object>> livres = new ArrayList<>();

    TextView tvNomBiblio;
    ListView lvLivres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblio);

        //parseJson(readJsonFromAssets("data.json"));
        //parseJson2(readJsonFromAssets("data2.json"));

        loadFromJson(readJsonFromAssets("data_biblio.json"));

        tvNomBiblio = (TextView)findViewById(R.id.tvNomBiblio);
        lvLivres = (ListView)findViewById(R.id.lvLivres);

        loadDataFRowApi();

        /*
        tvNomBiblio.setText(nom);

        SimpleAdapter adapter = new SimpleAdapter(
                BiblioActivity.this,
                livres,
                R.layout.lv_layout_livre,
                new String[] { "titre", "auteur", "nombrePages" },
                new int[] { R.id.tvTitre, R.id.tvAuteur, R.id.tvNbrPages }
        );
        lvLivres.setAdapter(adapter);

         */

    }

    private void loadDataFRowApi() {
        try {
            String strUrl = "http://192.168.1.67:8080/api/data.php";
            URL url = new URL(strUrl);
            HttpURLConnection
                    connection = (HttpURLConnection)url.openConnection();
            if(connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder sb = new StringBuilder();
                String ligne = bufferedReader.readLine();
                Log.i(TAG, "loadDataFRowApi: " + ligne);
                while (ligne != null) {
                    sb.append(ligne);
                    ligne = bufferedReader.readLine();
                }
                inputStream.close();
                Log.i(TAG, "loadDataFRowApi: " + sb.toString());
            }
        } catch (MalformedURLException e) {
            Log.e(TAG, "loadDataFRowApi: " + e.getMessage() );
        } catch (IOException e) {
            Log.e(TAG, "loadDataFRowApi: " + e.getMessage() );
        }
    }

    private void loadFromJson(String json) {
        try {
            JSONObject biblioJson = new JSONObject(json);
            nom = biblioJson.getString("nom");

            JSONArray livresJson = biblioJson.getJSONArray("livres");
            for(int i = 0; i < livresJson.length(); i++) {
                JSONObject itemJson = livresJson.getJSONObject(i);
                HashMap<String, Object> itemHash = new HashMap<>();
                itemHash.put("titre", itemJson.getString("titre"));
                itemHash.put("auteur", itemJson.getString("auteur"));
                itemHash.put("nombrePages", itemJson.getInt("nombrePages"));
                livres.add(itemHash);
            }

        } catch (JSONException e) {
            Log.e(TAG, "loadFromJson: " + e.getMessage());
        }
    }

    private void parseJson(String strJson) {
        try {
            JSONObject jsonObject = new JSONObject(strJson);
            String nom = jsonObject.getString("Nom");
            String prenom = jsonObject.getString("Prenom");
            int age = jsonObject.getInt("Age");
            Log.i(TAG, "parseJson: nom: " + nom);
            Log.i(TAG, "parseJson: prenom: " + prenom);
            Log.i(TAG, "parseJson: age: " + age);
        } catch (JSONException e) {
            Log.e(TAG, "parseJson: " + e.getMessage());
        }
    }

    private void parseJson2(String strJson) {
        try {
            JSONArray jsonArray = new JSONArray(strJson);
            for (int i = 0; i < jsonArray.length(); i++) {
                Log.i(TAG, "parseJson2: [" + i + 1 + "]: " + jsonArray.get(i));
            }

            JSONObject obj = jsonArray.getJSONObject(3);
            Log.i(TAG, "parseJson2: " + obj.getString("Nom"));
        } catch (JSONException e) {
            Log.e(TAG, "parseJson: " + e.getMessage());
        }
    }

    private String readJsonFromAssets(String nomFichierJson) {
        String json = "";
        try {
            InputStream is = getAssets().open(nomFichierJson);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            Log.e(TAG, "parseJson: " + e.getMessage());
        }
        return json;
    }
}