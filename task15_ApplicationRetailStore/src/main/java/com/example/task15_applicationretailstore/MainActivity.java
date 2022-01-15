package com.example.task15_applicationretailstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView tv;
    CheckBox chb;
    ImageView img1, img2,img3,img4,img5,img6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.tv);
        chb= findViewById(R.id.chb);
        img1= findViewById(R.id.img1);
        img2= findViewById(R.id.img2);
        img3= findViewById(R.id.img3);
        img4= findViewById(R.id.img4);
        img5= findViewById(R.id.img5);
        img6= findViewById(R.id.img6);

        chb.setOnClickListener(v -> {
            if(chb.isChecked()){

                Toast.makeText(MainActivity.this,"Menu activated",Toast.LENGTH_LONG).show();

            }else if(!chb.isChecked()){

                Toast.makeText(MainActivity.this,"Menu deactivated",Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Góra");
        menu.add(0, 2, 0, "Dół");
        menu.add(1, 3, 0, "Koszule");
        menu.add(1, 4, 0, "Bluzy");
        menu.add(1, 5, 0, "Spodnie");
        menu.add(1, 6, 0, "Buty");


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(1,chb.isChecked());

        return super.onPrepareOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String selectCategory = "Select category "+ item.getTitle();
        tv.setText(selectCategory);

        Toast.makeText(this,item.getTitle(),Toast.LENGTH_LONG).show();




        if (item.getItemId() == 1) {
            img1.setImageResource(R.drawable.bluza);
            img2.setImageResource(R.drawable.buty);
            img3.setImageResource(R.drawable.czapka);
            img4.setImageResource(R.drawable.czarnakoszula);
            img5.setImageResource(R.drawable.jeans);
            img6.setImageResource(R.drawable.unnamed);

        } else if (item.getItemId() == 2) {
            img1.setImageResource(R.drawable.spd1);
            img2.setImageResource(R.drawable.spd2);
            img3.setImageResource(R.drawable.spd6);
            img4.setImageResource(R.drawable.spd5);
            img5.setImageResource(R.drawable.spd4);
            img6.setImageResource(R.drawable.spd3);

        } else if (item.getItemId() == 3) {
            img1.setImageResource(R.drawable.kos1);
            img2.setImageResource(R.drawable.kos2);
            img3.setImageResource(R.drawable.kos3);
            img4.setImageResource(R.drawable.kos4);
            img5.setImageResource(R.drawable.kos5);
            img6.setImageResource(R.drawable.kos6);

        } else if (item.getItemId() == 4) {
            img1.setImageResource(R.drawable.kombinezon);
            img2.setImageResource(R.drawable.zestaw);
            img3.setImageResource(R.drawable.kaczka);
            img4.setImageResource(R.drawable.holibka);
            img5.setImageResource(R.drawable.kurtka);
            img6.setImageResource(R.drawable.unnamed);


        } else if (item.getItemId() == 5) {
            img1.setImageResource(R.drawable.spd1);
            img2.setImageResource(R.drawable.spd2);
            img3.setImageResource(R.drawable.spd6);
            img4.setImageResource(R.drawable.spd5);
            img5.setImageResource(R.drawable.spd4);
            img6.setImageResource(R.drawable.spd3);


        } else if (item.getItemId() == 6) {
            img1.setImageResource(0);
            img2.setImageResource(0);
            img3.setImageResource(0);
            img4.setImageResource(0);
            img5.setImageResource(0);
            img6.setImageResource(0);

            img5.setImageResource(R.drawable.moka_v2);
            img2.setImageResource(R.drawable.muka);

        }


        return super.onOptionsItemSelected(item);
    }

}
