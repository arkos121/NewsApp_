package com.azhar.newsapp.model

import android.webkit.WebView
import android.widget.ProgressBar
import javax.inject.Inject

class WebViewManager @Inject constructor(private var al : webViewInterface ) {

    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar
    private lateinit var url: String

    fun setWeb(strNewsURL: String?) {
        al.setupWebView(webView, url ,progressBar,strNewsURL)
    }

    }