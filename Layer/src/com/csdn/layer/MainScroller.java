package com.csdn.layer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.csdn.layer.view.LayerLine;
import com.csdn.layer.view.SmartScrollView;

import java.util.List;

public class MainScroller extends Activity implements View.OnClickListener {


    private TextView layer;
    private SmartScrollView scoler;
    private TextView button1;
    private TextView button2;
    List<View> all;
    private LayerLine lisgeiwe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_m);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onResume() {
        super.onResume();


        layer.getLocationOnScreen(pone);
        Log.i("eeeeeeee",pone[0]+""+pone[1]+"---"+layer.getY());

    }

    private int[] pone = new int[2];

    private void initView() {
        layer = (TextView) findViewById(R.id.layer);


        scoler = (SmartScrollView) findViewById(R.id.scoler);


        scoler.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

            }
        });

        button1 = (TextView) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (TextView) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        lisgeiwe = (LayerLine) findViewById(R.id.lisgeiwe);
        lisgeiwe.setOnClickListener(this);
        lisgeiwe.setLayerY(150,R.id.layer);
    }


    @Override
    public void onClick(View v) {


    }
}
