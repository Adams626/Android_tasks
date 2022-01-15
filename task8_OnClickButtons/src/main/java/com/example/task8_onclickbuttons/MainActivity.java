package com.example.task8_onclickbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    TextView tvOut;
    Button btnOk;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel=(Button) findViewById(R.id.btnCancel);

        View.OnClickListener oclBtnOK = new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                tvOut.setText("OK button was pressed");
            }
        };
        btnOk.setOnClickListener(oclBtnOK);

        View.OnClickListener oclBtnCancel = new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                tvOut.setText("Cancel button was pressed");
            }
        };
        btnCancel.setOnClickListener(oclBtnCancel);
    }
}