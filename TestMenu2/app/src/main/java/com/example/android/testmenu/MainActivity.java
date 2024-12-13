package com.example.android.testmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;

    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;

    final int MENU_SIZE_22 = 4;
    final int MENU_SIZE_26 = 5;
    final int MENU_SIZE_30 = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);

        registerForContextMenu(text1);
        registerForContextMenu(text2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()) {
            case R.id.text1:
                menu.add(0, MENU_COLOR_RED, 0, "RED");
                menu.add(0, MENU_COLOR_GREEN, 0, "GREEN");
                menu.add(0, MENU_COLOR_BLUE, 0, "BLUE");
                break;
            case R.id.text2:
                menu.add(0, MENU_SIZE_22, 0, "22");
                menu.add(0, MENU_SIZE_26, 0, "26");
                menu.add(0, MENU_SIZE_30, 0, "30");
                break;
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case MENU_COLOR_RED:
                text1.setTextColor(Color.RED);
                text1.setText("Выбран красный цвет");
                break;
            case MENU_COLOR_GREEN:
                text1.setTextColor(Color.GREEN);
                text1.setText("Выбран зеленый цвет");
                break;
            case MENU_COLOR_BLUE:
                text1.setTextColor(Color.BLUE);
                text1.setText("Выбран синий цвет");
                break;
            case MENU_SIZE_22:
                text2.setTextSize(22);
                text2.setText("Размер текста 22");
                break;
            case MENU_SIZE_26:
                text2.setTextSize(26);
                text2.setText("Размер текста 26");
                break;
            case MENU_SIZE_30:
                text2.setTextSize(30);
                text2.setText("Размер текста 30");
                break;
        }

        return super.onContextItemSelected(item);
    }
}