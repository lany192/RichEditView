package com.lany.richeditview.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lany.richeditview.RichEditView;
import com.lany.richeditview.RichEditor;

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
                richEditView.insertLink("https://github.com/wasabeef", "我是链接");
            }

            @Override
            public void insertImgClicked() {



                richEditView.insertImgFullWidth(
                        "http://d.hiphotos.baidu.com/image/pic/item/91ef76c6a7efce1b5ef04082a251f3deb58f659b.jpg",
                        "测试图片");
            }
        });
    }
}
