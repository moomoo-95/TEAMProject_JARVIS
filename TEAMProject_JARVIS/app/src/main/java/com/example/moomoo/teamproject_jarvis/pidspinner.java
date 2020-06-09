package com.example.moomoo.teamproject_jarvis;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

public class pidspinner extends View {
    Bitmap b, mb;
    Matrix m = new Matrix();
    public pidspinner(Context context){
        super(context);
        setBackgroundColor(0x00000000);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.redspin);
        mb = b;
    }
    public pidspinner(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        setBackgroundColor(0x00000000);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.redspin);
        mb = b;
    }
    public pidspinner(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        setBackgroundColor(0x00000000);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.redspin);
        mb = b;
    }
    protected void onDraw(Canvas canvas){
        if(fan_app.spining) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            m.preRotate(90);
        }
            if(fan_app.spinmode == 1){
                b = BitmapFactory.decodeResource(getResources(), R.drawable.redspin);
                fan_app.spinmode = 0;
            }
            else if(fan_app.spinmode == 2){
                b = BitmapFactory.decodeResource(getResources(), R.drawable.whitespin);
                fan_app.spinmode = 0;
            }
            else if(fan_app.spinmode == 3){
                b = BitmapFactory.decodeResource(getResources(), R.drawable.goldspin);
                fan_app.spinmode = 0;
            }
            mb = Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), m, false);
            Bitmap sb = Bitmap.createScaledBitmap(mb, super.getWidth(), super.getHeight(), false);
            canvas.drawBitmap(sb, 0, 0, null);
            invalidate();

    }
}