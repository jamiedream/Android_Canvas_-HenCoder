package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

import java.nio.channels.SelectionKey;

public class Practice06SkewView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice06SkewView(Context context) {
        super(context);
    }

    public Practice06SkewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06SkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    /**
     *
     * skew(sx, sy)
     * @params sx 将画布在x方向上倾斜相应的角度，sx倾斜角度的tan值，其实就是将y逆时针旋转相应的角度
     * @params sy 将画布在y方向上倾斜相应的角度，sx倾斜角度的tan值，其实就是将x顺时针旋转相应的角度
     *
     * 水平错切
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float skewRat = 0.5f;

        //skew y
        canvas.save();
        canvas.skew(0, skewRat);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        //skew x
        canvas.save();
        canvas.skew(-skewRat, 0);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
