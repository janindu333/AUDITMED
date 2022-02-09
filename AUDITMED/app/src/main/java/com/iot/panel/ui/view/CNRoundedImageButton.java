package com.iot.panel.ui.view;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageButton;

import com.iot.panel.R;

public class CNRoundedImageButton extends ImageButton {

    public float cornerRadius;
    private Path clipPath;
    private RectF rect;

    public CNRoundedImageButton(Context context) {
        super(context);
    }

    public CNRoundedImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CNRoundedImageButton, 0, 0);
        try {
            cornerRadius = ta.getDimension(R.styleable.CNRoundedImageButton_corner_radius, getWidth()/ 2);
        } finally {
            ta.recycle();
        }
    }

    public CNRoundedImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CNRoundedImageButton, 0, 0);
        try {
            cornerRadius = ta.getDimension(R.styleable.CNRoundedImageButton_corner_radius, getWidth()/ 2);
        } finally {
            ta.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        clipPath = new Path();
        rect = new RectF(0, 0, this.getWidth(), this.getHeight());
        clipPath.addRoundRect(rect, cornerRadius, cornerRadius, Path.Direction.CW);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR2) {
            canvas.clipPath(clipPath);
        }
        super.onDraw(canvas);
    }
}
