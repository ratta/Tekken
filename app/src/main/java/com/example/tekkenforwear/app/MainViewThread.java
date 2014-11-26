package com.example.tekkenforwear.app;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by fukuta0614 on 11/26/14.
 */
public class MainViewThread extends Thread{

    public SurfaceHolder back_holder;
    private MainView back_photo;
    private boolean back_run = false;

    public MainViewThread(SurfaceHolder surfaceHolder, MainView backgroundphoto){
        back_holder = surfaceHolder;
        back_photo = backgroundphoto;
    }

    public void setRunning(boolean run){
        back_run = run;

    }
    public void run(){
        Canvas _canvas;
        while(back_run){
            _canvas=null;
            try{
                _canvas = back_holder.lockCanvas(null);
                synchronized (back_holder){
                    back_photo.onDraw(_canvas);////////
                }
            }finally{
                if(_canvas != null)
                    back_holder.unlockCanvasAndPost(_canvas);
            }
        }

    }
}

