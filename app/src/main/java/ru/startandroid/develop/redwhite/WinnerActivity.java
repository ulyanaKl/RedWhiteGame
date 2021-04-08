package ru.startandroid.develop.redwhite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WinnerActivity extends AppCompatActivity {
    TextView myScores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        Intent intent = getIntent();
        int scores = intent.getIntExtra("scores", 0);
        myScores = (TextView) findViewById(R.id.myScores);
        String scoresString = Integer.toString(scores);
        myScores.setText(scoresString);
    }

}
