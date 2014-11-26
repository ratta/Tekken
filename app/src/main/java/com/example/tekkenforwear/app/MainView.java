package com.example.tekkenforwear.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by fukuta0614 on 11/26/14.
 */
public class MainView extends SurfaceView implements SurfaceHolder.Callback {
    Context context;
    float mx, my;
    float dx, dy;
    float action;
    int counter;
    boolean canRun = true;
    private com.example.tekkenforwear.app.MainViewThread back_thread;


    /////constructor
    public MainView(Context context) {
        super(context);
        getHolder().addCallback(this);
        back_thread = new com.example.tekkenforwear.app.MainViewThread(getHolder(), this);
        //mHandler.sendEmptyMessageDelayed(0, 10);

    }

    public void onDraw(Canvas canvas) {

        ////background
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.tekkenbackground);
        bm = Bitmap.createScaledBitmap(bm, getWidth(), getHeight(), true);
        ////character 'muzi'&'jayg'
        Bitmap muzi = BitmapFactory.decodeResource(getResources(), R.drawable.muzi);
        Bitmap jayg = BitmapFactory.decodeResource(getResources(), R.drawable.jayg);
        muzi = Bitmap.createScaledBitmap(muzi, getWidth() / 5, getHeight() / 4, true);
        jayg = Bitmap.createScaledBitmap(jayg, getWidth() / 5, getHeight() / 4, true);
        ////energy bar for muzi & jayg
        Bitmap energy_muzi = BitmapFactory.decodeResource(getResources(), R.drawable.energy_l);
        Bitmap energy_jayg = BitmapFactory.decodeResource(getResources(), R.drawable.energy_r);
        energy_muzi = Bitmap.createScaledBitmap(energy_muzi, getWidth() / 2, getHeight() / 5, true);
        energy_jayg = Bitmap.createScaledBitmap(energy_jayg, getWidth() / 2, getHeight() / 5, true);
        ////punch
        Bitmap punch_toright = BitmapFactory.decodeResource(getResources(),R.drawable.punch_toright);
        punch_toright = Bitmap.createScaledBitmap(punch_toright, getWidth()/6, getHeight()/6, true);
        ////hook
        Bitmap hook_toright = BitmapFactory.decodeResource(getResources(), R.drawable.hook_toright);
        hook_toright = Bitmap.createScaledBitmap(hook_toright, getWidth()/6, getHeight()/6, true);
        ////upper
        Bitmap upper_toright = BitmapFactory.decodeResource(getResources(),R.drawable.upper_toright);
        upper_toright = Bitmap.createScaledBitmap(upper_toright, getWidth()/6, getHeight()/6, true);


        ///finish background drawing & muzi, jayg

        //define variables used in onDraw
        mx += dx;
        my += dy;
        int bw = bm.getWidth();  ///background width
        int bh = bm.getHeight();
        int mw = muzi.getWidth(); ///muzi's width
        int mh = muzi.getHeight();
        int jw = jayg.getWidth(); ///jayg's width
        int jh = jayg.getHeight();
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(bm, 0, 0, null);
        //canvas.drawBitmap(muzi, x -muzi.getWidth(), y - muzi.getHeight(), null);
        canvas.drawBitmap(muzi, 1200, 500, null);
        canvas.drawBitmap(jayg, 300, 500, null);
        canvas.drawBitmap(energy_muzi, 0, 0, null);
        canvas.drawBitmap(energy_jayg, 965, 0, null);

        if (action == 1) {
            canvas.drawBitmap(upper_toright,300,500,null);
        }else if(action == 2) {
            canvas.drawBitmap(hook_toright,300,500,null);
        }else if (action == 3) {
            canvas.drawBitmap(punch_toright,300,500,null);
        }

    }
/*
        Handler mHandler = new Handler() {
            public void handleMessage(Message msg) {
                invalidate();
                mHandler.sendEmptyMessageDelayed(0, 10);
            }
        };
*/

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        back_thread.setRunning(true);
        back_thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        back_thread.setRunning(false);
        while (retry) {
            try {
                back_thread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }
    public void punch(){
        action = 1;
    }
    public void upper(){
        action = 2;
    }
    public void hook(){
        action = 3;
    }


}



