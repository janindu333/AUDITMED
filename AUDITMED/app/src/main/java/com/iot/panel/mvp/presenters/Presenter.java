package com.iot.panel.mvp.presenters;


import android.view.View;

public interface Presenter<T> {
    void onCreate();

    void onStart();

    void onStop();

    void onDestroy();

    void attachView(View v);
}
