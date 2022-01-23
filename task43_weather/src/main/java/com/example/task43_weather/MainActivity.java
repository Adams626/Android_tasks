package com.example.task43_weather;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    final String ATTR_NAME_TV = "TextView";
    final String ATTR_NAME_PB = "ProgressBar";
    final String ATTR_NAME_LL = "LinearLayout ";
    final String IMAGE ="Image";

    ListView lvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] percent = { 20, 62, 6, 30, 25, 54, 80, 94, 27, 14, 75,12};
        String[] days = {"1.12", "2.12", "3.12", "4.12", "5.12", "6.12", "7.12","8.12","9.12","10.12","11.12","12.12"};
        int[] degrees = {-1,4,10,12,8,12,0,-14,-7,-4,3,6};


        ArrayList<Map<String,Object>>data = new ArrayList<Map<String,Object>>(
                percent.length
        );
        Map<String,Object>m;
        int j=0;
        for(int i = 0; i < percent.length; i++) {
            if (j>=days.length){
                j=0;
            }
            m = new HashMap<String, Object>();
            m.put(IMAGE,degrees[i]);
            m.put(ATTR_NAME_TV, days[j]  + ". Temperature: "+ degrees[i]+ ". Humidity: "+ percent[i] + "%");
            m.put(ATTR_NAME_PB, percent[i]);
            m.put(ATTR_NAME_LL, degrees[i]);
            data.add(m);
            j++;
        }
        // array of attribute names from which data will be read
        String[] from = { IMAGE, ATTR_NAME_TV, ATTR_NAME_PB,
                ATTR_NAME_LL };
        // array of IDs of View-components, in which data will be put in
        int[] to = {R.id.imgItem, R.id.tvInput, R.id.pbInput, R.id.llInput };

        // сreate adapter
        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.item,
                from, to);
        // set binder for adapter
        sAdapter.setViewBinder(new MyViewBinder());

        // create list and assign it to adapter
        lvList = (ListView) findViewById(R.id.lvList);
        lvList.setAdapter(sAdapter);

    }
    class MyViewBinder implements SimpleAdapter.ViewBinder {
        int blue=getResources().getColor(R.color.Blue);
        int green=getResources().getColor(R.color.Green);
        int yellow=getResources().getColor(R.color.Yellow);


        @Override
        public boolean setViewValue(View view, Object data, String textRepresentation) {
            int i;
            switch (view.getId()) {
                case R.id.imgItem:
                    i = ((Integer) data).intValue();
                    if (i < 0) ((ImageView) view).setImageResource(R.drawable.snow); else
                    if (i == 0) ((ImageView) view).setImageResource(R.drawable.cloud); else
                    if (i > 0) ((ImageView) view).setImageResource(R.drawable.sun);
                    return true;
                case R.id.llInput:
                    i = ((Integer) data).intValue();
                    if (i < 0) view.setBackgroundColor(blue); else
                    if (i == 0) view.setBackgroundColor(green); else
                    if (i > 0) view.setBackgroundColor(yellow);
                    return true;
                case R.id.pbInput:
                    i = ((Integer) data).intValue();
                    ((ProgressBar) view).setProgress(i);
                    return true;
            }
            return false;
        }

    }

}