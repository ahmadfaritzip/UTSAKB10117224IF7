package com.example.utsakb10117224if7.ui.splash;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.utsakb10117224if7.MainActivity;
import com.example.utsakb10117224if7.R;
import com.example.utsakb10117224if7.model.db.DbOpenHelper;

public class SplashScreenActivity extends AppCompatActivity {
    DbOpenHelper myDb;
    Animation topAnim, bottomAnim;
    TextView tvSplash1, tvSplash2;
    ImageView image;
    Typeface rLight, rSemiBold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//    Tanggal Pengerjaan : 13 Mei 2020
//    Nim : 10117224
//    Nama : Ahmad Faritz Ied putra
//    Kelas : IF - 7

        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        myDb = new DbOpenHelper(this);

        //Animasi
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        image = findViewById(R.id.iv_splash);

        image.setAnimation(topAnim);

        Thread thread = new Thread(){
            public void run() {
                try {
                    sleep(2500); //detik
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intent);

                    finish();
                }
            }
        };
        thread.start();
    }
}
