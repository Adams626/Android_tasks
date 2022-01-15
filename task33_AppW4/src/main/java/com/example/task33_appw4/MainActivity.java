package com.example.task33_appw4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rgPrzystawki, rgZupy, rgDodatki;
    RadioButton rBPrzystawki, rBZupy, rBDodatki;
    Button btnZapisz, btnZaladuj, btnWyczysc;

    SharedPreferences prefValue;

    final String PRZYSTAWKI = "Wybrane przystawki";
    final String ZUPY = "Wybrane zupy";
    final String DODATKI = "Wybrane dodatki";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgPrzystawki = (RadioGroup) findViewById(R.id.rgPrzystawki);
        rgZupy = (RadioGroup) findViewById(R.id.rgZupy);
        rgDodatki = (RadioGroup) findViewById(R.id.rgDodatki) ;

        btnZapisz = (Button) findViewById(R.id.btZapisz);
        btnZapisz.setOnClickListener(this);

        btnZaladuj = (Button) findViewById(R.id.btZaladuj);
        btnZaladuj.setOnClickListener(this);

        btnWyczysc = (Button) findViewById(R.id.btWyczysc);
        btnWyczysc.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btZapisz:
                zapiszListe();
                break;
            case R.id.btZaladuj:
                zaladujListe();
                break;
            case R.id.btWyczysc:
                usunListe();
                break;
        }
    }

    public void zapiszListe() {
        int selectedPrzystawki = rgPrzystawki.getCheckedRadioButtonId();
        rBPrzystawki = (RadioButton) findViewById(selectedPrzystawki);
        int indexPrzystawki = rgPrzystawki.indexOfChild(rBPrzystawki);

        int selectedZupy =  rgZupy.getCheckedRadioButtonId();
        rBZupy = (RadioButton) findViewById(selectedZupy);
        int indexZupy = rgZupy.indexOfChild(rBZupy);

        int selectedDodatki =  rgDodatki.getCheckedRadioButtonId();
        rBDodatki = (RadioButton) findViewById(selectedDodatki);
        int indexDodatki = rgDodatki.indexOfChild(rBDodatki);

        prefValue = getPreferences(MODE_PRIVATE);
        Editor edit = prefValue.edit();

        edit.putString(PRZYSTAWKI, String.valueOf(indexPrzystawki));
        edit.putString(ZUPY, String.valueOf(indexZupy));
        edit.putString(DODATKI, String.valueOf(indexDodatki));

        rgPrzystawki.clearCheck();
        rgZupy.clearCheck();
        rgDodatki.clearCheck();

        edit.commit();
        Toast.makeText(this, "Zapisano liste", Toast.LENGTH_SHORT).show();

    }

    public void zaladujListe() {

        try {
            prefValue = getPreferences(MODE_PRIVATE);

            String wybranaPrzystawka = prefValue.getString(PRZYSTAWKI, "");
            ((RadioButton)rgPrzystawki.getChildAt(Integer.parseInt(wybranaPrzystawka))).setChecked(true);

            Toast.makeText(this, "Pomyślnie wczytano.", Toast.LENGTH_SHORT).show();
        }
        catch (Exception exception) {
            Toast.makeText(this, "Brak zaznaczonej opcji z menu przystawek", Toast.LENGTH_SHORT).show();
        }

        try {
            prefValue = getPreferences(MODE_PRIVATE);

            String wybranaZupa = prefValue.getString(ZUPY, "");
            ((RadioButton)rgZupy.getChildAt(Integer.parseInt(wybranaZupa))).setChecked(true);

            Toast.makeText(this, "Pomyślnie wczytano.", Toast.LENGTH_SHORT).show();
        }
        catch (Exception exception) {
            Toast.makeText(this, "Brak zaznaczonej opcji z menu zup", Toast.LENGTH_SHORT).show();
        }

        try {
            prefValue = getPreferences(MODE_PRIVATE);

            String wybranyDodatek = prefValue.getString(DODATKI, "");
            ((RadioButton)rgDodatki.getChildAt(Integer.parseInt(wybranyDodatek))).setChecked(true);

            Toast.makeText(this, "Pomyślnie wczytano.", Toast.LENGTH_SHORT).show();
        }
        catch (Exception exception) {
            Toast.makeText(this, "Brak zaznaczonej opcji z menu dodatków", Toast.LENGTH_SHORT).show();
        }

    }

    public void usunListe() {
        rgPrzystawki.clearCheck();
        rgZupy.clearCheck();
        rgDodatki.clearCheck();

        int selectedPrzystawki = rgPrzystawki.getCheckedRadioButtonId();
        rBPrzystawki = (RadioButton) findViewById(selectedPrzystawki);
        int indexPrzystawki = rgPrzystawki.indexOfChild(rBPrzystawki);

        int selectedZupy =  rgZupy.getCheckedRadioButtonId();
        rBZupy = (RadioButton) findViewById(selectedZupy);
        int indexZupy = rgZupy.indexOfChild(rBZupy);

        int selectedDodatki =  rgDodatki.getCheckedRadioButtonId();
        rBDodatki = (RadioButton) findViewById(selectedDodatki);
        int indexDodatki = rgDodatki.indexOfChild(rBDodatki);

        prefValue = getPreferences(MODE_PRIVATE);
        Editor ed = prefValue.edit();

        ed.putString(PRZYSTAWKI, String.valueOf(indexPrzystawki));
        ed.putString(ZUPY, String.valueOf(indexZupy));
        ed.putString(DODATKI, String.valueOf(indexDodatki));

        rgPrzystawki.clearCheck();
        rgZupy.clearCheck();
        rgDodatki.clearCheck();

        ed.commit();
        Toast.makeText(this, "Usunięto zapis", Toast.LENGTH_SHORT).show();
    }


}

