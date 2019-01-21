package com.cordova.plugin.android.smsretriever;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
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
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;

import android.support.annotation.NonNull;

public class smsretrieverapi extends CordovaPlugin {
  
  static CallbackContext staticCallbackContext = null; 
  private SmsRetrieverClient client;
  private Context appContext;
  public static CallbackContext getCallBackContext( ){
    return staticCallbackContext;
  }
  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {        
    super.initialize(cordova, webView);
    appContext = this.cordova.getActivity().getApplicationContext();
    client = SmsRetriever.getClient(appContext);
    // Toast.makeText(appContext,"SmsRetriever: initialization", Toast.LENGTH_LONG).show();
    new smsreceiverapi();
  }
  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
      if("startRetriever".equals(action)) {   
          // Toast.makeText(appContext,"startRetriever invoked", Toast.LENGTH_LONG).show();
          Task<Void> task = client.startSmsRetriever();
          task.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
              // Toast.makeText(appContext,"Listener Success", Toast.LENGTH_LONG).show();
              if(callbackContext != null) {                  
                staticCallbackContext = callbackContext;                  
                // Toast.makeText(appContext,"Context stored!", Toast.LENGTH_LONG).show();                
              }

            }
          });
          task.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {              
              // Toast.makeText(appContext,"Listener Failure", Toast.LENGTH_LONG).show();
              callbackContext.error("Failed to start retriever");              
            }
          });          
      }      
      return true;
  }    
  
}
