package com.example.carolinebudwell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EnterValues extends AppCompatActivity {

    private EditText mEnglishEdit;
    private EditText mSpanishEdit;
    private TextView mEnglishText;
    private TextView mSpanishText;
    private Button mSubmit;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_values);
        mEnglishEdit = (EditText) findViewById(R.id.editText);
        mSpanishEdit = (EditText) findViewById(R.id.editText2);
        mEnglishText = (TextView) findViewById(R.id.textView);
        mSpanishText = (TextView) findViewById(R.id.textView3);
        mSubmit = (Button) findViewById(R.id.button3);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Entry e = new Entry();
                e.setSynonym(mEnglishEdit.getText().toString());
                e.setAntonym(mSpanishEdit.getText().toString());
                helper.insertEntry(e);
                startActivity(new Intent(EnterValues.this, MainActivity.class));
            }
        });
    }
}
