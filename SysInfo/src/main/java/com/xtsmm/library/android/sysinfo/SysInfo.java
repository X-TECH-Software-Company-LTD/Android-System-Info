package com.xtsmm.library.android.sysinfo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SysInfo {
    Activity activity;

    public SysInfo(Activity activity) {
        this.activity = activity;
    }

    public String getKeyHash() {
        PackageInfo info;
        try {
            info = activity.getPackageManager().getPackageInfo(activity.getApplicationContext().getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String kh = new String(Base64.encode(md.digest(), 0));
                return kh;
            }

        } catch (PackageManager.NameNotFoundException e1) {
            //Log.e("name not found", e1.toString());
            return null;
        } catch (NoSuchAlgorithmException e) {
            //Log.e("no such an algorithm", e.toString());
            return null;
        } catch (Exception e) {
            // Log.e("exception", e.toString());
            return null;
        }

        return null;
    }

    public void restartApp() {
        Intent i = activity.getPackageManager().
                getLaunchIntentForPackage(activity.getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(i);

    }


    public int getPhoneWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int phoneWidth = displayMetrics.widthPixels;
        return phoneWidth;
    }

    public int getPhoneHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int phoneHeight = displayMetrics.heightPixels;
        return phoneHeight;
    }

    public void xFullScreen(){
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


}
