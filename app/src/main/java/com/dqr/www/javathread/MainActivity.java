package com.dqr.www.javathread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dqr.www.javathread.test1.Decrease;
import com.dqr.www.javathread.test1.Increase;
import com.dqr.www.javathread.test1.Target;
import com.dqr.www.javathread.test2.MultiPrint;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                Target t = new Target();
                Increase increase = new Increase(t);
                increase.setName("InCrease");
                Decrease decrease = new Decrease(t);
                decrease.setName("Decrease");

                increase.start();
                decrease.start();
                break;
            case R.id.btn_two:
                Object a=new Object();
                Object b = new Object();
                Object c = new Object();

                MultiPrint pa = new MultiPrint("A", "A",c,a);
                MultiPrint pb = new MultiPrint("B", "B",a,b);
                MultiPrint pc = new MultiPrint("C", "C",b,c);

                try {
                    new Thread(pa).start();
                    Thread.sleep(500);
                    new Thread(pb).start();
                    Thread.sleep(500);
                    new Thread(pc).start();
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }

    }


}
