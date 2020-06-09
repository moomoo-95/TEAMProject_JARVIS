package com.example.moomoo.teamproject_jarvis;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class touchOnStart extends View {
    int x = 150, y = 180, z = 0;
    public touchOnStart(Context context){
        super(context);
    }
    public touchOnStart(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }
    public touchOnStart(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
    }
    protected void onDraw(Canvas canvas){
        Bitmap man = BitmapFactory.decodeResource(getResources(), R.drawable.ironman_fly);
        Bitmap ironman = Bitmap.createScaledBitmap(man,man.getWidth()/3, man.getHeight()/3, false);
        if(z == 0){
            if(y <= 230){ y++; }
            else{ z = 1; }
        }
        else{
            if(y >= 180){ y--; }
            else{ z = 0; }
        }
        canvas.drawBitmap( ironman, x, y, null);
        invalidate();
    }
}