package com.example.warfare.lunchpicker;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;


public class MyActivity extends Activity {
    TextView ResultView;
    Button btn_generate;
    String[] PersonSet = {"A", "B", "C", "D", "E", "F"};
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ResultView = (TextView)findViewById(R.id.RandomResult);
        btn_generate = (Button)findViewById(R.id.result_btn);

        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result1 = "", result2 = "";
                while(true) {
                    RandomGenerate();
                    result1 = list.get(0) + " " + list.get(1) + " " + list.get(2);
                    result2 = list.get(3) + " " + list.get(4) + " " + list.get(5);

                    //exclude only boy group
                    if(!(result1.contains(PersonSet[0]) && result1.contains(PersonSet[1]) && result1.contains(PersonSet[2]))
                            && !(result2.contains(PersonSet[0]) && result2.contains(PersonSet[1]) && result2.contains(PersonSet[2]))) {
                        break;
                    } else {
                        Log.e("@@@@@","damn!! boygroup generated... do it again");
                    }
                }
                ResultView.setText(result1+"\n\n"+result2);
                btn_generate.setVisibility(View.GONE);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void RandomGenerate() {
        Log.e("@@@@@","Random Generating...");
        list = new ArrayList<String>(6);

        for(int i = 0; i<6; i++) {
            list.add(PersonSet[i]);
        }
        Collections.shuffle(list);
    }
}
