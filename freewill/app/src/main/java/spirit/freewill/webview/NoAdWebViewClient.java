package spirit.freewill.webview;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by mafulin on 2018/2/1.
 */

public class NoAdWebViewClient extends WebViewClient {
//    private  String homeurl;
//    private Context context;

    public NoAdWebViewClient(){
//        this.context= context;
//        this.homeurl= homeurl;
    }
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, String url){
        url= url.toLowerCase();
//        if(!url.contains(homeurl)){
            if(!ADFilterTool.hasAd(url)){
                return super.shouldInterceptRequest(view,url);
            }else{
                return new WebResourceResponse(null,null,null);
            }
//        }else{
//            return super.shouldInterceptRequest(view,url);
//        }


    }

}
