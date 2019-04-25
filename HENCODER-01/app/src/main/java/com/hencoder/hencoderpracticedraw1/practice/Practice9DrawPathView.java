package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

public class Practice9DrawPathView extends View {

    private Paint paint = new Paint();
    private Path path = new Path();
    private RectF rectF = new RectF(400, 350, 500, 450);
    private RectF rectF2 = new RectF(500, 350, 600, 450);

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        paint.setColor(getResources().getColor(R.color.black));
        paint.setAntiAlias(true);

        path.moveTo(500, 500);
        path.lineTo(400, 400);
        path.arcTo(rectF, -195, 210, false);
        path.arcTo(rectF2, -195, 210, false);
        path.close();

        canvas.drawPath(path, paint);
    }
}
