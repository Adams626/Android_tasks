package com.example.task26_animationmovement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Screen3 extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    Button b2;
    Button b3;
    ImageView img;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        b1= findViewById(R.id.b1);
        b1.setOnClickListener(this);

        b2= findViewById(R.id.b2);
        b2.setOnClickListener(this);

        b3= findViewById(R.id.b3);
        b3.setOnClickListener(this);
        tv1= findViewById(R.id.trescSlajdu);
        img=findViewById(R.id.obrazek);
        tv1.setText(R.string.ts2);
        img.setImageResource(R.drawable.herbata);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                Intent intent2 = new Intent(this, Screen2.class);
                startActivity(intent2);
                break;
            case R.id.b2:
                Intent intent3 = new Intent(this, Screen4.class);
                startActivity(intent3);
                break;
            case R.id.b3:
                Intent intent4 = new Intent(this, MainActivity.class);
                startActivity(intent4);
                break;
            default:
                break;
        }
    }
}
