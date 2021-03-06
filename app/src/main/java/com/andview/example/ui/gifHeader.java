package com.andview.example.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andview.example.R;
import com.andview.refreshview.callback.IHeaderCallBack;

public class GifHeader extends LinearLayout implements IHeaderCallBack {
    private GifView gifView1;
    private GifView gifView2;
    private TextView mHintTextView;

    public GifHeader(Context context) {
        super(context);
        initView(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public GifHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.gif_header, this);
        gifView1 = (GifView) findViewById(R.id.gif1);
        mHintTextView = (TextView) findViewById(R.id.gif_header_hint);
        gifView2 = (GifView) findViewById(R.id.gif2);
        gifView1.setMovieResource(R.raw.vertical);
        gifView2.setMovieResource(R.raw.horizontal);
        gifView2.setVisibility(View.GONE);
    }

    public void setRefreshTime(long lastRefreshTime) {
    }

    /**
     * hide footer when disable pull load more
     */
    public void hide() {
        setVisibility(View.GONE);
    }

    public void show() {
        setVisibility(View.VISIBLE);
    }

    @Override
    public void onStateNormal() {
        mHintTextView.setText(R.string.xrefreshview_header_hint_normal);
        gifView1.setVisibility(View.VISIBLE);
        gifView2.setVisibility(View.GONE);
    }

    @Override
    public void onStateReady() {
        mHintTextView.setText(R.string.xrefreshview_header_hint_ready);
    }

    @Override
    public void onStateRefreshing() {
        mHintTextView.setText(R.string.xrefreshview_header_hint_refreshing);
        gifView1.setVisibility(View.GONE);
        gifView2.setVisibility(View.VISIBLE);
    }

    @Override
    public void onStateFinish() {
        mHintTextView.setText(R.string.xrefreshview_header_hint_loaded);
//        gifView1.setVisibility(View.VISIBLE);
        gifView2.setVisibility(View.GONE);
    }

    @Override
    public void onHeaderMove(double offset, int offsetY, int deltaY) {

    }

    @Override
    public int getHeaderHeight() {
        return getMeasuredHeight();
    }
}
