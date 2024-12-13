package com.example.trip;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextNumberDecimal);
        editText2 = findViewById(R.id.editTextNumberDecimal2);
        editText3 = findViewById(R.id.editTextNumberDecimal3);
        editText4 = findViewById(R.id.editTextNumberDecimal4);
        editText5 = findViewById(R.id.editTextNumberDecimal5);
        editText6 = findViewById(R.id.editTextNumber);



    }

    public void ClickStart (View view) {

        String a = editText.getText().toString();
        String b = editText2.getText().toString();
        String c = editText3.getText().toString();
        String A = editText4.getText().toString();
        String B = editText5.getText().toString();





    if (!a.equals("") & !b.equals(""))  {
        part1(a, b);
    } else if (!a.equals("") & !c.equals("")) {
        part2(a, c);
    } else if (!b.equals("") & !c.equals("")) {
        part3(b, c);
    } else if (!a.equals("") & !A.equals("")) {
        part4(a, A);
    } else if (!a.equals("") & !B.equals("")) {
        part5(a, B);
    } else if (!b.equals("") & !A.equals("")) {
        part6(b, A);
    } else if (!b.equals("") & !B.equals("")) {
        part7(b, B);
    } else if (!c.equals("") & !A.equals("")) {
        part8(c, A);
    } else if (!c.equals("") & !B.equals("")) {
        part9(c, B);
    } else if (!A.equals("") & !B.equals("")) {
        String s = "Привет, значения неверны, и если ты их измениш, то твоя жизнь измениться, найдешь нормальную работу, дувушку и еще много чего";
        message(s);


    } else {
        part11();
    }




    }

    private void part11() {
        String s = "";
        editText.setText(s);
        editText2.setText(s);
        editText3.setText(s);
        editText4.setText(s);
        editText5.setText(s);
    }



    public void part1 (String s1, String s2){
        double a, b, c, A, B;
         a = Double.parseDouble(s1);
         b = Double.parseDouble(s2);
         c = Math.sqrt((a*a)+(b*b));
         editText3.setText(round(c));

         A = Math.toDegrees(Math.asin(a/c));
         editText4.setText(round(A));
         B = Math.toDegrees(Math.acos(a/c));
         editText5.setText(round(B));
         }

    public void part2 (String s1, String s2){
          double a, b, c, A, B;
          a = Double.parseDouble(s1);
          c = Double.parseDouble(s2);
          b = Math.sqrt((c*c)-(a*a));
          editText2.setText(round(b));

          A = Math.toDegrees(Math.asin(a/c));
          editText4.setText(round(A));
          B = Math.toDegrees(Math.acos(a/c));
          editText5.setText(round(B));
        }

    public void part3 (String s1, String s2){
        double a, b, c, A, B;
        b = Double.parseDouble(s1);
        c = Double.parseDouble(s2);
        a = Math.sqrt((c*c)-(b*b));
        editText.setText(round(a));


        A = Math.toDegrees(Math.asin(a/c));
        editText4.setText(round(A));
        B = Math.toDegrees(Math.acos(a/c));
        editText5.setText(round(B));
    }

    public void part4 (String s1, String s2){
        double a, b, c, A, B;
        a = Double.parseDouble(s1);
        A = Double.parseDouble(s2);

        c = a/Math.cos(Math.toRadians(A));
        editText3.setText(round(c));
        b = Math.sqrt((c*c)-(a*a));
        editText2.setText(round(b));
        B = Math.toDegrees(Math.acos(a/c));
        editText5.setText(round(B));
    }

    public void part5 (String s1, String s2){
        double a, b, c, A, B;
        a = Double.parseDouble(s1);
        B = Double.parseDouble(s2);

        c = a/Math.sin(Math.toRadians(B));
        editText3.setText(round(c));
        b = Math.sqrt((c*c)-(a*a));
        editText2.setText(round(b));
        A = Math.toDegrees(Math.asin(a/c));
        editText4.setText(round(A));
    }

    public void part6 (String s1, String s2){
        double a, b, c, A, B;
        b = Double.parseDouble(s1);
        A = Double.parseDouble(s2);

        c = b/Math.sin(Math.toRadians(A));
        editText3.setText(round(c));
        a = Math.sqrt((c*c)-(b*b));
        editText.setText(round(a));
        B = Math.toDegrees(Math.acos(a/c));
        editText5.setText(round(B));
    }

    public void part7 (String s1, String s2){
        double a, b, c, A, B;
        b = Double.parseDouble(s1);
        B = Double.parseDouble(s2);

        c = b/Math.cos(Math.toRadians(B));
        editText3.setText(round(c));
        a = Math.sqrt((c*c)-(b*b));
        editText.setText(round(a));
        A = Math.toDegrees(Math.asin(a/c));
        editText4.setText(round(A));
    }

    public void part8 (String s1, String s2){
        double a, b, c, A, B;
        c = Double.parseDouble(s1);
        A = Double.parseDouble(s2);

        a = c*Math.cos(Math.toRadians(A));
        editText.setText(round(a));
        b = c*Math.sin(Math.toRadians(A));
        editText2.setText(round(b));
        B = Math.toDegrees(Math.acos(a/c));
        editText5.setText(round(B));
    }

    public void part9 (String s1, String s2){
        double a, b, c, A, B;
        c = Double.parseDouble(s1);
        B = Double.parseDouble(s2);

        a = c*Math.sin(Math.toRadians(B));
        editText.setText(round(a));
        b = c*Math.cos(Math.toRadians(B));
        editText2.setText(round(b));
        A = Math.toDegrees(Math.asin(a/c));
        editText4.setText(round(A));
    }

    public void message (String s1){

        //Toast.makeText(getApplicationContext(), s1, Toast.LENGTH_SHORT).show();

        Toast toast = Toast.makeText(getApplicationContext(), s1, Toast.LENGTH_SHORT);
        toast.show();
    }




    public void ClickClear (View view){
        String s = "";
        editText.setText(s);
        editText2.setText(s);
        editText3.setText(s);
        editText4.setText(s);
        editText5.setText(s);
    }

    public String round (double q) {
        String s = editText6.getText().toString();
        int qua = 3;


        if (s.equals(""))  qua = 0;
        else if (Integer.parseInt(s) <= 0) qua = 0;
        else if (Integer.parseInt(s) > 10) qua = 10;
        else qua = Integer.parseInt(s);

        q = Math.floor(q*Math.pow(10, qua+1));
        q = q /10;
        double x =  Math.floor(q);
        double z = q-x;
        if(z>=0.5)  x++;
        x = x / (Math.pow(10, qua));
        String s1 = Double.toString(x);
        return s1;
    }



}