package edu.cs.birzeit.assignment1_driving_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tViewMain;
    private ImageView imgMain;
    private Animation bottom ,top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tViewMain = findViewById(R.id.tViewMain);
        imgMain = findViewById(R.id.imgMain);
        top = AnimationUtils.loadAnimation(this,R.anim.topanim);
        bottom = AnimationUtils.loadAnimation(this,R.anim.bootmanim);
        imgMain.setAnimation(top);
        tViewMain.setAnimation(bottom);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent view = new Intent( MainActivity.this,Login.class);
                startActivity(view);
                finish();
            }
        }, 7000);


    }


}