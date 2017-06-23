package com.dqr.www.javathread.test1;

import android.util.Log;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-22 17:03
 */

public class Decrease extends Thread {
    private static final String TAG = "Decrease";
    private  Target t;

    public Decrease(Target t) {
        this.t = t;
    }

    @Override
    public void run() {
        super.run();
        for(int i=0;i<3;i++){
            Log.d(TAG,Thread.currentThread().getName()+"    run: "+i);
            try {
                Thread.sleep((long) (Math.random()*500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.decrease();
        }
    }
}
