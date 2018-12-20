package com.lany.richeditview.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lany.richeditview.RichEditView;

public class MainActivity extends AppCompatActivity {
    private RichEditView richEditView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        richEditView = findViewById(R.id.rich_edit_view);
    }
}
