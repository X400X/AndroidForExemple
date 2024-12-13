package com.example.android.testsandvik2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private TextView textView2;
    private TextView textView21;
    private TextView textView22;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextNumberDecimal);
        editText2 = findViewById(R.id.editTextNumberDecimal2);
        editText3 = findViewById(R.id.editTextNumberDecimal3);
        editText4 = findViewById(R.id.editTextNumberDecimal4);
        textView2 = findViewById(R.id.textView10);
        textView21 = findViewById(R.id.textView13);
        textView22 = findViewById(R.id.textView14);
        checkBox = findViewById(R.id.left);
    }

    public void ClickStart (View view) {
        if (editText.getText().toString().equals("")) {
            message("X+ не указан.");
            return;
        }
        if (editText2.getText().toString().equals("")) {
            message("X- не указан.");
            return;
        }
        if (editText3.getText().toString().equals("")) {
            message("Q10 не указан.");
            return;
        }

        String a ="";
        String b ="";
        String c ="";
        String d ="";

        a = editText.getText().toString();
        b = editText2.getText().toString();
        c = editText3.getText().toString();
        d = editText4.getText().toString();

        if (a.equals("0")) message("X+ не может быть ноль");
        if (a.equals("0.")) message("X+ не может быть 0.");
        if (b.equals("0")) message("X- не может быть ноль");
        if (b.equals("0.")) message("X- не может быть 0.");
        if (c.equals("0")) message("Q10 start не может быть ноль");
        if (c.equals("0.")) message("Q10 start не может быть 0.");

        getResponse(a, b, c, d);
    }

    public void message (String s1) {
        //Toast.makeText(getApplicationContext(), s1, Toast.LENGTH_SHORT).show();
        Toast toast = Toast.makeText(getApplicationContext(), s1, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void getResponse (String s1, String s2, String s3, String s4) {
        double a, b, ab, abd, c, d, q, zzz, xxx, qq;
        a = Double.parseDouble(s1);
        b = Double.parseDouble(s2);
        c = Double.parseDouble(s3);
        d = Double.parseDouble(s4);
        ab = (a + b)/2;
        zzz = Math.abs((-a + b)/2);
        textView21.setText(round(ab));
        abd = (ab + d)/2;
        xxx = Math.abs(((-ab) + d)/2);
        textView22.setText(round(abd));

        if (a > b) {
            q = c + zzz;
        } else {
            q = c - zzz; 
        }
        if (d == 0) textView2.setText(round(q));
        else {
            if (checkBox.isChecked()) {
                qq = q - xxx;
            } else {
                qq = q + xxx;
            }
            textView2.setText(round(qq));
        }
    }


    public String round (double q) {
        int qua = 3;
        q = Math.floor(q*Math.pow(10, qua+1));
        q = q /10;
        double x =  Math.floor(q);
        double z = q-x;
        if(z>=0.5)  x++;
        x = x / (Math.pow(10, qua));
        String s1 = Double.toString(x);
        return s1;
    }


    public void onCheckboxClicked(View view) {
        checkBox = (CheckBox) view;
        if(checkBox.isChecked()) {
            checkBox.setText(R.string.right_side);
        }
        else {
            checkBox.setText(R.string.left_side);
        }
    }
}