package ma.tdi.tinghir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ma.tdi.tinghir.tasks.FirstTask;

public class My1stTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my1st_task);

        (new FirstTask(My1stTaskActivity.this)).execute(7, 0, 0, -5);
    }
}