package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.BuildConfig;
import com.hencoder.hencoderpracticedraw1.R;

public class Practice5DrawOvalView extends View {

    private Paint paint = new Paint();

    public Practice5DrawOvalView(Context context) {
        super(context);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawOval() 方法画椭圆
        paint.setColor(getResources().getColor(R.color.black));
        paint.setAntiAlias(true);

        if(Build.VERSION.SDK_INT >= 21){
            canvas.drawOval(300, 160, 800, 500, paint);
        }

    }
}
