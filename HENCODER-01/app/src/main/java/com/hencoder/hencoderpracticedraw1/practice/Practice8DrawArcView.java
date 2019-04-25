package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.annotation.PluralsRes;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

public class Practice8DrawArcView extends View {

    private Paint paint = new Paint();
    private RectF rectF = new RectF(200, 200, 600, 600);

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        paint.setColor(getResources().getColor(R.color.black));
        paint.setAntiAlias(true);

        canvas.drawArc(rectF, 0, -100, true, paint);

        canvas.drawArc(rectF, 20, 145, false, paint);

        paint.setStyle(Paint.Style.STROKE);

        canvas.drawArc(rectF, 175, 45, false, paint);


    }
}
