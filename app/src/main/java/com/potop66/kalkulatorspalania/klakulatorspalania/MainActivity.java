package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity {
    ListView ListView;
    TextView a;
    List<Map<String, String>> data = new ArrayList<Map<String, String>>();
    String title[] = new String[]{
            "Oblicz  spalanie na 100 km",
            "Oblicz koszt spalonej benzyny",
            "Oblicz ilość kupionej benzyny ",
            "Oblicz przejechane kilometry",
            "Oblicz ilosc spalonej benzyny"};
    String subtitle[]=new String[]{
            "znając ilośc spalonej benzyny i przejechane kilometry ",
            "znając odległosc, cene i spalanie na 100 km",
            "znając wydaną kwote i cene benzyny",
            "znając spalone litry i spalanie na 100 km",
            "znajac przejechane km oraz spalanie na 100 km"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView = (ListView) findViewById(R.id.listView);
         a=(TextView) findViewById(R.id.textView14);
        final Context context = this;


        for (int j=0; j<title.length; j++){
            HashMap hashMap=new HashMap();
            hashMap.put("title", title[j]);
            hashMap.put("subtitle", subtitle[j]);
            data.add(hashMap);
        }
        SimpleAdapter adapter=new SimpleAdapter(this,
                data,
                android.R.layout.simple_list_item_2,
                new String[]{"title", "subtitle"},
                new int[] {android.R.id.text1, android.R.id.text2});

        ListView.setAdapter(adapter);
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                int itemPosition = position;

                switch (itemPosition) {
                    case 0:
                            Intent i = new Intent(context, ObliczSpalanieNa100km.class);
                            startActivity(i);

                        break;

                    case 1:
                        Intent c = new Intent(context, ObliczCeneSpalonejBenzyny.class);
                        startActivity(c);
                        break;

                    case 2:
                        Intent b = new Intent(context, ObliczIloscKupionejBenzyny.class);
                        startActivity(b);
                        break;

                    case 3:
                        Intent e =new Intent(context, ObliczPrzejechaneKilometry.class);
                        startActivity(e);
                        break;
                    case 4:
                        Intent a=new Intent(context, ObliczIloscSpalonejBenzyny.class);
                        startActivity(a);
                        break;


                }
            }

        });


    }
}