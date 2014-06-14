/*
 * Copyright (C) 2014 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cyanogenmod.launcher.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import com.android.launcher.home.Home;

public class HomeStub implements Home {

    private HomeLayout mHomeLayout;
    private static final String TAG = "HomeStub";

    private final AccelerateInterpolator mAlphaInterpolator;

    public HomeStub() {
        super();
        mAlphaInterpolator = new AccelerateInterpolator();
    }

    @Override
    public void onStart(Context context) {
    }

    @Override
    public void onDestroy(Context context) {
        mHomeLayout = null;
    }

    @Override
    public void onResume(Context context) {
    }

    @Override
    public void onPause(Context context) {
    }

    @Override
    public void onShow(Context context) {
        if (mHomeLayout != null) {
            mHomeLayout.setAlpha(1.0f);
        }
    }

    @Override
    public void onScrollProgressChanged(Context context, float progress) {
        if (mHomeLayout != null) {
            mHomeLayout.setAlpha(mAlphaInterpolator.getInterpolation(progress));
        }
    }

    @Override
    public void onHide(Context context) {
        if (mHomeLayout != null) {
            mHomeLayout.setAlpha(0.0f);
        }
    }

    @Override
    public void onInvalidate(Context context) {
        if (mHomeLayout != null) {
            mHomeLayout.removeAllViews();
        }
    }

    @Override
    public void onRequestSearch(Context context, int mode) {
        
    }

    @Override
    public View createCustomView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        mHomeLayout = (HomeLayout)inflater.inflate(R.layout.home_layout, null);
        return mHomeLayout;
    }

    @Override
    public String getName(Context context) {
        return "HomeStub";
    }

    @Override
    public int getNotificationFlags() {
        return Home.FLAG_NOTIFY_ALL;
    }

    @Override
    public int getOperationFlags() {
        return Home.FLAG_OP_ALL;
    }
}
