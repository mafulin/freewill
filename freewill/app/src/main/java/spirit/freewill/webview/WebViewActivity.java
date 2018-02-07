package spirit.freewill.webview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import spirit.freewill.R;

/**
 * Created by mafulin on 2017/9/12.
 */

public class WebViewActivity extends AppCompatActivity {
    private WebView webview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);


        webview = (WebView) findViewById(R.id.webview);
        webview.setWebViewClient(new NoAdWebViewClient());
//		webview.loadUrl("http://jilu.yuanwushi.com/");
//		webview.loadUrl("http://yuanwushi.com/forum.php?mobile=1");

        WebSettings webSettings = webview.getSettings();
        //支持缩放，默认为true。
        webSettings.setSupportZoom(true);
        //调整图片至适合webview的大小
        webSettings.setUseWideViewPort(true);
        // 缩放至屏幕的大小
        webSettings.setLoadWithOverviewMode(true);
        //设置默认编码
        webSettings.setDefaultTextEncodingName("utf-8");
        //设置自动加载图片
        webSettings.setLoadsImagesAutomatically(true);
        //多窗口
        webSettings.supportMultipleWindows();
        //获取触摸焦点
        webview.requestFocusFromTouch();
        //允许访问文件
        webSettings.setAllowFileAccess(true);
        //开启javascript
        webSettings.setJavaScriptEnabled(true);
        //支持通过JS打开新窗口
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        //提高渲染的优先级
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        //支持内容重新布局
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //关闭webview中缓存
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);


//        webview.loadUrl("http://www.xuelingxiu.com/yuanwushidayiall.html");
        webview.loadUrl(getUrl());
    }

    private void initList() {
    }

    private void initview() {

    }

    private String getUrl() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        if(TextUtils.isEmpty(url)){
            return "http://blog.sina.com.cn/1ness";
        }else{
            return url;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    public void click(View v) {
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK && webview.canGoBack()){
            webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}























