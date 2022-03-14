package com.example.zoho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {

    private static int timer = 4000;

    ImageView imageView;
    TextView textView1,textView2;
    Animation upperanimation,buttomanimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);

        imageView = findViewById(R.id.logohome);
        textView1 = findViewById(R.id.appname);
        textView2 = findViewById(R.id.subappname);

        upperanimation = AnimationUtils.loadAnimation(this,R.anim.upper_animation);
        buttomanimation = AnimationUtils.loadAnimation(this,R.anim.buttom_animation);

        imageView.setAnimation(upperanimation);
        textView1.setAnimation(buttomanimation);
        textView2.setAnimation(buttomanimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashscreen.this,login.class);
                startActivity(intent);
                finish();
            }
        },timer);



    }
}