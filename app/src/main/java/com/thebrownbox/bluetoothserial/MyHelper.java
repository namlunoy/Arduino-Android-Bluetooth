package com.thebrownbox.bluetoothserial;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by hoangcong on 9/16/16.
 */
public class MyHelper {

    public static boolean isNetworkConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    public static void showBanner(AppCompatActivity context, int adViewId) {
        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) context.findViewById(adViewId);
        if(isNetworkConnected(context)){
            AdRequest adRequest = new AdRequest.Builder()
                    .setRequestAgent("android_studio:ad_template").build();
            adView.loadAd(adRequest);
        }else{
            adView.setVisibility(View.GONE);
        }
    }
}
