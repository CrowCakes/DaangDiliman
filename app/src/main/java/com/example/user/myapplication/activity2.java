package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        String s = getIntent().getStringExtra("EXTRA_SELECTED_DEST");
        TextView tv1 = (TextView)findViewById(R.id.textView);
        tv1.setText(s);

        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFirstPage();
            }
        });
    }
    private void goToFirstPage() {
        Intent intent2 = new Intent(this, activity1.class);
        startActivity(intent2);
        overridePendingTransition(0, 0);
    }
}
