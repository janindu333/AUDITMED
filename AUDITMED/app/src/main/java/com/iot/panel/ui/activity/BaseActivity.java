package com.iot.panel.ui.activity;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.iot.panel.mvp.presenters.Presenter;
import com.iot.panel.ui.util.Alert;

public class BaseActivity extends AppCompatActivity {

    protected Toolbar mToolBar;
    protected Presenter presenter;

    protected void showLongToast(String message) {
        Toast.makeText(BaseActivity.this, message, Toast.LENGTH_LONG).show();
    }

    protected void showProgressBar() {
        Alert.showProgressBar(this);
    }

    protected void hideProgressBar() {
        if (!this.isFinishing()) {
            Alert.hideProgressBar(this);
        }
    }
}
