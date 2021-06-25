package ma.tdi.tinghir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ma.tdi.tinghir.adapters.ContactsAdapter;
import ma.tdi.tinghir.dao.Data;
import ma.tdi.tinghir.objects.Contact;

public class ListViewActivity extends AppCompatActivity {

    ListView lvContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lvContacts = (ListView)findViewById(R.id.lvContacts);


        int num = getIntent().getIntExtra("Num", 0);
        String msg = getIntent().getStringExtra("Msg");
        boolean isOk = getIntent().getBooleanExtra("IsOk", false);

        Toast
        .makeText(ListViewActivity.this, num + " " + msg + " " + isOk   , Toast.LENGTH_SHORT)
        .show();


        /*
        SimpleAdapter adapter = new SimpleAdapter(
                ListViewActivity.this,
                getContacts(),
                R.layout.list_view_item_contact,
                new String[] { "Nom", "Prenom", "Telephone" },
                new int[] { R.id.tvNom, R.id.tvPrenom, R.id.tvTelephone }
        );

        lvContacts.setAdapter(adapter);
         */

        Data.loadContacts();
        ContactsAdapter adapter = new ContactsAdapter(
                ListViewActivity.this,
                R.layout.list_view_item_contact,
                Data.getContacts()
        );
        lvContacts.setAdapter(adapter);

        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact ct = (Contact) ((ContactsAdapter)lvContacts.getAdapter()).getItem(position);
                Toast
                    .makeText(ListViewActivity.this, ct.getTelephone(), Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }


    // Fetch Data...
    private List<HashMap<String, Object>> getContacts() {
        List<HashMap<String, Object>> contacts = new ArrayList<>();

        HashMap<String, Object> contact = new HashMap<>();
        contact.put("Nom", "Ahmed");
        contact.put("Prenom", "Youssef");
        contact.put("Telephone", "0512458216");
        contacts.add(contact);

        contact = new HashMap<>();
        contact.put("Nom", "Khalid");
        contact.put("Prenom", "Amine");
        contact.put("Telephone", "0511229625");
        contacts.add(contact);

        contact = new HashMap<>();
        contact.put("Nom", "Karim");
        contact.put("Prenom", "Yassine");
        contact.put("Telephone", "0637198205");
        contacts.add(contact);

        contact = new HashMap<>();
        contact.put("Nom", "Hayat");
        contact.put("Prenom", "Imane");
        contact.put("Telephone", "0600124488");
        contacts.add(contact);

        contact = new HashMap<>();
        contact.put("Nom", "Hicham");
        contact.put("Prenom", "Younes");
        contact.put("Telephone", "0512405060");
        contacts.add(contact);

        contact = new HashMap<>();
        contact.put("Nom", "Mohamed");
        contact.put("Prenom", "Omar");
        contact.put("Telephone", "0606430588");
        contacts.add(contact);

        contact = new HashMap<>();
        contact.put("Nom", "Fatima");
        contact.put("Prenom", "Salwa");
        contact.put("Telephone", "0612457819");
        contacts.add(contact);




        return  contacts;
    }
}