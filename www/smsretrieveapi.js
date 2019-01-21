var exec = require("cordova/exec");

module.exports = {
    startSmsRetriever: function(onSuccess, onError) {
        exec(onSuccess, onError, 'SMSRetrieverAPI', "startRetriever", []);
    }
};
