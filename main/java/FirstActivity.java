package ma.tdi.tinghir;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    TextView tvMessage;
    EditText etLogin, etPassword;
    Button btnLogin;

    private static final String _login = "user25";
    private static final String _password = "524163";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        etLogin = (EditText)findViewById(R.id.etLogin);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        tvMessage = (TextView)findViewById(R.id.tvMessage);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etLogin.getText().toString().trim().equals("")) {
                    tvMessage.setText("Login obligatoire");
                    return;
                }
                if(etPassword.getText().toString().trim().equals("")) {
                    tvMessage.setText("Password obligatoire");
                    return;
                }
                if(
                    etLogin.getText().toString().equals(_login)
                    && etPassword.getText().toString().equals(_password)) {
                    tvMessage.setText("Ok");
                } else {
                    tvMessage.setText("NOK");
                }
            }
        });

    }
}
