package com.csdn.layer.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.csdn.layer.R;

public class LayerLine extends LinearLayout {
    private int  location;
    private int[] pone = new int[2];
    public LayerLine(Context context) {
        super(context);
        init();
    }

    public LayerLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LayerLine(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public LayerLine(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }



    public void init(){
        this.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(params);


    }


    public void remove(int id){
        View view=findViewById(id);
        for (int i = 0; i < this.getChildCount(); i++) {
            View viewChild = this.getChildAt(i);
            System.out.print(viewChild.getId() + "--------" + R.id.layer);
            if(viewChild.getId()==R.id.layer){
                location=i;
                this.removeView(view);
            }
        }
    }

    public void addView(int id){
        View view=findViewById(id);
        this.addView(view,location);
    }


    public void setLayerY(final  int Y,final int id){


        final View view=findViewById(id);

view.getLocationOnScreen(pone);
        Log.d("eeeeeeee",pone[1]+"");

        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                System.out.print(event.getY());


             if(view.getY()==0){
                 Toast.makeText(getContext(),"1111111111111",Toast.LENGTH_LONG).show();
             }


                return true;
            }
        });

    }

}
