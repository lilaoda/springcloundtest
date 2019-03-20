function connectWebViewJavascriptBridge(callback) {
  if (window.WebViewJavascriptBridge) {
    callback(WebViewJavascriptBridge)
  } else {
    document.addEventListener(
      'WebViewJavascriptBridgeReady',
      function() {
        callback(WebViewJavascriptBridge)
      },
      false
    );
  }
}

connectWebViewJavascriptBridge(function(bridge) {
    bridge.init(function(message, responseCallback) {
        console.log('JS got a message', message);
        var data = {
            'Javascript Responds': '测试中文!'
        };
        console.log('JS responding with', data);
        responseCallback(data);
    });

    bridge.registerHandler("functionJs", function(data, responseCallback) {
//        document.getElementById("show").innerHTML = ("data from Java: = " + data);
        var responseData = "js已收到数据";
        responseCallback(responseData);
    });
})