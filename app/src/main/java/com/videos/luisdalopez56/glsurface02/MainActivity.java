package com.videos.luisdalopez56.glsurface02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    SurfaceView surfaceView;
    RelativeLayout rl;
    private Button dr, iz, ar, ab, at, de;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = findViewById(R.id.surfaceView);
        final GLSurface glSurface = new GLSurface(this);
        rl.addView(glSurface);

        dr = findViewById(R.id.btn_dr);
        dr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                glSurface.Mueve(1);
            }
        });
        iz = findViewById(R.id.btn_iz);
        iz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                glSurface.Mueve(2);
            }
        });
        ar = findViewById(R.id.btn_ar);
        ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                glSurface.Mueve(3);
            }
        });
        ab = findViewById(R.id.btn_ab);
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                glSurface.Mueve(4);
            }
        });
        at = findViewById(R.id.btn_at);
        at.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                glSurface.Mueve(5);
            }
        });
        de = findViewById(R.id.btn_de);
        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                glSurface.Mueve(6);
            }
        });
    }
}
