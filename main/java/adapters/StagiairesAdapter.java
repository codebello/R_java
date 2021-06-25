package ma.tdi.tinghir.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import ma.tdi.tinghir.R;
import ma.tdi.tinghir.objects.Stagiaire;

public class StagiairesAdapter extends BaseAdapter {

    private List<Stagiaire> stagiaires;
    private Context context;
    private int resourceLayout;

    public StagiairesAdapter(Context context, int resourceLayout, List<Stagiaire> stagiaires) {
        super();
        this.stagiaires = stagiaires;
        this.context = context;
        this.resourceLayout = resourceLayout;
    }

    @Override
    public int getCount() {
        return stagiaires.size();
    }

    @Override
    public Object getItem(int position) {
        return stagiaires.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ((Stagiaire)getItem(position)).getNumeroInscription();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater
                            .from(context)
                            .inflate(resourceLayout, null, false);
        }

        TextView tvNomS = (TextView)convertView.findViewById(R.id.tvNomS);
        TextView tvPrenomS = (TextView)convertView.findViewById(R.id.tvPrenomS);
        TextView tvDateNaissance = (TextView)convertView.findViewById(R.id.tvDateNaissance);

        Stagiaire stg = (Stagiaire) getItem(position);
        tvNomS.setText(stg.getNom());
        tvPrenomS.setText(stg.getPrenom());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        tvDateNaissance.setText(formatter.format(stg.getDateNaissance()));

        return convertView;
    }
}
