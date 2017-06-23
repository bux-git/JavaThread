package com.dqr.www.javathread.test1;

import android.util.Log;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-22 16:42
 */

public class Target {
    private static final String TAG = "Target";
    private int count;

    public synchronized void increase(){
        if(count==2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        Log.d(TAG,Thread.currentThread().getName()+":"+count);
        notify();
    }

    public synchronized void decrease(){
        if(count==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Log.d(TAG,Thread.currentThread().getName()+":"+count);
        notify();
    }
}
