package com.example.webview

import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    // this require api line of code because if u get any error then press alt+enter
    // and if u get any option of apirequire  then click it.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val webViewWidget = findViewById<WebView>(R.id.webView)
        //  webViewWidget variable name
        //  <WebView> it a type
        //  (R.id.webView)id.webView is id name which we gave in xml file in webView code
        WebViewSetUp(webViewWidget) //this is a method
        // (webViewWidget) this is passing parameters in webViewSetUP method
    }

    @RequiresApi(Build.VERSION_CODES.O)
    //this line of code is because api requires which show error in setting. line of code
    private fun WebViewSetUp(a: WebView) {
//private function which name is WebViewSetUp
// a is parameter we can also give this name webViewWidget
        // u can give any parameter name u want
        // :WebView its a type type is basically a name of components,
        // like if we add button so its type is button same which u select from palate
        a.webViewClient = WebViewClient()
        //its a syntax we must open this WebViewClientmethod
        a.apply {//here we can apply some settings open js enabled or browsing or load url
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true //in safeBrowsingEnabled word it show error
// click on this error showing word press (alt+enter)
// open a box click first api requires option
            loadUrl("https://medlar.my.canva.site/midlar-restaurant")
//paste here any website link which u want to change into app
        }
    }

}