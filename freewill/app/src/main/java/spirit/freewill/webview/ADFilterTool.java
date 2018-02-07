package spirit.freewill.webview;

import android.content.Context;
import android.content.res.Resources;

import spirit.freewill.R;
import spirit.freewill.util.Constant;

/**
 * Created by mafulin on 2018/2/1.
 */

public class ADFilterTool {
    public static boolean hasAd(String url){
        Resources res= Constant.context.getResources();
        String[] adUrls =res.getStringArray(R.array.adBlockUrl);
        for(String adUrl :adUrls){
            if(url.contains(adUrl)){
                return true;
            }
        }
        return false;
    }
}
