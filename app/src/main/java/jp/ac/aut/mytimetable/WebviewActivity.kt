package jp.ac.aut.mytimetable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        val webview = findViewById<WebView>(R.id.webview)
        webview.settings.javaScriptEnabled = true
        var url : String? = intent.getStringExtra("URL")
        webview.loadUrl(url!!)
    }
}