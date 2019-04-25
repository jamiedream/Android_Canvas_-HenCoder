package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

public class Practice11PieChartView extends View {

    private Paint paint = new Paint();
    private RectF rectF = new RectF(300, 100, 800, 600);
    private RectF rectFE = new RectF(280, 80, 780, 580);

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        paint.setAntiAlias(true);

        paint.setColor(getResources().getColor(R.color.white));
        paint.setTextSize(48);
        canvas.drawText("圓餅圖", 460, 700, paint);
        paint.setTextSize(32);
        canvas.drawText("Lollipop", 100, 200, paint);
        canvas.drawText("Kitkat", 160, 520, paint);
        canvas.drawText("Marshmallow", 860, 200, paint);
        canvas.drawText("Froyo", 860, 340, paint);
        canvas.drawText("Gingerbread", 860, 380, paint);
        canvas.drawText("Ice cream", 860, 420, paint);
        canvas.drawText("Jelly bean", 860, 540, paint);

        paint.setColor(getResources().getColor(R.color.sample_yellow));
        canvas.drawArc(rectF, -45, 42, true, paint);

        paint.setColor(getResources().getColor(R.color.sample_purple));
        canvas.drawArc(rectF, 0, 8, true, paint);

        paint.setColor(getResources().getColor(R.color.sample_grey));
        canvas.drawArc(rectF, 10, 8, true, paint);

        paint.setColor(getResources().getColor(R.color.sample_green));
        canvas.drawArc(rectF, 20, 62, true, paint);

        paint.setColor(getResources().getColor(R.color.sample_blue));
        canvas.drawArc(rectF, 85, 90, true, paint);

        paint.setColor(getResources().getColor(R.color.sample_red));
        canvas.drawArc(rectFE, 175, 140, true, paint);




    }
}
