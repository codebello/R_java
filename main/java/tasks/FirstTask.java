package ma.tdi.tinghir.tasks;

import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import ma.tdi.tinghir.My1stTaskActivity;
import ma.tdi.tinghir.R;

public class FirstTask extends AsyncTask<Integer, Boolean, String> {

    My1stTaskActivity activity;

    public FirstTask(My1stTaskActivity activity) {
        super();
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        ((TextView)activity.findViewById(R.id.tvLong)).setText("En Cours...");
    }

    @Override
    protected String doInBackground(Integer... integers) {
        try {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ((TextView)activity.findViewById(R.id.tvTest)).setText("Arrière-Plan");
                }
            });

            if(integers.length > 0 && integers[0] != 0)
                Thread.sleep(integers[0] * 1000 > 0 ? integers[0] * 1000 : -(integers[0] * 1000));
            else
                Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "NOK";
        }
        return "OK";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        ((TextView)activity.findViewById(R.id.tvLong)).setText("Terminé");

        if(s.equals("OK")) {
            Toast.makeText(activity, s, Toast.LENGTH_LONG).show();
        }
    }
}