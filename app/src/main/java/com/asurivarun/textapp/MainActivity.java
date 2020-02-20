package com.asurivarun.textapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    TextView displayText;
    String[] words;
    TimerTask timerTask;
    boolean bool = false;
    int n = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.clickButton);
        displayText = findViewById(R.id.textBox);
        Resources res = getResources();
        words = res.getStringArray(R.array.array1);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bool) {
                    bool = true;
                    Timer timer = new Timer(true);
                    timer.scheduleAtFixedRate(timerTask, 0, 100);
                }
            }
        });
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        displayText.setText(words[n++ % words.length]);
                    }
                });
            }
        };
    }
}
