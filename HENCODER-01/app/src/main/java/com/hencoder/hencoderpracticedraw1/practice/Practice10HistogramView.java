package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

public class Practice10HistogramView extends View {

    private Paint paint = new Paint();
    private Path path = new Path();

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.white));

        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(200, 50);
        path.lineTo(200, 500);
        path.lineTo(1000, 500);
        canvas.drawPath(path, paint);

        //x axis
        int positionMoveX = 260;
        int x = 110;
        paint.setTextSize(32);
        String[] textArray = {"A", "B", "C", "D", "E", "F", "G"};
        int size = textArray.length;
        for(int num = 0; num < size; num++){
            canvas.drawText(textArray[num], positionMoveX + (num * x), 540, paint);
        }

        //y axis
        int y = 100;

        //title
        paint.setTextSize(64);
        canvas.drawText("直方圖", 450, 660, paint);

        //square
        int width = 92;
        paint.setColor(getResources().getColor(R.color.sample_green));
        paint.setStrokeWidth(width);
        int yDivide = (500 - 50) / size;
        for(int num = 0; num < size; num++){
            canvas.drawLine(200 + (positionMoveX - 200) + num * x, 500,
                    200 + (positionMoveX - 200) + num * x, 500 - num * yDivide, paint);
        }

    }
}
