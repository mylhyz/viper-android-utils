package com.viper.android.vutils.views;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.viper.android.vutils.utils.Dispatcher;

public abstract class AbsInfoView extends AppCompatTextView {

    public AbsInfoView(Context context) {
        this(context, null);
    }

    public AbsInfoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AbsInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        onInit(context);
    }

    private void init(Context context) {
        Dispatcher.background().post(() -> {
            String info = onGetInfo(context);
            Dispatcher.main().post(() -> setText(info));
        });
    }

    public abstract void onInit(Context context);

    public abstract String onGetInfo(Context context);

    public static class Builder {
        private final StringBuilder mStringBuilder;

        public Builder() {
            mStringBuilder = new StringBuilder();
        }

        public Builder put(int number) {
            mStringBuilder.append(number);
            return this;
        }

        public Builder put(String text) {
//            if (mStringBuilder.length() != 0) {
//                mStringBuilder.append("\n");
//            }
            mStringBuilder.append(text);
            return this;
        }

        public Builder lf() {
            mStringBuilder.append('\n');
            return this;
        }

//        public Builder put(String key, String value) {
//            if (mStringBuilder.length() != 0) {
//                mStringBuilder.append("\n");
//            }
//            mStringBuilder.append(key).append(value);
//            return this;
//        }
//
//        public Builder put(String key, String separator, String value) {
//            if (mStringBuilder.length() != 0) {
//                mStringBuilder.append("\n");
//            }
//            mStringBuilder.append(key).append(separator).append(value);
//            return this;
//        }

        public String build() {
            return mStringBuilder.toString();
        }

        @Override
        public String toString() {
            return build();
        }
    }
}
