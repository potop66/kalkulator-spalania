package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity4 extends ActionBarActivity {
    TextView wynik;
    EditText spalanie,dystans;
    float spalanie1 ,dystans1,wynik1;
    String spalanie2, dystans2,wynik2;
    int a=0;
    TextWatcher tw;

    public MainActivity4() {
        tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


                try {
                    spalanie2 = spalanie.getText() + "";
                    dystans2 = dystans.getText() + "";
                    dystans1 = Float.parseFloat(dystans2);
                    spalanie1 = Float.parseFloat(spalanie2);
                    wynik.setText("0.0");
                    wynik1 = spalanie1 / dystans1 * 100;
                    java.text.DecimalFormat df = new java.text.DecimalFormat();
                    df.setMaximumFractionDigits(2);
                    df.setMinimumFractionDigits(2);
                    wynik2 = (df.format(wynik1));
                    wynik.setText(wynik2);
                    return;
                } catch (Exception var2_6) {
                    wynik.setText("0.0");
                    return;
                }
            }
        };
    }

    @Override
    public void onBackPressed (){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4);
        spalanie=(EditText) findViewById (R.id.editText6);
        dystans=(EditText) findViewById (R.id.editText7);
        wynik=(TextView) findViewById (R.id.textView13);
        spalanie.addTextChangedListener(tw);
        dystans.addTextChangedListener(tw);

    }
}
