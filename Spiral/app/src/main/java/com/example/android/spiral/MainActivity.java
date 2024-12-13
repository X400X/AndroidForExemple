package com.example.android.spiral;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;
    private EditText editText7;
    private EditText editText8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editTextNumberDecimal);
        editText2 = (EditText) findViewById(R.id.editTextNumberDecimal2);
        editText3 = (EditText) findViewById(R.id.editTextNumberDecimal3);
        editText4 = (EditText) findViewById(R.id.editTextNumberDecimal4);
        editText5 = (EditText) findViewById(R.id.editTextNumberDecimal6);
        editText6 = (EditText) findViewById(R.id.editTextNumberDecimal8);
        editText7 = (EditText) findViewById(R.id.editTextNumberDecimal5);
        editText8 = (EditText) findViewById(R.id.editTextNumber);


    }

    public void ClickStart (View view) {
        String l1 = editText1.getText().toString();
        String l2 = editText2.getText().toString();
        String a = editText3.getText().toString();
        String d = editText4.getText().toString();
        String xn = editText5.getText().toString();
        String apr = editText6.getText().toString();

        double l11, l12, a1, d1, xn1, apr1;
        l11 = Double.parseDouble(l1);
        l12 = Double.parseDouble(l2);
        a1 = Double.parseDouble(a);
        d1 = Double.parseDouble(d);
        xn1 = Double.parseDouble(xn);
        apr1 = Double.parseDouble(apr);

        double cac = (((Math.abs(l11-l12))/a1)*360)/(d1*3.14);
        double C = Math.toDegrees(Math.atan(cac));
        String C1 = Double.toString(C);
        editText7.setText(C1);

        double xc = ((((d1*3.14)/360)*apr1)*cac)+xn1;
        String XC = Double.toString(xc);
        editText8.setText(XC);

    }

    public void ClickClear (View view){
        String s = "0.0";
        editText1.setText(s);
        editText2.setText(s);
        editText3.setText(s);
        editText4.setText(s);
        editText5.setText(s);
        editText6.setText(s);
        editText7.setText(s);
        editText8.setText(s);
    }
}