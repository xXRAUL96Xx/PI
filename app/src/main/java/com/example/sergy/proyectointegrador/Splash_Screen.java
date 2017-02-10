package com.example.sergy.proyectointegrador;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sergy.proyectointegrador.MainActivity;
import com.example.sergy.proyectointegrador.R;

import static java.lang.Thread.sleep;


public class Splash_Screen extends Activity {

    TextView iv2;

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    /**
     * Called when the activity is first created.
     */
    Thread splashTread;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash2);
        StartAnimations();
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
       /* LinearLayout l = (LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);*/

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.splash);
        iv2 = (TextView) findViewById(R.id.splash2);
        iv.clearAnimation();
        iv.startAnimation(anim);
        iv2.clearAnimation();
        iv2.startAnimation(anim2);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 4500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(Splash_Screen.this,
                            MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    Splash_Screen.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    Splash_Screen.this.finish();
                }

            }


        };
        splashTread.start();

    }


}