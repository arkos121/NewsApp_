package com.azhar.newsapp.model

import android.graphics.Bitmap
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.core.app.ActivityCompat.invalidateOptionsMenu
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
class webViewInterfaceImpl : webViewInterface {
    private var k: String? = null
    override fun setupWebView(
        webView: WebView,
        url: String,
        progressBar: ProgressBar,
        strNewsURL: String?
    ) {

this.k = strNewsURL
        webView.settings.apply {
            loadsImagesAutomatically = true
            javaScriptEnabled = true
            domStorageEnabled = true
            setSupportZoom(true)
            builtInZoomControls = true
            displayZoomControls = false
        }
        webView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        webView.loadUrl(url)

        progressBar.progress = 0

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, newUrl: String): Boolean {
                view.loadUrl(newUrl)
                progressBar.progress = 0
                return true
            }

            override fun onPageStarted(view: WebView, urlStart: String, favicon: Bitmap?) {
                k = urlStart
            }

            override fun onPageFinished(view: WebView, urlPage: String) {
                progressBar.visibility = View.GONE

            }
        }
    }
}
