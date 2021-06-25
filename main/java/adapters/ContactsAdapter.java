package ma.tdi.tinghir.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ma.tdi.tinghir.ListViewActivity;
import ma.tdi.tinghir.R;
import ma.tdi.tinghir.objects.Contact;

public class ContactsAdapter extends BaseAdapter {

    private Context context;
    private int resourceLayout;
    private List<Contact> contacts;

    public ContactsAdapter(Context context, int resourceLayout, List<Contact> contacts) {
        super();
        this.context = context;
        this.resourceLayout = resourceLayout;
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater
                            .from(context)
                            .inflate(resourceLayout, null, false);
        }

        TextView tvNom = (TextView)convertView.findViewById(R.id.tvNom);
        TextView tvPrenom = (TextView)convertView.findViewById(R.id.tvPrenom);
        TextView tvTelephone = (TextView)convertView.findViewById(R.id.tvTelephone);

        Contact ct = (Contact) getItem(position);

        tvNom.setText(ct.getNom());
        tvPrenom.setText(ct.getPrenom());
        tvTelephone.setText(ct.getTelephone());

        return convertView;
    }
}
