package com.lany.richeditview.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lany.box.activity.BaseActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @Override
    protected boolean hasBackBtn() {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @OnClick({R.id.edit_button, R.id.preview_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.edit_button:
                startActivity(new Intent(MainActivity.this, EditActivity.class));
                break;
            case R.id.preview_button:
                break;
        }
    }
}
