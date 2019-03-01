package com.example.yinshengnan.suting_a.sn.showUtil;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;


public class DialogUtil {

    public ProgressDialog progressDialog;

    private Handler handler;

    private Context mContext;

    public DialogUtil(Context mContext){

    }

    public void showProgressDialog(Context context) {
        showProgressDialog(context,"等待加载");
    }

    public void showProgressDialog(Context context,final String msg)  {
        if(progressDialog == null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        progressDialog.setMessage(msg);
        progressDialog.show();
//
    }

    public void cancelProgressDialog() {
        if(progressDialog != null)
            progressDialog.cancel();
//
    }



}
