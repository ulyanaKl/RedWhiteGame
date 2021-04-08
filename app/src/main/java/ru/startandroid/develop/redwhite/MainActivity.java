package ru.startandroid.develop.redwhite;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentLeftCallBack {
    TextView numberText;
    int counter = 0;
    boolean isLoserActivityCalled;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        numberText = findViewById(R.id.numberText);
        closeActivityAfterSomeTime();

    }

    @Override
    public void onFragmentClicked() {
        FragmentLeft fragmentLeft = (FragmentLeft) getSupportFragmentManager().findFragmentById(R.id.left_fragment);
        assert fragmentLeft != null;
        fragmentLeft.changeMyColor();
        FragmentRight fragmentRight = (FragmentRight) getSupportFragmentManager().findFragmentById(R.id.right_fragment);
        assert fragmentRight != null;
        fragmentRight.changeMyColor();
        counter++;
        numberText.setText(Integer.toString(counter));
    }

    @Override
    public void onWhiteFragmentClick() {
        counter = 0;
        numberText.setText(Integer.toString(counter));
        onStartLossActivity();
    }

    public void onStartLossActivity() {
        isLoserActivityCalled = true;
        Intent intent = new Intent(this, LossActivity.class);
        startActivity(intent);
    }

    public void startWinnerActivity() {
        Intent intent = new Intent(this, WinnerActivity.class);
        intent.putExtra("scores", counter);
        startActivity(intent);
    }

    public void closeActivityAfterSomeTime() {
        int finishTime = 5;
        handler = new Handler();

        handler.postDelayed(() -> {


            if (!isLoserActivityCalled) {
                startWinnerActivity();
                MainActivity.this.finish();
            }
        }, finishTime * 1000);

    }

    @Override
    protected void onStart() {
        super.onStart();
        isLoserActivityCalled = false;
        closeActivityAfterSomeTime();
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacksAndMessages(null);
    }

}

