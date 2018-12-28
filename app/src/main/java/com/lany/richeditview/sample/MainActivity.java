package com.lany.richeditview.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.lany.box.activity.BaseActivity;
import com.lany.box.dialog.SimpleDialog;
import com.lany.richeditview.ActionView;
import com.lany.richeditview.RichEditor;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.rich_editor)
    RichEditor richEditor;
    @BindView(R.id.action_view)
    ActionView actionView;

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
        richEditor.setOnTextChangeListener(new RichEditor.OnTextChangeListener() {
            @Override
            public void onTextChange(String text) {
                Log.i("TAG", "内容: " + text);
            }
        });
        //        richEditor.setEditorHeight(200);
        richEditor.setEditorFontSize(18);
        richEditor.setEditorFontColor(Color.BLACK);
        //richEditor.setEditorBackgroundColor(Color.BLUE);
        //richEditor.setBackgroundColor(Color.BLUE);
        //richEditor.setBackgroundResource(R.drawable.bg);
        richEditor.setPadding(10, 10, 10, 10);
        //richEditor.setBackground("https://raw.githubusercontent.com/wasabeef/art/master/chip.jpg");
        richEditor.setPlaceholder("请输入...");
        //richEditor.setInputEnabled(false);
        actionView.setRichEditor(richEditor);
        actionView.setOnActionListener(new ActionView.OnActionListener() {
            @Override
            public void insertLinkClicked() {
                SimpleDialog dialog = new SimpleDialog();
                dialog.setMessage("添加一个连接");
                dialog.setRightBtn("取消", new SimpleDialog.OnRightListener() {
                    @Override
                    public void onClicked() {

                    }
                });
                dialog.setLeftBtn("确定", new SimpleDialog.OnLeftListener() {
                    @Override
                    public void onClicked() {
                        richEditor.insertLink("https://github.com/wasabeef", "我是链接");
                    }
                });
                dialog.show(self);
            }

            @Override
            public void insertImgClicked() {
                richEditor.insertImgFullWidth(
                        "http://d.hiphotos.baidu.com/image/pic/item/91ef76c6a7efce1b5ef04082a251f3deb58f659b.jpg",
                        "测试图片");
            }
        });
    }
}
