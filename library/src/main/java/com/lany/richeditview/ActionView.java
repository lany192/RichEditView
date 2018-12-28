package com.lany.richeditview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class ActionView extends FrameLayout implements View.OnClickListener {
    private RichEditor mEditor;
    private boolean mTextColorChanged;
    private boolean mBgColorChanged;
    private View mTextMenuView;
    private OnActionListener mListener;

    public void setRichEditor(RichEditor editor) {
        this.mEditor = editor;
    }

    public ActionView(Context context) {
        super(context);
        initView(null);
    }

    public ActionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public ActionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        View view = View.inflate(this.getContext(), R.layout.view_editor_action, this);
        mTextMenuView = view.findViewById(R.id.bottom_text_menu_view);

        findViewById(R.id.action_text_menu).setOnClickListener(this);
        findViewById(R.id.action_undo).setOnClickListener(this);
        findViewById(R.id.action_redo).setOnClickListener(this);
        findViewById(R.id.action_bold).setOnClickListener(this);
        findViewById(R.id.action_italic).setOnClickListener(this);
        findViewById(R.id.action_subscript).setOnClickListener(this);
        findViewById(R.id.action_superscript).setOnClickListener(this);
        findViewById(R.id.action_strikethrough).setOnClickListener(this);
        findViewById(R.id.action_underline).setOnClickListener(this);
        findViewById(R.id.action_heading1).setOnClickListener(this);
        findViewById(R.id.action_heading2).setOnClickListener(this);
        findViewById(R.id.action_heading3).setOnClickListener(this);
        findViewById(R.id.action_heading4).setOnClickListener(this);
        findViewById(R.id.action_heading5).setOnClickListener(this);
        findViewById(R.id.action_heading6).setOnClickListener(this);
        findViewById(R.id.action_txt_color).setOnClickListener(this);
        findViewById(R.id.action_bg_color).setOnClickListener(this);
        findViewById(R.id.action_indent).setOnClickListener(this);
        findViewById(R.id.action_outdent).setOnClickListener(this);
        findViewById(R.id.action_align_left).setOnClickListener(this);
        findViewById(R.id.action_align_center).setOnClickListener(this);
        findViewById(R.id.action_align_right).setOnClickListener(this);
        findViewById(R.id.action_blockquote).setOnClickListener(this);
        findViewById(R.id.action_insert_bullets).setOnClickListener(this);
        findViewById(R.id.action_insert_numbers).setOnClickListener(this);
        findViewById(R.id.action_insert_image).setOnClickListener(this);
        findViewById(R.id.action_insert_link).setOnClickListener(this);
        findViewById(R.id.action_insert_checkbox).setOnClickListener(this);
    }

    public interface OnActionListener {
        void insertLinkClicked();

        void insertImgClicked();
    }

    public void setOnActionListener(OnActionListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.action_text_menu) {
            if (mTextMenuView.getVisibility() == VISIBLE) {
                mTextMenuView.setVisibility(GONE);
            } else {
                mTextMenuView.setVisibility(VISIBLE);
            }
        } else if (i == R.id.action_undo) {
            mEditor.undo();
        } else if (i == R.id.action_redo) {
            mEditor.redo();
        } else if (i == R.id.action_bold) {
            mEditor.setBold();
        } else if (i == R.id.action_italic) {
            mEditor.setItalic();
        } else if (i == R.id.action_subscript) {
            mEditor.setSubscript();
        } else if (i == R.id.action_superscript) {
            mEditor.setSuperscript();
        } else if (i == R.id.action_strikethrough) {
            mEditor.setStrikeThrough();
        } else if (i == R.id.action_underline) {
            mEditor.setUnderline();
        } else if (i == R.id.action_heading1) {
            mEditor.setHeading(1);
        } else if (i == R.id.action_heading2) {
            mEditor.setHeading(2);
        } else if (i == R.id.action_heading3) {
            mEditor.setHeading(3);
        } else if (i == R.id.action_heading4) {
            mEditor.setHeading(4);
        } else if (i == R.id.action_heading5) {
            mEditor.setHeading(5);
        } else if (i == R.id.action_heading6) {
            mEditor.setHeading(6);
        } else if (i == R.id.action_txt_color) {
            mEditor.setTextColor(mTextColorChanged ? Color.BLACK : Color.RED);
            mTextColorChanged = !mTextColorChanged;
        } else if (i == R.id.action_bg_color) {
            mEditor.setTextBackgroundColor(mBgColorChanged ? Color.TRANSPARENT : Color.YELLOW);
            mBgColorChanged = !mBgColorChanged;
        } else if (i == R.id.action_indent) {
            mEditor.setIndent();
        } else if (i == R.id.action_outdent) {
            mEditor.setOutdent();
        } else if (i == R.id.action_align_left) {
            mEditor.setAlignLeft();
        } else if (i == R.id.action_align_center) {
            mEditor.setAlignCenter();
        } else if (i == R.id.action_align_right) {
            mEditor.setAlignRight();
        } else if (i == R.id.action_insert_bullets) {
            mEditor.setBullets();
        } else if (i == R.id.action_insert_numbers) {
            mEditor.setNumbers();
        } else if (i == R.id.action_blockquote) {
            mEditor.setBlockquote();
        } else if (i == R.id.action_insert_image) {
            if (mListener != null) {
                mListener.insertImgClicked();
            }
        } else if (i == R.id.action_insert_link) {
            if (mListener != null) {
                mListener.insertLinkClicked();
            }
        } else if (i == R.id.action_insert_checkbox) {
            mEditor.insertTodo();
        }
    }

    public void setOnTextChangeListener(RichEditor.OnTextChangeListener listener) {
        mEditor.setOnTextChangeListener(listener);
    }

    public void setHtml(String contents) {
        mEditor.setHtml(contents);
    }

    public String getHtml() {
        return mEditor.getHtml();
    }

    public void setEditorFontColor(int color) {
        mEditor.setEditorFontColor(color);
    }

    public void setEditorFontSize(int px) {
        mEditor.setEditorFontSize(px);
    }

    public void setEditorPadding(int left, int top, int right, int bottom) {
        mEditor.setPadding(left, top, right, bottom);
    }

    public void setEditorBackgroundColor(int color) {
        mEditor.setBackgroundColor(color);
    }

    public void setEditorBackgroundResource(int resid) {
        mEditor.setBackgroundResource(resid);
    }

    public void setEditorBackground(Drawable background) {
        mEditor.setBackground(background);
    }

    public void setEditorBackground(String url) {
        mEditor.setBackground(url);
    }

    public void setEditorWidth(int px) {
        mEditor.setEditorWidth(px);
    }

    public void setEditorHeight(int px) {
        mEditor.setEditorHeight(px);
    }

    public void setPlaceholder(String placeholder) {
        mEditor.setPlaceholder(placeholder);
    }

    public void setInputEnabled(Boolean inputEnabled) {
        mEditor.setInputEnabled(inputEnabled);
    }

    public void loadCSS(String cssFile) {
        mEditor.loadCSS(cssFile);
    }

    public void undo() {
        mEditor.undo();
    }

    public void redo() {
        mEditor.redo();
    }

    public void setBold() {
        mEditor.setBold();
    }

    public void setItalic() {
        mEditor.setItalic();
    }

    public void setSubscript() {
        mEditor.setSubscript();
    }

    public void setSuperscript() {
        mEditor.setSuperscript();
    }

    public void setStrikeThrough() {
        mEditor.setStrikeThrough();
    }

    public void setUnderline() {
        mEditor.setUnderline();
    }

    public void setTextColor(int color) {
        mEditor.setTextColor(color);
    }

    public void setTextBackgroundColor(int color) {
        mEditor.setFontSize(color);
    }

    public void setFontSize(int fontSize) {
        mEditor.setFontSize(fontSize);
    }

    public void removeFormat() {
        mEditor.removeFormat();
    }

    public void setHeading(int heading) {
        mEditor.setHeading(heading);
    }

    public void setIndent() {
        mEditor.setIndent();
    }

    public void setOutdent() {
        mEditor.setOutdent();
    }

    public void setAlignLeft() {
        mEditor.setAlignLeft();
    }

    public void setAlignCenter() {
        mEditor.setAlignCenter();
    }

    public void setAlignRight() {
        mEditor.setAlignRight();
    }

    public void setBlockquote() {
        mEditor.setBlockquote();
    }

    public void setBullets() {
        mEditor.setBullets();
    }

    public void setNumbers() {
        mEditor.setNumbers();
    }

    public void insertImg(String url, String alt) {
        mEditor.insertImg(url, alt);
    }

    public void insertImgFullWidth(String url, String alt) {
        mEditor.insertImgFullWidth(url, alt);
    }

    public void insertLink(String href, String title) {
        mEditor.insertLink(href, title);
    }

    public void insertTodo() {
        mEditor.insertTodo();
    }

    public void focusEditor() {
        mEditor.focusEditor();
    }

    public void clearFocusEditor() {
        mEditor.clearFocusEditor();
    }
}