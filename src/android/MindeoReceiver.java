package com.mindeo.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.util.Log;

public class MindeoReceiver extends BroadcastReceiver
{
    private CallbackContext callbackContext;

    public MindeoReceiver (CallbackContext callbackContext) {
        Log.d("AA","--------------------------------------------------------------------------------------");
        this.callbackContext = callbackContext;
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.d("AA","intent.getStringExtra();-------------------------------------------------------------");
        String barcode = intent.getStringExtra("EXTRA_SCAN_DATA");
        Log.d("AA",barcode);
        Log.d("AA","intent.getStringExtra();-------------------------------------------------------------");
     
        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, barcode);

        pluginResult.setKeepCallback(true);
        callbackContext.sendPluginResult(pluginResult);

        //callbackContext.success(barcode);
    }
}