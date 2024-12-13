package com.example.a5point;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private LinearLayout l11, l12, l13, l14, l15;
    private LinearLayout l21, l22, l23, l24, l25;
    private LinearLayout l31, l32, l33, l34, l35;
    private LinearLayout l41, l42, l43, l44, l45;
    private LinearLayout l51, l52, l53, l54, l55;
    int [] array = {1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,4,4,4,4,4,5,5,5,5,0};

    private final SparseArray<LinearLayout> viewMap = new SparseArray<>();

    int [][] simpleArray = {
            {7, 7, 7, 7, 7, 7, 7},
            {7, 7, 7, 7, 7, 7, 7},
            {7, 7, 7, 7, 7, 7, 7},
            {7, 7, 7, 7, 7, 7, 7},
            {7, 7, 7, 7, 7, 7, 7},
            {7, 7, 7, 7, 7, 7, 7},
            {7, 7, 7, 7, 7, 7, 7},
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);

        shuffleArray();
        findView();
        setColorInArray();
        setColorApp();



    }

    /*public void Click(View view) {
        int a = view.getId();
        if (a == R.id.l11) checkPoint(1,1);
        else if (a == R.id.l12) checkPoint(1,2);
        else if (a == R.id.l13) checkPoint(1,3);
        else if (a == R.id.l14) checkPoint(1,4);
        else if (a == R.id.l15) checkPoint(1,5);
        else if (a == R.id.l21) checkPoint(2,1);
        else if (a == R.id.l22) checkPoint(2,2);
        else if (a == R.id.l23) checkPoint(2,3);
        else if (a == R.id.l24) checkPoint(2,4);
        else if (a == R.id.l25) checkPoint(2,5);
        else if (a == R.id.l31) checkPoint(3,1);
        else if (a == R.id.l32) checkPoint(3,2);
        else if (a == R.id.l33) checkPoint(3,3);
        else if (a == R.id.l34) checkPoint(3,4);
        else if (a == R.id.l35) checkPoint(3,5);
        else if (a == R.id.l41) checkPoint(4,1);
        else if (a == R.id.l42) checkPoint(4,2);
        else if (a == R.id.l43) checkPoint(4,3);
        else if (a == R.id.l44) checkPoint(4,4);
        else if (a == R.id.l45) checkPoint(4,5);
        else if (a == R.id.l51) checkPoint(5,1);
        else if (a == R.id.l52) checkPoint(5,2);
        else if (a == R.id.l53) checkPoint(5,3);
        else if (a == R.id.l54) checkPoint(5,4);
        else checkPoint(5,5);

    }*/


    public void Click(View view) {
        LinearLayout clickedView = (LinearLayout) view;
        int[] coordinates = viewMap.get(clickedView.getId()).getDrawableState();
        if (coordinates != null) {
            int j = coordinates[0];
            int i = coordinates[1];
            checkPoint(j, i);
        }
    }

    public void checkPoint (int j, int i) {
        if (simpleArray[j][i]!=0) checkWay(j,i);
    }

    public void checkWay(int j, int i) {
        checkPointUp(j, i);
        checkPointLeft(j, i);
        checkPointDown(j, i);
        checkPointRight(j, i);
    }

    public void checkPointUp(int j, int i) {
        if (simpleArray[j-1][i]==0) {
            simpleArray[j-1][i] = simpleArray[j][i];
            simpleArray[j][i] = 0;
            setColorApp();
        }
    }

    public void checkPointLeft (int j, int i) {
        if (simpleArray[j][i-1]==0) {
            simpleArray[j][i-1] = simpleArray[j][i];
            simpleArray[j][i] = 0;
            setColorApp();
        }
    }

    public void checkPointDown(int j, int i) {
        if (simpleArray[j+1][i]==0) {
            simpleArray[j+1][i] = simpleArray[j][i];
            simpleArray[j][i] = 0;
            setColorApp();
        }
    }

    public void checkPointRight (int j, int i) {
        if (simpleArray[j][i+1]==0) {
            simpleArray[j][i+1] = simpleArray[j][i];
            simpleArray[j][i] = 0;
            setColorApp();
        }
    }

    public void setColorInArray () {
        int a = 0;
        for (int j = 1; j < 6; j++) {
            simpleArray[j][1] = array[a];
            a++;
            simpleArray[j][2] = array[a];
            a++;
            simpleArray[j][3] = array[a];
            a++;
            simpleArray[j][4] = array[a];
            a++;
            simpleArray[j][5] = array[a];
            a++;
        }
    }

    public void setColorApp () {
        for (int j = 1; j < 6; j++) {
            for (int i = 1; i < 6; i++) {
                setPoint(getViewOfPoint(j,i), simpleArray[j][i]);
            }
        }
    }

    public void setPoint (LinearLayout l, int a) {
        switch (a) {
            case 0: l.setBackgroundResource(R.drawable.x0);
                break;
            case 1: l.setBackgroundResource(R.drawable.x1);
                break;
            case 2: l.setBackgroundResource(R.drawable.x2);
                break;
            case 3: l.setBackgroundResource(R.drawable.x3);
                break;
            case 4: l.setBackgroundResource(R.drawable.x4);
                break;
            case 5: l.setBackgroundResource(R.drawable.x5);
                break;
        }
    }

    /*public void checkHorizontal () {
        int a = 6;
        for (int j = 1; j < 6; j++) {
            for (int i = 1; i < 6; i++) {
                if(i==1) a=simpleArray[j][i];
                if(simpleArray[j][i]!=a) break;
            }
        }
    }*/

    public LinearLayout getViewOfPoint(int j, int i) {
        int a = j*10 + i;
        if (a==11) return l11;
        else if (a==12) return l12;
        else if (a==13) return l13;
        else if (a==14) return l14;
        else if (a==15) return l15;
        else if (a==21) return l21;
        else if (a==22) return l22;
        else if (a==23) return l23;
        else if (a==24) return l24;
        else if (a==25) return l25;
        else if (a==31) return l31;
        else if (a==32) return l32;
        else if (a==33) return l33;
        else if (a==34) return l34;
        else if (a==35) return l35;
        else if (a==41) return l41;
        else if (a==42) return l42;
        else if (a==43) return l43;
        else if (a==44) return l44;
        else if (a==45) return l45;
        else if (a==51) return l51;
        else if (a==52) return l52;
        else if (a==53) return l53;
        else if (a==54) return l54;
        else return l55;
    }

    private void findView() {
        l11 = findViewById(R.id.l11);
        l12 = findViewById(R.id.l12);
        l13 = findViewById(R.id.l13);
        l14 = findViewById(R.id.l14);
        l15 = findViewById(R.id.l15);
        l21 = findViewById(R.id.l21);
        l22 = findViewById(R.id.l22);
        l23 = findViewById(R.id.l23);
        l24 = findViewById(R.id.l24);
        l25 = findViewById(R.id.l25);
        l31 = findViewById(R.id.l31);
        l32 = findViewById(R.id.l32);
        l33 = findViewById(R.id.l33);
        l34 = findViewById(R.id.l34);
        l35 = findViewById(R.id.l35);
        l41 = findViewById(R.id.l41);
        l42 = findViewById(R.id.l42);
        l43 = findViewById(R.id.l43);
        l44 = findViewById(R.id.l44);
        l45 = findViewById(R.id.l45);
        l51 = findViewById(R.id.l51);
        l52 = findViewById(R.id.l52);
        l53 = findViewById(R.id.l53);
        l54 = findViewById(R.id.l54);
        l55 = findViewById(R.id.l55);
    }

    public void shuffleArray () {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
    }
}