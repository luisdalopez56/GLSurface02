package com.videos.luisdalopez56.glsurface02;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.view.MotionEvent;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GLSurface extends GLSurfaceView {
    Renderizado miRender;
    private float previoX;
    private float previoY;
    private final float FACTOR_ESCALA = 180.0f / 320.0f;

    public GLSurface(Context context) {
        super(context);
        miRender = new Renderizado();
        setRenderer(miRender);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float actualX = event.getX();
        float actualY = event.getY();
        float deltaX, deltaY;

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
            deltaX = actualX - previoX;
            deltaY = actualY - previoY;
            Renderizado.anguloX += deltaY * FACTOR_ESCALA;
            Renderizado.anguloY += deltaX * FACTOR_ESCALA;
        }

        previoX = actualX;
        previoY = actualY;
        return true;
    }

    public void Mueve(int valor){

        switch (valor){
            case 1:
                Renderizado.veloY += 0.1f;
                break;
            case 2:
                Renderizado.veloY -= 0.1f;
                break;
            case 3:
                Renderizado.veloX -= 0.1f;
                break;
            case 4:
                Renderizado.veloX += 0.1f;
                break;
            case 5:
                Renderizado.veloZ -= 0.2f;
                break;
            case 6:
                Renderizado.veloZ += 0.2f;
                break;

        }

    }

}

class Renderizado implements GLSurfaceView.Renderer {

    private Cubo cubo;
    public static float veloX = 0.0f;
    public static float veloY = 0.0f;
    public static float veloZ = -8.0f;
    public static float anguloX = 0.0f;
    public static float anguloY = 0.0f;

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

        cubo = new Cubo();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glClearDepthf(2.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glDisable(GL10.GL_DITHER);



    }



    @Override
    public void onSurfaceChanged(GL10 gl, int ancho, int alto) {
        if (alto == 0) alto = 1;
        float aspecto = (float) ancho / alto;
        gl.glViewport(0, 0, ancho, alto);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluPerspective(gl, 45, aspecto, 0.1f, 100.f);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, veloZ);
        gl.glRotatef(anguloX, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(anguloY, 0.0f, 1.0f, 0.0f);
        //gl.glTranslatef(0.0f, 0.0f, -8.0f);
        cubo.draw(gl);

        anguloX += veloX;
        anguloY += veloY;

    }



}

