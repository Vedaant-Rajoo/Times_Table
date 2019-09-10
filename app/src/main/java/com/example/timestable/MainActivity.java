package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekBar);
        final ListView myListView = findViewById(R.id.myListView);

        seekBar.setMax(20);
        seekBar.setProgress(1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;
                if (progress < min){
                    timesTableNumber = min;
                    seekBar.setProgress(min);
                }
                else{
                    timesTableNumber = progress;
                }
                Log.i("Seekbar value",Integer.toString(timesTableNumber));
                Toast.makeText(getApplicationContext(),Integer.toString(timesTableNumber),Toast.LENGTH_SHORT);

                ArrayList<String> timesTableContent = new ArrayList();

                for (int j = 1;j<=20;j++ ){
                    timesTableContent.add(Integer.toString(j*timesTableNumber));
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,timesTableContent);
                myListView.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
