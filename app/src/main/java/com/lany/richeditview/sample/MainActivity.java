package com.lany.richeditview.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lany.richeditview.ActionView;
import com.lany.richeditview.RichEditor;

public class MainActivity extends AppCompatActivity {
    private RichEditor mEditor;
    private ActionView mActionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditor = findViewById(R.id.rich_editor);
        mActionView = findViewById(R.id.action_view);
        mEditor.setOnTextChangeListener(new RichEditor.OnTextChangeListener() {
            @Override
            public void onTextChange(String text) {
                Log.i("TAG", "内容: " + text);
            }
        });
        //        mEditor.setEditorHeight(200);
        mEditor.setEditorFontSize(18);
        mEditor.setEditorFontColor(Color.BLACK);
        //mEditor.setEditorBackgroundColor(Color.BLUE);
        //mEditor.setBackgroundColor(Color.BLUE);
        //mEditor.setBackgroundResource(R.drawable.bg);
        mEditor.setPadding(10, 10, 10, 10);
        //mEditor.setBackground("https://raw.githubusercontent.com/wasabeef/art/master/chip.jpg");
        mEditor.setPlaceholder("请输入...");
        //mEditor.setInputEnabled(false);
        mActionView.setRichEditor(mEditor);
        mActionView.setOnActionListener(new ActionView.OnActionListener() {
            @Override
            public void insertLinkClicked() {
                mEditor.insertLink("https://github.com/wasabeef", "我是链接");
            }

            @Override
            public void insertImgClicked() {
                mEditor.insertImgFullWidth(
                        "http://d.hiphotos.baidu.com/image/pic/item/91ef76c6a7efce1b5ef04082a251f3deb58f659b.jpg",
                        "测试图片");
            }
        });
    }
}
