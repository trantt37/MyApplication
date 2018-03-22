package com.example.carolinebudwell.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static android.widget.Toast.*;
import static com.example.carolinebudwell.myapplication.firstFragment.EXTRA_MESSAGE;

/**
 * Created by carolinebudwell on 2/19/18.
 */

public class Results extends AppCompatActivity {
    private TextView mDisplay;
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        mDisplay = (TextView) findViewById(R.id.TVword);

        String input = "";
        String output="";
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if(bundle.getString(EXTRA_MESSAGE) != null) {
                makeText(getApplicationContext(),
                        "data:" + bundle.getString(EXTRA_MESSAGE),
                        LENGTH_LONG).show();
                input = bundle.getString(EXTRA_MESSAGE);

                 output=helper.searchPair(input);
                System.out.println(output);
                if(!output.equals(""))
                    mDisplay.setText(output);
                else
                    mDisplay.setText("Word not found.");



            }
        }
    }
}
