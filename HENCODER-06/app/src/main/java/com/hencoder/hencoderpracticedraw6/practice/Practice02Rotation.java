package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice02Rotation extends RelativeLayout {

    Button animateBt;
    ImageView imageView;

    State state = State.rotate;

    public enum State{
        rotate, rotateBack, rotateX, rotateBackX, rotateY, rotateBackY
    }

    public Practice02Rotation(Context context) {
        super(context);
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // // TODO 在这里处理点击事件，通过 View.animate().rotation/X/Y() 来让 View 旋转
                switch (state){
                    case rotate:
                        imageView.animate().rotation(180);
                        state = State.rotateBack;
                        break;
                    case rotateBack:
                        imageView.animate().rotation(0);
                        state = State.rotateX;
                        break;
                    case rotateX:
                        imageView.animate().rotationX(180);
                        state = State.rotateBackX;
                        break;
                    case rotateBackX:
                        imageView.animate().rotationX(0);
                        state = State.rotateY;
                        break;
                    case rotateY:
                        imageView.animate().rotationY(180);
                        state = State.rotateBackY;
                        break;
                    case rotateBackY:
                        imageView.animate().rotationY(0);
                        state = State.rotate;
                        break;

                }
            }
        });
    }
}