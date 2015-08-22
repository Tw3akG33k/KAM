package com.fast.access.kam.activities.base;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.fast.access.kam.R;

import butterknife.ButterKnife;

/**
 * Created by Kosh on 8/22/2015. copyrights are reserved
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int layout();

    protected abstract boolean canBack();

    protected abstract boolean hasMenu();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        ButterKnife.bind(this);
        if (findViewById(R.id.toolbar) != null) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            final ActionBar ab = getSupportActionBar();
            if (ab != null) {
                if (canBack()) {
                    ab.setHomeAsUpIndicator(R.drawable.ic_back);
                    ab.setDisplayHomeAsUpEnabled(true);
                } else {
                    ab.setHomeAsUpIndicator(R.drawable.ic_menu);
                    ab.setDisplayHomeAsUpEnabled(true);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        if (hasMenu()) {
//            return true;
//        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (canBack()) {
            if (item.getItemId() == android.R.id.home) {
                onBackPressed();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
