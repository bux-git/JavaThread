package com.dqr.www.javathread.test2;

import android.util.Log;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-22 17:39
 */

public class MultiPrint implements Runnable {
    private static final String TAG = "MultiPrint";
    private int count = 10;
    private String printStr;
    private String name;
    private Object prev;
    private Object self;

    public MultiPrint(String printStr, String name, Object prev, Object self) {
        this.printStr = printStr;
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        while (count > 0) {
            Log.d(TAG, name+"循环最外层");
            synchronized (prev) {
                Log.d(TAG, name+"持有上一个 ");
                synchronized (self) {
                    Log.d(TAG, name + ":" + printStr);
                    count--;
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
