package ma.tdi.tinghir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    EditText etMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        etMsg = (EditText)findViewById(R.id.etMsg);
    }

    public void OuvrirContacts(View view) {
        Intent intent = new Intent
                (
                        HomeActivity.this,
                        ListViewActivity.class
                );
        startActivity(intent);
    }

    public void OuvrirContacts2(View view) {
        Intent intent = new Intent
                (
                        HomeActivity.this,
                        ListViewActivity.class
                );
        String msg = etMsg.getText().toString();
        intent.putExtra("Msg", msg);
        intent.putExtra("Num", 15);
        intent.putExtra("IsOk", true);
        startActivity(intent);
    }
}