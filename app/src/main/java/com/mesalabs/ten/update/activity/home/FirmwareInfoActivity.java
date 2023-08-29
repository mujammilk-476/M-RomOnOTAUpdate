package com.mesalabs.ten.update.activity.home;

import android.os.Build;
import android.os.Bundle;
import android.text.BidiFormatter;
import android.view.View;

import com.mesalabs.cerberus.base.BaseAppBarActivity;
import com.mesalabs.cerberus.ui.callback.OnSingleClickListener;
import com.mesalabs.ten.update.R;
import com.mesalabs.ten.update.ui.widget.CardView;
import com.mesalabs.ten.update.utils.FirmwareInfoUtils;

/*
 * 십 Update
 *
 * Coded by BlackMesa123 @2021
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 */

public class FirmwareInfoActivity extends BaseAppBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mesa_ota_activity_firmwareinfo_layout);

        appBar.setTitleText(getString(R.string.mesa_firmware_info));
        appBar.setHomeAsUpButton(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                onBackPressed();
            }
        });

        init();
    }

    @Override
    protected boolean getIsAppBarExpanded() {
        return false;
    }

    private void init()  {
        // ROM Version
        CardView rom = findViewById(R.id.mesa_card_rom_ota_firmwareinfo);
        setFwInfoCardSummary(rom, FirmwareInfoUtils.getROMVersion());
        // OneUI Version
        CardView oneui = findViewById(R.id.mesa_card_oneui_ota_firmwareinfo);
        setFwInfoCardSummary(oneui, FirmwareInfoUtils.getOneUIVersion());
        // Android Version
        CardView android = findViewById(R.id.mesa_card_android_ota_firmwareinfo);
        setFwInfoCardSummary(android, Build.VERSION.RELEASE);
        // Android Version
        CardView kernel = findViewById(R.id.mesa_card_kernel_ota_firmwareinfo);
        setFwInfoCardSummary(kernel, FirmwareInfoUtils.getKernelVersion());
        // Security Patch
        CardView sp = findViewById(R.id.mesa_card_patch_ota_firmwareinfo);
        setFwInfoCardSummary(sp, FirmwareInfoUtils.getSecurityPatchVersion());
    }

    private void setFwInfoCardSummary(CardView card, String summary) {
        if (summary != null) {
            card.setDescText(summary);
        }
    }

}
