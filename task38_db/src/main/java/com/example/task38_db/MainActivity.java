package com.example.task38_db;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {


    TextView textViewOutput;
    EditText etID, etName, etSurname;
    Button btEdit,btDeleteAll, btShow;
    RadioGroup rgGender;
    RadioButton rbGender;
    FloatingActionButton fbtAdd;


    DBHelper dbHelper;





    final String TAG="databaseLogs";

    public void selectSortowanie(String metodaSortowania, SQLiteDatabase db) {
        textViewOutput.setText("");

        Cursor c = db.query("dbtable", null, null, null, null, null, metodaSortowania);
        if (c.moveToFirst()) {
            int idColIndex = c.getColumnIndex("id");
            int imieColIndex = c.getColumnIndex("imie");
            int nazwiskoColIndex = c.getColumnIndex("nazwisko");
            int plecColIndex = c.getColumnIndex("plec");
            do {
                String nowaLinia = "ID = " + c.getInt(idColIndex) +
                        ", imie = " + c.getString(imieColIndex) +
                        ", nazwisko = " + c.getString(nazwiskoColIndex) +
                        ", plec = " + c.getString(plecColIndex);


                textViewOutput.append(nowaLinia + "\n\n");


                Log.d(TAG, nowaLinia);
            } while (c.moveToNext());
        } else
            Toast.makeText(this, "no data available to select", Toast.LENGTH_SHORT).show();
        c.close();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);

        rgGender = (RadioGroup) findViewById(R.id.rg_gender);

        btEdit = findViewById(R.id.btEdit);
        btDeleteAll = findViewById(R.id.btClear);
        btShow=findViewById(R.id.btShow);
        fbtAdd=findViewById(R.id.fbtAdd);
        textViewOutput=findViewById(R.id.textViewOutput);

        btShow.setOnClickListener(this);
        btEdit.setOnClickListener(this);
        btDeleteAll.setOnClickListener(this);
        fbtAdd.setOnClickListener(this);



        dbHelper = new DBHelper(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sort, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        switch (item.getItemId()){
            case(R.id.acotion_nazwisko):
                Log.d(TAG, "--- -- --Sortowanie rekordów po nazwisku--- --- ---");
                selectSortowanie("nazwisko", db);
                break;
            case(R.id.action_imie):
                Log.d(TAG, "--- -- --Sortowanie rekordów po nazwisku--- --- ---");
                selectSortowanie("imie", db);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {



        int zaznaczonaPlec = rgGender.getCheckedRadioButtonId();
        rbGender = (RadioButton) findViewById(zaznaczonaPlec);
        String sex = rbGender.getText().toString();
        Log.d(TAG, "onClick"  );

        ContentValues cv = new ContentValues();


        String id = etID.getText().toString();
        String imie = etName.getText().toString();
        String nazwisko = etSurname.getText().toString();
        String plec = sex;



        SQLiteDatabase db = dbHelper.getWritableDatabase();

        switch(v.getId()) {
            case R.id.fbtAdd:
                Log.d(TAG, "--- --- ---Dodanie rekordu do tabeli--- --- ---");


                cv.put("imie", imie);
                cv.put("nazwisko", nazwisko);
                cv.put("plec", plec);

                long rowID = db.insert("dbtable", null, cv);
                Toast.makeText(this, "last inserted id="+rowID, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btEdit:
                if (    id.equalsIgnoreCase("")) {
                    break;
                }
                Log.d(TAG, "--- --- ---Modyfikacja rekordu z tabeli--- --- ---");

                cv.put("imie", imie);
                cv.put("nazwisko", nazwisko);
                cv.put("plec", plec);

                int updRowsCount = db.update("dbtable", cv, "id = ?",
                        new String[] { id });
                //Log.d(TAG, "updated rows count = " + updRowsCount);
                Toast.makeText(this, "updated rows = " + updRowsCount, Toast.LENGTH_SHORT).show();
                break;

            case R.id.btClear:
                Log.d(TAG, "--- -- --Usuwanie wszystkich rekordów z tabeli--- --- ---");

                int delCount = db.delete("dbtable", null, null);

                Toast.makeText(this, "deleted rows = " + delCount, Toast.LENGTH_SHORT).show();
                textViewOutput.setText("");
                break;
            case R.id.btShow:

                Log.d(TAG, "-=Select from dbtable=-");
                //make a request for all data from the table mytable, get Cursor
                Cursor c = db.query("dbtable", null, null, null, null, null, "ID");

                //put the cursor position on the first line of the selection
                //if there are no rows in the selection, return false
                if (c.moveToFirst()) {

                    //determine the column numbers by name
                    int idColIndex = c.getColumnIndex("id");
                    int nameColIndex = c.getColumnIndex("imie");
                    int surnameColIndex = c.getColumnIndex("nazwisko");
                    int plecColIndex = c.getColumnIndex("plec");


                    do {
                        //get values by column numbers and write everything to the log
                        String text = "id = " + c.getInt(idColIndex) +
                                ", name = " + c.getString(nameColIndex) +
                                ", surname = " + c.getString(surnameColIndex) +
                                ", pleć = " + c.getString(plecColIndex);

                        Log.d(TAG,
                                text);
                        textViewOutput.append(text+"\n\n");
                        // move to next row
                        // if there is now next row (current row is the last ), return false and exit from the loop
                    } while (c.moveToNext());
                } else
                    //Log.d(TAG, "0 rows");
                    Toast.makeText(this, "no data available to select", Toast.LENGTH_SHORT).show();
                c.close();
                break;

        }


        dbHelper.close();
    }
    class DBHelper extends SQLiteOpenHelper {



        public DBHelper(Context context) {
            super(context, "clientDBDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(TAG, "onCreate database");

            db.execSQL("create table dbtable ("
                    + "id integer primary key autoincrement,"
                    + "imie text,"
                    + "nazwisko text,"
                    + "plec text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d(TAG, "onUpgrade database");
        }

    }
}
