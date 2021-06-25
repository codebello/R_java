package ma.tdi.tinghir.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ma.tdi.tinghir.R;
import ma.tdi.tinghir.dao.Data;
import ma.tdi.tinghir.objects.Groupe;

public class GroupesAdapter extends BaseAdapter {

    List<Groupe> groupes;
    Context context;
    int resourceLayout;

    public GroupesAdapter(Context context, int resourceLayout, List<Groupe> groupes) {
        super();
        this.context = context;
        this.resourceLayout = resourceLayout;
        this.groupes = groupes;
    }

    @Override
    public int getCount() {
        return groupes.size();
    }

    @Override
    public Object getItem(int position) {
        return groupes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ((Groupe)getItem(position)).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater
                            .from(context)
                            .inflate(resourceLayout, null, false);
        }
        TextView tvNomG = (TextView)convertView.findViewById(R.id.tvNomG);
        TextView tvNombreStagiaires = (TextView)convertView.findViewById(R.id.tvNombreStagiaires);

        Groupe grp = (Groupe)getItem(position);

        tvNomG.setText(grp.getNom());
        tvNombreStagiaires.setText("(" + Data.getNombreStagiairesParGroupe(grp.getId()) + ")");

        return convertView;
    }
}
