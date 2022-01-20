package com.example.task21_applicationretailstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img1, img2,img3,img4;
    TextView title,tv1, tv2, tv3,tv4;


    public void setClear(){
        tv1.setText("");
        tv2.setText("");
        tv3.setText("");
        tv4.setText("");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=findViewById(R.id.title);
        tv1= findViewById(R.id.tv1);
        tv2= findViewById(R.id.tv2);
        tv3= findViewById(R.id.tv3);
        tv4= findViewById(R.id.tv4);
        img1= findViewById(R.id.img1);
        img2= findViewById(R.id.img2);
        img3= findViewById(R.id.img3);
        img4= findViewById(R.id.img4);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Promocja!!!!!!!!!!");
                builder.setMessage("Tylko dzisiaj promocyjna cena 21.37 zł")    ;
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Kupon dodany", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case(R.id.action_wódka):
                setClear();
                title.setText("Wódeczka");
                img1.setImageResource(R.drawable.wo1);
                img2.setImageResource(R.drawable.wo2);
                img3.setImageResource(R.drawable.wo3);
                img4.setImageResource(R.drawable.wo1);
                Toast.makeText(MainActivity.this,"Wybrałeś "+item.getTitle(),Toast.LENGTH_LONG).show();

                return true;
            case(R.id.action_wina):
                setClear();
                title.setText("Amarena");
                img1.setImageResource(R.drawable.wcz1);
                img2.setImageResource(R.drawable.wb1);
                img3.setImageResource(R.drawable.wr1);
                img4.setImageResource(R.drawable.wcz2);
                Toast.makeText(MainActivity.this,"Wybrałeś "+item.getTitle(),Toast.LENGTH_LONG).show();

                break;
            case(R.id.action_whisky):
                setClear();
                title.setText("Whiskacz");
                img1.setImageResource(R.drawable.w1);
                img2.setImageResource(R.drawable.w2);
                img3.setImageResource(R.drawable.w3);
                img4.setImageResource(R.drawable.w1);
                Toast.makeText(MainActivity.this,"Wybrałeś "+item.getTitle(),Toast.LENGTH_LONG).show();
                break;
            case(R.id.action_likier):
                setClear();
                title.setText("Likier");
                img1.setImageResource(R.drawable.l1);
                img2.setImageResource(R.drawable.l2);
                img3.setImageResource(R.drawable.l3);
                img4.setImageResource(R.drawable.l1);
                Toast.makeText(MainActivity.this,"Wybrałeś "+item.getTitle(),Toast.LENGTH_LONG).show();
                break;
            case(R.id.cena1):
                tv1.setText("20zł");
                tv2.setText("140zł");
                tv3.setText("30zł");
                tv4.setText("74zł");
                break;

            case(R.id.producent1):
                tv1.setText("Żubrówka");
                tv2.setText("Stock");
                tv3.setText("Wokulski");
                tv4.setText("Żubrówka");
                break;
            case(R.id.objetosc1):
                tv1.setText("500ml");
                tv2.setText("500ml");
                tv3.setText("500ml");
                tv4.setText("750ml");
                break;
            case(R.id.cena2):
                tv1.setText("30zł");
                tv2.setText("40zł");
                tv3.setText("120zł");
                tv4.setText("54zł");
                break;

            case(R.id.producent2):
                tv1.setText("Belvado");
                tv2.setText("Amarena");
                tv3.setText("Sqeua");
                tv4.setText("Carlo Rose");
                break;
            case(R.id.objetosc2):
                tv1.setText("500ml");
                tv2.setText("400ml");
                tv3.setText("250ml");
                tv4.setText("400ml");
                break;
            case(R.id.cena3):
                tv1.setText("40zł");
                tv2.setText("30zł");
                tv3.setText("64zł");
                tv4.setText("16zł");
                break;

            case(R.id.producent3):
                tv1.setText("Sheridan");
                tv2.setText("Copii");
                tv3.setText("Jamaica");
                tv4.setText("Camello");
                break;
            case(R.id.objetosc3):
                tv1.setText("100ml");
                tv2.setText("500ml");
                tv3.setText("500ml");
                tv4.setText("1l");
                break;
            case(R.id.cena4):
                tv1.setText("200zł");
                tv2.setText("79zł");
                tv3.setText("105zł");
                tv4.setText("4zł");
                break;

            case(R.id.producent4):
                tv1.setText("The Langlander");
                tv2.setText("Baltines");
                tv3.setText("HighLander");
                tv4.setText("OlololxD");
                break;
            case(R.id.objetosc4):
                tv1.setText("500ml");
                tv2.setText("500ml");
                tv3.setText("500ml");
                tv4.setText("500ml");
                break;

        }


        return super.onOptionsItemSelected(item);
    }

}