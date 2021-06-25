package ma.tdi.tinghir.adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import ma.tdi.tinghir.R;
import ma.tdi.tinghir.objects.Langage;

public class LangagesAdapter extends BaseAdapter {
    private Context context;
    List<Langage> langages;
    int resource;

    public LangagesAdapter(Context context, int resource, List<Langage> objects) {
        super();
        this.context = context;
        langages = objects;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return langages.size();
    }

    @Nullable
    @Override
    public Langage getItem(int position) {
        return langages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater
                            .from(this.context)
                            .inflate(this.resource, null, false);
        }
        TextView tvNomL = (TextView)convertView.findViewById(R.id.tvNomL);
        TextView tvNombreApplications = (TextView)convertView.findViewById(R.id.tvNombreApplications);

        tvNomL.setText(getItem(position).getNom());
        int nbr = getItem(position).getApplications().size();
        if(nbr >= 4) {
            tvNombreApplications.setTextColor(R.color.design_default_color_primary_dark);
            tvNombreApplications.setTypeface(Typeface.DEFAULT_BOLD);
        }
        tvNombreApplications.setText(nbr+"");

        return convertView;
    }
}
