package com.csdn.layer.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class MagicUtil {
    private MagicUtil(){}
    private static  class  MagicUitlHolder {

        private final static MagicUtil instance=new MagicUtil();
    }

    public static MagicUtil getInatance(){
        return MagicUitlHolder.instance;
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public  int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public  int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     *
     * @param context  上下文
     * @return　 返回屏幕的宽高
     */
    public  int[] getSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        int height = dm.heightPixels;       // 屏幕高度（像素）
        float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = dm.densityDpi;     // 屏幕密度dpi（120 / 160 / 240）
        // 屏幕宽度算法:屏幕宽度（像素）/屏幕密度
        int screenWidth = (int) (width / density);  // 屏幕宽度(dp)
        int screenHeight = (int) (height / density);// 屏幕高度(dp)
        int[] size=new int[2];
        size[0]=screenWidth;
        size[1]=screenHeight;
        return  size;
    }

    public  Drawable getDrawable(Context context, int id){
        return    context.getResources().getDrawable(id);
    }



    public List<View>  getAllChildViews(View view){
        List<View> allChildren=new ArrayList<View>();
        if(view instanceof ViewGroup){
            ViewGroup viewGroup=(ViewGroup)view;
            for(int i=0;i<viewGroup.getChildCount();i++){
                View viewChild=viewGroup.getChildAt(i);
                allChildren.add(viewChild);
            }
            viewGroup.removeAllViews();
        }

        return allChildren;
    }


    public void addViews(View view,List<View> allChildren){
        if(view instanceof  ViewGroup){
            for(int i=0;i<allChildren.size();i++){
                ((ViewGroup) view).addView(allChildren.get(i));
            }
        }else {

        }
    }

}
