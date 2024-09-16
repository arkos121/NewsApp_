package com.azhar.newsapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.azhar.newsapp.databinding.ActivityDetailNewsBinding
import com.azhar.newsapp.model.ModelArticle
import com.azhar.newsapp.model.WebViewManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by Azhar Rivaldi on 10-04-2021
 * Github : https://github.com/AzharRivaldi
 * Linkedin : https://www.linkedin.com/in/azhar-rivaldi
 * Instagram : https://www.instagram.com/azhardvls_
 * Twitter : https://twitter.com/azharrvldi_
 * Youtube Channel : https://bit.ly/2PJMowZ
 */
@AndroidEntryPoint
class DetailNewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailNewsBinding
    private lateinit var modelArticle : ModelArticle
    @Inject
    lateinit var webViewManager : WebViewManager
    companion object {
        const val DETAIL_NEWS = "DETAIL_NEWS"
    }

    var strNewsURL: String? = null
    var strTitle: String? = null
    var strSubTitle: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        assert(supportActionBar != null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.progressBar.max = 100

//        //get data intent
//        modelArticle = intent.getParcelableExtra(DETAIL_NEWS)!!

        if (modelArticle != null) {

            strNewsURL = modelArticle?.url
            strTitle = modelArticle?.title
            strSubTitle = modelArticle?.url

            binding.tvTitle.text = strTitle
            binding.tvSubTitle.text = strSubTitle

            //share news
            binding.imageShare.setOnClickListener {
                val share = Intent(Intent.ACTION_SEND)
                share.type = "text/plain"
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
                share.putExtra(Intent.EXTRA_TEXT, strNewsURL)
                startActivity(Intent.createChooser(share, "Bagikan ke : "))
            }

            //show news
            showWebView(strNewsURL)
        }
    }

//    private fun showWebView() {
//        binding.webView.settings.loadsImagesAutomatically = true
//        binding.webView.settings.javaScriptEnabled = true
//        binding.webView.settings.domStorageEnabled = true
//        binding.webView.settings.setSupportZoom(true)
//        binding.webView.settings.builtInZoomControls = true
//        binding.webView.settings.displayZoomControls = false
//        binding.webView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
//        binding.webView.loadUrl(strNewsURL!!)
//
//        binding.progressBar.progress = 0
//
//        binding.webView.webViewClient = object : WebViewClient() {
//            override fun shouldOverrideUrlLoading(view: WebView, newUrl: String): Boolean {
//                view.loadUrl(newUrl)
//                binding.progressBar.progress = 0
//                return true
//            }
//
//            override fun onPageStarted(view: WebView, urlStart: String, favicon: Bitmap) {
//                strNewsURL = urlStart
//                invalidateOptionsMenu()
//            }
//
//            override fun onPageFinished(view: WebView, urlPage: String) {
//                binding.progressBar.visibility = View.GONE
//                invalidateOptionsMenu()
//            }
//        }
//    }
private fun showWebView(strNewsURL: String?) {
    webViewManager.setWeb(strNewsURL);

}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}