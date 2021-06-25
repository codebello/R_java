package ma.tdi.tinghir.tasks;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

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

import ma.tdi.tinghir.R;
import ma.tdi.tinghir.objects.Bibliotheque;
import ma.tdi.tinghir.objects.Livre;

public class BiblioAsyncTask extends AsyncTask<String, Void, Boolean> {

    private static final String TAG = "API_TEST";

    Activity activity;
    Bibliotheque bibliotheque;

    public BiblioAsyncTask(Activity activity, Bibliotheque bibliotheque) {
        super();
        this.activity = activity;
        this.bibliotheque = bibliotheque;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.i(TAG, "onPreExecute: OK");
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        if(strings.length == 3) {
            if(strings[1].equals("action") && strings[2].equals("read") ) {
                try {
                    URL url = new URL(strings[0] + "?action=read");
                    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                    if(connection.getResponseCode() == 200) {
                        InputStream inputStream = connection.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder sb = new StringBuilder();
                        String ligne = bufferedReader.readLine();
                        while (ligne != null) {
                            sb.append(ligne);
                            ligne = bufferedReader.readLine();
                        }
                        inputStream.close();
                        setBibliotheque(sb.toString());
                        Log.i(TAG, "doInBackground: OK");
                        return true;
                    }
                } catch (MalformedURLException e) {
                    Log.i(TAG, "MalformedURLException: " + e.getMessage());
                } catch (IOException e) {
                    Log.i(TAG, "IOException: " + e.getMessage());
                } catch (JSONException e) {
                    Log.i(TAG, "JSONException: " + e.getMessage());
                }
            }
        }
        Log.i(TAG, "doInBackground: NOK");
        return false;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if(aBoolean) {
            ListView lvLivres = activity.findViewById(R.id.lvLivres);
            SimpleAdapter adapter = new SimpleAdapter(
                    activity,
                    getHashMapLivres(),
                    R.layout.lv_layout_livre,
                    new String[] { "titre", "auteur", "nombrePages" },
                    new int[]{ R.id.tvTitre, R.id.tvAuteur, R.id.tvNbrPages }
            );
            lvLivres.setAdapter(adapter);
            TextView tvNom = activity.findViewById(R.id.tvNom);
            tvNom.setText(bibliotheque.getNom());
            Log.i(TAG, "onPostExecute: " + bibliotheque.getLivres().size() + ", " + bibliotheque.getNom());
        } else {
            Toast.makeText(activity, "Problème de communication avec le serveur", Toast.LENGTH_LONG).show();
            Log.i(TAG, "onPostExecute: Pas de bibliothéque");
        }
        Log.i(TAG, "onPostExecute: OK");
    }

    private void setBibliotheque(String jsonString) throws JSONException {
        JSONObject jsonBibliotheque = new JSONObject(jsonString);
        if(jsonBibliotheque.getString("status").equals("OK")) {
            JSONObject jsonData = jsonBibliotheque.getJSONObject("data");
            String nom = jsonData.getString("Nom");
            JSONArray jsonLivres = jsonData.getJSONArray("Livres");
            ArrayList<Livre> livres = new ArrayList<>();
            for (int i = 0; i < jsonLivres.length(); i++) {
                JSONObject jsonLivre = jsonLivres.getJSONObject(i);
                Livre livre = new Livre(
                        jsonLivre.getString("titre"),
                        jsonLivre.getString("auteur"),
                        jsonLivre.getInt("nbrPages")
                );
                livres.add(livre);
            }
            bibliotheque.setNom(nom);
            bibliotheque.setLivres(livres);
        } else {
            throw new JSONException("Méthode setBibliotheque: status = NOK");
        }
    }

    private ArrayList<HashMap<String, String>> getHashMapLivres() {
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();
        for(Livre livre: bibliotheque.getLivres()) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("titre", livre.getTitre());
            hashMap.put("auteur", livre.getAuteur());
            hashMap.put("nombrePages", livre.getNombrePages()+"");
            hashMaps.add(hashMap);
        }
        return hashMaps;
    }
}
