package com.example.android.bascetball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        private TextView textView;
        private TextView textView2;
        int a = 0;
        int b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView3);
        textView2 = (TextView) findViewById(R.id.textView4);
    }

    public void ClickClear (View view) {
        String s = "0";
        textView.setText(s);
        textView2.setText(s);
         a = 0;
         b = 0;
        }

    public void ClickClick (View w) {
        switch (w.getId()) {
            case R.id.button:
                a = a + 3;
                break;
            case R.id.button4:
                a = a + 2;
                break;
            case R.id.button6:
                a = a + 1;
                break;
            case R.id.button3:
                b = b + 3;
                break;
            case R.id.button5:
                b = b + 2;
                break;
            case R.id.button7:
                b = b + 1;
                break;
        }
        String s = ""+a;
        String s1 = ""+b;
        textView.setText(s);
        textView2.setText(s1);
    }

       /*
    public void TeamA1 (View view) {
        a = a + 1;
        String s = ""+a;
        textView.setText(s);
    }

    public void TeamA2 (View view) {
        a = a + 2;
        String s = ""+a;
        textView.setText(s);
    }

    public void TeamA3 (View view) {
        a = a + 3;
        String s = ""+a;
        textView.setText(s);
    }

    public void TeamB1 (View view) {
        b = b + 1;
        String s = ""+b;
        textView2.setText(s);
    }

    public void TeamB2 (View view) {
        b = b + 2;
        String s = ""+b;
        textView2.setText(s);
    }

    public void TeamB3 (View view) {
        b = b + 3;
        String s = ""+b;
        textView2.setText(s);
    }*/

}