package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class ObliczIloscSpalonejBenzyny extends ActionBarActivity {
    TextView wynik;
    EditText przejechaneKm,spalanieNa100km;
    TextWatcher tw;
    Double przejechaneKmD, spalanieNa100kmD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oblicz_ilosc_spalonej_benzyny);
        wynik = (TextView) findViewById(R.id.textView5);
        przejechaneKm = (EditText) findViewById(R.id.editText);
        spalanieNa100km = (EditText) findViewById(R.id.editText3);
        SharedPreferences sp=getSharedPreferences("Settings",MODE_PRIVATE);
        if(sp.getInt("dystans",0)==1 &&sp.getInt("pojemnosc",0)!=0){
            TextView dystans=(TextView) findViewById(R.id.textView);
            TextView srednieSpalanie=(TextView) findViewById(R.id.textView3);
            TextView iloscSpalonejBenzyny=(TextView) findViewById(R.id.textView4);
            przejechaneKm.setHint("Odleglosc w milach");
           dystans.setText(R.string.przejechaneMile);
            if(sp.getInt("pojemnosc",0)==1){
                srednieSpalanie.setText(R.string.liczbaSpalonychGalonowUsNa100Mil);
                iloscSpalonejBenzyny.setText(R.string.iloscSpalonejBenzynyWGalachUs);
            }else{
                srednieSpalanie.setText(R.string.liczbaSpalonychGalonowUeNa100Mil);
                iloscSpalonejBenzyny.setText(R.string.iloscSpalonejBenzynyWGalachUe);

            }
        }else if(sp.getInt("dystans",0)==1) {
            TextView dystans=(TextView) findViewById(R.id.textView);
            TextView srednieSpalanie=(TextView) findViewById(R.id.textView3);

            przejechaneKm.setHint("Odleglosc w milach");
            dystans.setText(R.string.przejechaneMile);
            srednieSpalanie.setText(R.string.liczbaSpalonychLitrowNa100Mil);

        }else if(sp.getInt("pojemnosc",0)!=0){
            TextView srednieSpalanie=(TextView) findViewById(R.id.textView3);
            TextView iloscSpalonejBenzyny=(TextView) findViewById(R.id.textView4);
            if (sp.getInt("pojemnosc", 0) == 1) {
                srednieSpalanie.setText(R.string.liczbaSpalonychGalonowUsNa100Km);
                iloscSpalonejBenzyny.setText(R.string.iloscSpalonejBenzynyWGalachUs);

            }else if (sp.getInt("pojemnosc", 0) == 2){
                srednieSpalanie.setText(R.string.liczbaSpalonychGalonowUeNa100Km);
                iloscSpalonejBenzyny.setText(R.string.iloscSpalonejBenzynyWGalachUe);

            }
        }
        przejechaneKm.addTextChangedListener(tw);
        spalanieNa100km.addTextChangedListener(tw);
    }

    public ObliczIloscSpalonejBenzyny(){
        tw=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    przejechaneKmD=Double.parseDouble(przejechaneKm.getText()+"");
                    spalanieNa100kmD=Double.parseDouble(spalanieNa100km.getText()+"");
                    Double wynik1=(przejechaneKmD/100)*spalanieNa100kmD;
                    java.text.DecimalFormat df = new java.text.DecimalFormat();
                    df.setMaximumFractionDigits(2);
                    df.setMinimumFractionDigits(2);
                    String wynik2 = (df.format(wynik1));
                    wynik.setText(wynik2);
                }catch(Exception var2_5){
                    wynik.setText(R.string.wrongScore);
                }
            }
        };
    }
}
