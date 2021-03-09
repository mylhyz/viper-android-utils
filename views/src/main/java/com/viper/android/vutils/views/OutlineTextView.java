package com.viper.android.vutils.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.appcompat.widget.AppCompatTextView;

import com.viper.android.vutils.utils.DensityUtils;

public class OutlineTextView extends AppCompatTextView {

    private static final float defaultStrokeWidth = 0F;
    private boolean isDrawing = false;

    private int strokeColor = 0;
    private float strokeWidth = 0F;

    public OutlineTextView(Context context) {
        super(context);
        initResources(context, null);
    }

    public OutlineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initResources(context, attrs);
    }

    public OutlineTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initResources(context, attrs);
    }

    private void initResources(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.OutlineTextView);
            strokeColor = typedArray.getColor(R.styleable.OutlineTextView_outlineColor,
                    getCurrentTextColor());
            strokeWidth = typedArray.getFloat(R.styleable.OutlineTextView_outlineWidth,
                    defaultStrokeWidth);
            typedArray.recycle();
        } else {
            strokeColor = getCurrentTextColor();
            strokeWidth = defaultStrokeWidth;
        }
        setStrokeWidth(strokeWidth);
    }

    /**
     * give value in sp
     */
    private void setStrokeWidth(float width) {
        strokeWidth = DensityUtils.dp2px(getContext(), width);
    }

    private void setStrokeWidth(int unit, float width) {
        strokeWidth = TypedValue.applyDimension(
                unit, width, getContext().getResources().getDisplayMetrics());
    }

    @Override
    public void invalidate() {
        if (isDrawing) return;
        super.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (strokeWidth > 0) {
            isDrawing = true;
            Paint p = getPaint();
            p.setStyle(Paint.Style.FILL);

            super.onDraw(canvas);

            int currentTextColor = getCurrentTextColor();
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(strokeWidth);
            setTextColor(strokeColor);
            super.onDraw(canvas);
            setTextColor(currentTextColor);
            isDrawing = false;
        } else {
            super.onDraw(canvas);
        }
    }
}
