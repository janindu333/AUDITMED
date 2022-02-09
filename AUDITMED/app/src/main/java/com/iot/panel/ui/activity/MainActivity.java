package com.iot.panel.ui.activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.iot.panel.R;
import com.iot.panel.db.DaoMaster;
import com.iot.panel.db.DaoSession;
import com.iot.panel.ui.fragment.GoogleMapFragment;
import com.iot.panel.ui.fragment.HomeFragment;
import com.iot.panel.ui.util.Animator;

import org.greenrobot.greendao.database.Database;

import butterknife.BindView;
import butterknife.ButterKnife;
public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.progress_view)
    RelativeLayout progressView;

    @BindView(R.id.navigation_view)
    BottomNavigationView bottomNavigationView;

    private HomeFragment homeFragment;
    public GoogleMapFragment googleMapFragment;
    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        initFragment(getHomeFragment());
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,
                getString(R.string.database_name));
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

    }

    public void showProgressBar() {
        hideProgressBar();
        Animator.fadeIn(progressView, 250);
    }

    public void hideProgressBar() {
        if (progressView.getVisibility() == View.VISIBLE) {
            Animator.fadeOut(progressView);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.action_home:
                fragment = getHomeFragment();
                break;
            case R.id.action_map:
                fragment = getMapFragment();
                break;
        }

        initFragment(fragment);

        return true;
    }

    private void initFragment(Fragment fragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (fragment != null && supportFragmentManager != null
                && !supportFragmentManager.isDestroyed()) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.basic_fragment, fragment).commitAllowingStateLoss();
        }
    }

    private Fragment getHomeFragment() {
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
            homeFragment.setArguments(getIntent().getExtras());
        }
        return homeFragment;
    }

    private Fragment getMapFragment() {
        if (googleMapFragment == null) {
            googleMapFragment = new GoogleMapFragment();
            googleMapFragment.setArguments(getIntent().getExtras());
        }
        return googleMapFragment;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}