package com.azhar.newsapp.model

import android.content.Intent
import androidx.lifecycle.ViewModel

class VIewModel : ViewModel() {

    var strNewsURL: String? = null
    var strTitle: String? = null
    var strSubTitle: String? = null
    val share = Intent(Intent.ACTION_SEND)
    fun setNews(strTitle: String?, strSubTitle: String?, strNewsURL: String?) {
        this.strTitle = strTitle
        this.strSubTitle = strSubTitle
        this.strNewsURL = strNewsURL
        shareNews(strNewsURL)
    }

    fun shareNews(strNewsURL: String?) {
        share.type = "text/plain"
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
        share.putExtra(Intent.EXTRA_TEXT, strNewsURL)
    }


}