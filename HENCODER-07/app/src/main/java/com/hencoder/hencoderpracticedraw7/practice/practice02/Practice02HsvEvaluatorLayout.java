package com.hencoder.hencoderpracticedraw7.practice.practice02;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw7.R;

public class Practice02HsvEvaluatorLayout extends RelativeLayout {
    Practice02HsvEvaluatorView view;
    Button animateBt;

    public Practice02HsvEvaluatorLayout(Context context) {
        super(context);
    }

    public Practice02HsvEvaluatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02HsvEvaluatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = (Practice02HsvEvaluatorView) findViewById(R.id.objectAnimatorView);
        animateBt = (Button) findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofInt(view, "color", 0xffff0000, 0xff00ff00);
                animator.setEvaluator(new HsvEvaluator()); // 使用自定义的 HsvEvaluator
                animator.setInterpolator(new LinearInterpolator());
                animator.setDuration(2000);
                animator.start();
            }
        });
    }

    private class HsvEvaluator implements TypeEvaluator<Integer> {

        float[] start = new float[3];
        float[] end = new float[3];
        float[] act = new float[3];
        // 重写 evaluate() 方法，让颜色按照 HSV 来变化
        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {

            //convert color to hsv
            Color.colorToHSV(startValue, start);
            Color.colorToHSV(endValue, end);

            //adjust hue value
            if(end[0] - start[0] > 180){
                end[0] -= 360;
            }else if(end[0] - start[0] < -180){
                end[0] += 360;
            }

            act[0] = start[0] + (end[0] - start[0]) * fraction;

            if(act[0] > 360){
                act[0] -= 360;
            }else if(act[0] < 0){
                act[0] += 360;
            }

            act[1] = start[1] + (end[1] - start[1]) * fraction;
            act[2] = start[2] + (end[2] - start[2]) * fraction;

            //argb, each one is 8 bits, alpha value will need move to right 24.
            int alpha = startValue >> 24 + (endValue >> 24 - startValue >> 24);


            return Color.HSVToColor(alpha, act);
        }
    }
}
