package com.lany.richeditview.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lany.richeditview.RichEditView;

import jp.wasabeef.richeditor.RichEditor;

public class MainActivity extends AppCompatActivity {
    private RichEditView richEditView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        richEditView = findViewById(R.id.rich_edit_view);
        richEditView.setOnTextChangeListener(new RichEditor.OnTextChangeListener() {
            @Override
            public void onTextChange(String text) {
                Log.i("TAG", "内容: " + text);
            }
        });
        richEditView.setOnActionListener(new RichEditView.OnActionListener() {
            @Override
            public void insertLinkClicked() {
                richEditView.insertLink("https://github.com/wasabeef", "wasabeef");
            }

            @Override
            public void insertImageClicked() {
                richEditView.insertImage("http://www.1honeywan.com/dachshund/image/7.21/7.21_3_thumb.JPG", "dachshund");
            }
        });
    }
}
