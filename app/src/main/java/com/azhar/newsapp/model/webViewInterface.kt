package com.azhar.newsapp.model

import android.webkit.WebView
import android.widget.ProgressBar

interface webViewInterface {

    fun setupWebView(webView: WebView, url: String, progressBar: ProgressBar, strNewsURL: String?)

}