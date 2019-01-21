package com.cordova.plugin.android.smsretiever;
// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.CommonStatusCodes;


/**
 * BroadcastReceiver to wait for SMS messages. This can be registered either
 * in the AndroidManifest or at runtime.  Should filter Intents on
 * SmsRetriever.SMS_RETRIEVED_ACTION.
 */
public class smsreceiverapi extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {
    if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
      Bundle extras = intent.getExtras();
      Status status = (Status) extras.get(SmsRetriever.EXTRA_STATUS);
      switch(status.getStatusCode()) {
        case CommonStatusCodes.SUCCESS:                  
          String message = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);          
          smsretrieverapi.getCallBackContext().success(message);
          break;
        case CommonStatusCodes.TIMEOUT:          
          smsretrieverapi.getCallBackContext().error("Timed out");
          break;
        case CommonStatusCodes.DEVELOPER_ERROR:          
          smsretrieverapi.getCallBackContext().error("The caller app has incorrect number of certificates. Only one certificate is allowed");
          break;
        case CommonStatusCodes.ERROR:          
          smsretrieverapi.getCallBackContext().error("the AppCode collides with other installed apps");
          break;                    
      }
    }
  }
}
