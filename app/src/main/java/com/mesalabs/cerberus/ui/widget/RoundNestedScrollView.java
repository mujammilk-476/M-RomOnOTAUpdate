package com.mesalabs.cerberus.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.mesalabs.cerberus.R;
import com.mesalabs.cerberus.utils.LogUtils;
import com.mesalabs.cerberus.utils.Utils;
import com.samsung.android.ui.util.SeslRoundedCorner;
import com.samsung.android.ui.widget.SeslNestedScrollView;

/*
 * Cerberus Core App
 *
 * Coded by BlackMesa @2020
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * ULTRA-MEGA-PRIVATE SOURCE CODE. SHARING TO DEVKINGS TEAM
 * EXTERNALS IS PROHIBITED AND WILL BE PUNISHED WITH ANAL ABUSE.
 */

public class RoundNestedScrollView extends SeslNestedScrollView {
    private Context mContext;
    SeslRoundedCorner mSeslRoundedCorner;

    public RoundNestedScrollView(Context context) {
        super(context);
    }

    public RoundNestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;

        TypedArray obtainStyledAttributes = mContext.obtainStyledAttributes(attrs, R.styleable.RoundNestedScrollView);

        boolean cornersStroke = obtainStyledAttributes.getBoolean(R.styleable.RoundNestedScrollView_cornersStroke, false);
        int roundedCorners = obtainStyledAttributes.getInt(R.styleable.RoundNestedScrollView_roundedCorners, 15);

        if (cornersStroke)
            LogUtils.w("RoundNestedScrollView", "cornersStroke is not supported in this View!");

        mSeslRoundedCorner = new SeslRoundedCorner(mContext, false);
        mSeslRoundedCorner.setRoundedCorners(roundedCorners);
        mSeslRoundedCorner.setRoundedCornerColor(roundedCorners, getResources().getColor(Utils.isNightMode(mContext) ? R.color.sesl_round_and_bgcolor_dark : R.color.sesl_round_and_bgcolor_light, mContext.getTheme()));

        obtainStyledAttributes.recycle();
    }

    public RoundNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        mSeslRoundedCorner.drawRoundedCorner(canvas);
    }
}