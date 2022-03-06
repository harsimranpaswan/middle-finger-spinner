package com.workshop.spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView mf;
    private Random r= new Random();
    private boolean ro;
    private int i;
    private Button go;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mf = findViewById(R.id.mf);
        go = findViewById(R.id.go);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myme();
            }
        });
    }
    public void myme() {
        if (!ro) {
            int f = r.nextInt(2400);
            float w = mf.getWidth() / 2;
            float h = mf.getHeight() / 2;
            Animation rotate = new RotateAnimation(i, f, w, h);

            rotate.setDuration(2000);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    ro = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    ro = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            i = f;
            mf.startAnimation(rotate);
        }
    }
}