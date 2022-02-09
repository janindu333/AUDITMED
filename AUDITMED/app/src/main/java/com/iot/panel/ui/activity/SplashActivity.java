package com.iot.panel.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.iot.panel.R;
import com.iot.panel.common.CommonUtils;
import com.iot.panel.common.IPreferencesKeys;
import com.iot.panel.ui.util.Alert;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigateToApp();
//        if (CommonUtils.getInstance().isNetworkConnected()) {
//            navigateToApp();
//        } else {
//            showDialog();
//        }
    }

    private void navigateToApp() {
        if (CommonUtils.getInstance().isNetworkConnected()) {
            final SharedPreferences preferences =
                    getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
            Class classObj = preferences.contains(IPreferencesKeys.USER_ID)
                    ? MainActivity.class : MainActivity.class;
            Intent i = new Intent(SplashActivity.this, classObj);
            startActivity(i);
            finish();
        } else
            showDialog();
    }

    private void showDialog() {
        Alert.tryAgainDialog(SplashActivity.this, getString(R.string.warning),
                getString(R.string.internet_connection_lost), getString(R.string.try_again),
                getString(R.string.cancel), (dialog, which) -> {
                    navigateToApp();
                    dialog.dismiss();
                }, (dialog, which) -> {
                    System.exit(0);
                    dialog.dismiss();
                });
    }
}
