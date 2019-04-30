package com.hencoder.hencoderpracticedraw4.practice;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice15Flipboard extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Camera camera = new Camera();
    int degree;
    int degreeY;
    int degreeY2;
    ObjectAnimator animator = ObjectAnimator.ofInt(this, "degree", 0, 270);
    ObjectAnimator animator1 = ObjectAnimator.ofInt(this, "degreeY", 0, -45);
    ObjectAnimator animator2 = ObjectAnimator.ofInt(this, "degreeY2", 0, -45);
    AnimatorSet animatorSet;

    public Practice15Flipboard(Context context) {
        super(context);
    }

    public Practice15Flipboard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice15Flipboard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        camera.setLocation(0, 0, -displayMetrics.density * 6);

        animator.setDuration(1000);
        animator.setStartDelay(500);
        animator.setInterpolator(new LinearInterpolator());

        animator1.setDuration(800);
        animator.setStartDelay(500);
        animator1.setInterpolator(new LinearInterpolator());

        animator2.setDuration(500);
        animator.setStartDelay(500);
        animator2.setInterpolator(new LinearInterpolator());

        animatorSet = new AnimatorSet();
        animatorSet.playSequentially(animator1, animator, animator2);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                degree = 0;
                degreeY = 0;
                degreeY2 = 0;
                animatorSet.start();
            }
        });
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animatorSet.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animatorSet.end();
    }

    @SuppressWarnings("unused")
    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }

    @SuppressWarnings("unused")
    public void setDegreeY(int degreeY) {
        this.degreeY = degreeY;
        invalidate();
    }

    @SuppressWarnings("unused")
    public void setDegreeY2(int degreeY2) {
        this.degreeY2 = degreeY2;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int x = centerX - bitmapWidth / 2;
        int y = centerY - bitmapHeight / 2;

        //note: view沿著中心分割線動畫
//        canvas.rotate(-degreeZ);
//        canvas.clipRect(0, -centerY, centerX, centerY);
//        canvas.rotate(degreeZ);
//        canvas.drawBitmap(bitmap, x, y, paint);

        //不動
        canvas.save();
        camera.save();
        canvas.translate(centerX, centerY);
        canvas.rotate(-degree);
        canvas.clipRect(-centerX, -centerY, 0, centerY);//左半圖
        canvas.rotate(degree);
        camera.rotateX(degreeY2);//x axis 三維旋轉
        camera.applyToCanvas(canvas);
        canvas.translate(-centerX, -centerY);
        canvas.drawBitmap(bitmap, x, y, paint);
        camera.restore();
        canvas.restore();

        //動
        canvas.save();
        camera.save();
        canvas.translate(centerX, centerY);
        canvas.rotate(-degree);
        camera.rotateY(degreeY);//y axis 三維旋轉
        camera.applyToCanvas(canvas);
        canvas.clipRect(0, -centerY, centerX, centerY);//右半圖
        canvas.rotate(degree);
        canvas.translate(-centerX, -centerY);
        canvas.drawBitmap(bitmap, x, y, paint);
        camera.restore();
        canvas.restore();


    }
}
