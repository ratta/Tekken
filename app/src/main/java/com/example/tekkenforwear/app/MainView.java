package com.example.tekkenforwear.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;
import java.util.Random;

/**
 * Created by ratta on 11/26/14.
 */

public class MainView extends SurfaceView implements SurfaceHolder.Callback {

    int action_my = 0;
    int action_opponent = 0;
    int counter_r,counter_l = 0;
    boolean canRun = true;
    private final String TAG = "handheld";
    private com.example.tekkenforwear.app.MainViewThread back_thread;

    /////constructor
    public MainView(Context context) {
        super(context);
        getHolder().addCallback(this);
        back_thread = new com.example.tekkenforwear.app.MainViewThread(getHolder(), this);
        mHandler.sendEmptyMessageDelayed(0, 10);
    }

    public void onDraw(Canvas canvas){
        ///////////////////////background////////////////////
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.tekkenbackground);
        bm = Bitmap.createScaledBitmap(bm, getWidth(), getHeight(), true);
        //////////////////////character////////////////////////
        Bitmap paul_normal = BitmapFactory.decodeResource(getResources(), R.drawable.normal_paul);
        Bitmap jayg = BitmapFactory.decodeResource(getResources(), R.drawable.jayg);
        paul_normal = Bitmap.createScaledBitmap(paul_normal, getWidth() / 5, getHeight() / 4, true);
        jayg = Bitmap.createScaledBitmap(jayg, getWidth() / 5, getHeight() / 4, true);
        //////////////////////energy bar///////////////////////////

        Bitmap energy_muzi8 = BitmapFactory.decodeResource(getResources(), R.drawable.energy_l_8_8);
        Bitmap energy_muzi7 = BitmapFactory.decodeResource(getResources(), R.drawable.energy_l_8_7);
        Bitmap energy_muzi6 = BitmapFactory.decodeResource(getResources(), R.drawable.energy_l_8_6);
        Bitmap energy_muzi5 = BitmapFactory.decodeResource(getResources(), R.drawable.energy_l_8_5);
        Bitmap energy_muzi4 = BitmapFactory.decodeResource(getResources(), R.drawable.energy_l_8_4);
        Bitmap energy_muzi3 = BitmapFactory.decodeResource(getResources(), R.drawable.energy_l_8_3);
        Bitmap energy_muzi2 = BitmapFactory.decodeResource(getResources(), R.drawable.energy_l_8_2);
        Bitmap energy_muzi1 = BitmapFactory.decodeResource(getResources(), R.drawable.energy_l_8_1);
        energy_muzi8 = Bitmap.createScaledBitmap(energy_muzi8, getWidth() / 2, getHeight() / 5, true);
        energy_muzi7 = Bitmap.createScaledBitmap(energy_muzi7, getWidth() / 2, getHeight() / 5, true);
        energy_muzi6 = Bitmap.createScaledBitmap(energy_muzi6, getWidth() / 2, getHeight() / 5, true);
        energy_muzi5 = Bitmap.createScaledBitmap(energy_muzi5, getWidth() / 2, getHeight() / 5, true);
        energy_muzi4 = Bitmap.createScaledBitmap(energy_muzi4, getWidth() / 2, getHeight() / 5, true);
        energy_muzi3 = Bitmap.createScaledBitmap(energy_muzi3, getWidth() / 2, getHeight() / 5, true);
        energy_muzi2 = Bitmap.createScaledBitmap(energy_muzi2, getWidth() / 2, getHeight() / 5, true);
        energy_muzi1 = Bitmap.createScaledBitmap(energy_muzi1, getWidth() / 2, getHeight() / 5, true);

        Bitmap energy_jayg8 = BitmapFactory.decodeResource(getResources(), R.drawable.energy_r_8_8);
        Bitmap energy_jayg7 = BitmapFactory.decodeResource(getResources(), R.drawable.energy_r_8_7);
        Bitmap energy_jayg6 = BitmapFactory.decodeResource(getResources(), R.drawable.energy_r_8_6);
        Bitmap energy_jayg5 = BitmapFactory.decodeResource(getResources(), R.drawable.energy_r_8_5);
        Bitmap energy_jayg4 = BitmapFactory.decodeResource(getResources(), R.drawable.energy_r_8_4);
        Bitmap energy_jayg3 = BitmapFactory.decodeResource(getResources(), R.drawable.energy_r_8_3);
        Bitmap energy_jayg2 = BitmapFactory.decodeResource(getResources(), R.drawable.energy_r_8_2);
        Bitmap energy_jayg1 = BitmapFactory.decodeResource(getResources(), R.drawable.energy_r_8_1);
        energy_jayg8 = Bitmap.createScaledBitmap(energy_jayg8, getWidth() / 2, getHeight() / 5, true);
        energy_jayg7 = Bitmap.createScaledBitmap(energy_jayg7, getWidth() / 2, getHeight() / 5, true);
        energy_jayg6 = Bitmap.createScaledBitmap(energy_jayg6, getWidth() / 2, getHeight() / 5, true);
        energy_jayg5 = Bitmap.createScaledBitmap(energy_jayg5, getWidth() / 2, getHeight() / 5, true);
        energy_jayg4 = Bitmap.createScaledBitmap(energy_jayg4, getWidth() / 2, getHeight() / 5, true);
        energy_jayg3 = Bitmap.createScaledBitmap(energy_jayg3, getWidth() / 2, getHeight() / 5, true);
        energy_jayg2 = Bitmap.createScaledBitmap(energy_jayg2, getWidth() / 2, getHeight() / 5, true);
        energy_jayg1 = Bitmap.createScaledBitmap(energy_jayg1, getWidth() / 2, getHeight() / 5, true);

        ////////////////////////////////gameover////////////////////
        Bitmap gameover = BitmapFactory.decodeResource(getResources(), R.drawable.gameover);
        gameover = Bitmap.createScaledBitmap(gameover, getWidth() , getHeight() / 2, true);

        ////////////////////////////////punch///////////////////
        Bitmap paul_punch = BitmapFactory.decodeResource(getResources(),R.drawable.punch);
        paul_punch = Bitmap.createScaledBitmap(paul_punch, getWidth()/5, getHeight()/4, true);
        ////////////////////////////////hook////////////////////
        Bitmap paul_hook = BitmapFactory.decodeResource(getResources(), R.drawable.hook);
        paul_hook = Bitmap.createScaledBitmap(paul_hook, getWidth()/5, getHeight()/4, true);
        ////////////////////////////////upper/////////////////
        Bitmap paul_upper = BitmapFactory.decodeResource(getResources(),R.drawable.upper);
        paul_upper = Bitmap.createScaledBitmap(paul_upper, getWidth()/5, getHeight()/4, true);
/*
        int bw = bm.getWidth();  ///background width
        int bh = bm.getHeight();
        int mw = muzi.getWidth(); ///muzi's width
        int mh = muzi.getHeight();
        int jw = jayg.getWidth(); ///jayg's width
        int jh = jayg.getHeight();
*/
////////////////////////////////////////////draw pictures /////////////////////////////////////////////////
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(bm, 0, 0, null);
        canvas.drawBitmap(jayg, 1200, 500, null);
        canvas.drawBitmap(paul_normal, 300, 500, null);

        /////////energybar method////////

        switch(counter_r) {
            case 0:
                canvas.drawBitmap(energy_jayg8, 965, 0, null);
                break;
            case 1:
                canvas.drawBitmap(energy_jayg7, 965, 0, null);
                break;
            case 2:
                canvas.drawBitmap(energy_jayg6, 965, 0, null);
                break;
            case 3:
                canvas.drawBitmap(energy_jayg5, 965, 0, null);
                break;
            case 4:
                canvas.drawBitmap(energy_jayg4, 965, 0, null);
                break;
            case 5:
                canvas.drawBitmap(energy_jayg3, 965, 0, null);
                break;
            case 6:
                canvas.drawBitmap(energy_jayg2, 965, 0, null);
                break;
            case 7:
                canvas.drawBitmap(energy_jayg1, 965, 0, null);
                break;
        }

        switch(counter_l) {
            case 0:
                canvas.drawBitmap(energy_muzi8, 0, 0, null);
                break;
            case 1:
                canvas.drawBitmap(energy_muzi7, 0, 0, null);
                Log.d(TAG, "damage");
                break;
            case 2:
                canvas.drawBitmap(energy_muzi6, 0, 0, null);
                break;
            case 3:
                canvas.drawBitmap(energy_muzi5, 0, 0, null);
                break;
            case 4:
                canvas.drawBitmap(energy_muzi4, 0, 0, null);
                break;
            case 5:
                canvas.drawBitmap(energy_muzi3, 0, 0, null);
                break;
            case 6:
                canvas.drawBitmap(energy_muzi2, 0, 0, null);
                break;
            case 7:
                canvas.drawBitmap(energy_muzi1, 0, 0, null);
                break;
        }

        if ((counter_l | counter_r )>8){
            canvas.drawBitmap(gameover, 0, 200, null);

        }

        /////////////////////combat method////////////////////
        /////combat me//////
        if (action_my== 1) {
            canvas.drawBitmap(paul_punch,300,500,null);
        }else if(action_my == 2) {
            canvas.drawBitmap(paul_hook,300,500,null);
        }else if (action_my == 3) {
            canvas.drawBitmap(paul_upper,300,500,null);
        }
        /////combat opponent
/*
        if (action_opponent == 1) {
            //canvas.drawBitmap(upper_toright,300,500,null);
            counter_l++;
        }else if(action_opponent == 2) {
            //canvas.drawBitmap(hook_toright,300,500,null);
            counter_l++;
        }else if (action_opponent == 3) {
            //canvas.drawBitmap(punch_toright,300,500,null);
            counter_l++;
        }
*/
    }


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
    /////////function for opponent's random attack//////////
    public void main(String[] args){
            Random generator = new Random();
            int num ;
            num= generator.nextInt(3) + 1;////random number from 1-3
            action_opponent = num;

            if(action_opponent == 1){
                counter_l++;
            }else if(action_opponent == 2){
                counter_l++;
            }else if(action_opponent == 3){
                counter_l++;
            }
        }


    public void punch(){
        action_my = 1;
        counter_r++;
        Log.d(TAG, "punch");
    }
    public void upper(){
        action_my = 3;
        counter_r++;
        Log.d(TAG, "upper");
    }
    public void hook(){
        action_my = 2;
        counter_r++;
        Log.d(TAG, "hook");

    }
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            invalidate();
            mHandler.sendEmptyMessageDelayed(0, 10);
        }
    };


}



