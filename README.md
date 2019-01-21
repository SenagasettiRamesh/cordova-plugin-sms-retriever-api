# cordova-plugin-sms-retriever-api

<h3>How to install?</h3>
<p>cordova plugin add cordova-plugin-sms-retriever-api</p>

<h3>Description</h3>
<p>The cordova plugin for Android that integrates the Google's SMS retriever api to read SMS without asking READ_SMS permission. For more information click <a href='https://developers.google.com/identity/sms-retriever/overview' target='_blank'>here</a>.</p>

<h3>Usage</h3>
<p>
<b>Javascript<br/>
var smsRetriever = window.cordova && window.cordova.plugin && window.cordova.plugin.smsretiever;</b>
<p>
 <b>if(typeof smsRetriever !== 'undefined') </b>{<br/>
 &nbsp;&nbsp;&nbsp;&nbsp;<b>smsRetriever.startSmsRetriever(function(message){ </b><br/> <br/>                      
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//you receive the SMS here, if you construct it at backend as per the <a href='https://developers.google.com/identity/sms-retriever/verify' target='_blank'>instructions</a>   <br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// Now you can take the verification code from the message and attach it to the input box in your convinient way.  <br/><br/>
 &nbsp;&nbsp;&nbsp;&nbsp;<b>},function(errMsg){</b>                         <br/>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>if(errMsg === 'Timed out'){</b><br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//Play services unable to retrieve the SMS to your app for one of these reasons<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//1. SMS received but not constructed properly (Something wrong in your App's hashstring<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//2. SMS not received from last 5 minutes.<br/><br/>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>}else{</b><br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//Failed to start retriever listner<br/><br/>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>}</b>                    <br/>
 &nbsp;&nbsp;&nbsp;&nbsp;<b>});</b><br/>
 <b>}</b> 
 </p>
</p>

<h3>Note</h3>
<p>You need to be cautious while generating the hashstring for your application as keytool generate the hashstring even your command has some invalid values<br/>
  <p>
    The invalid values can be aliasname/keystorename/packagename.
  </p>
</p>
