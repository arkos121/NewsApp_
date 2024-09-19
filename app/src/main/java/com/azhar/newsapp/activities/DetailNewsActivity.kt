package com.azhar.newsapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.azhar.newsapp.databinding.ActivityDetailNewsBinding
import com.azhar.newsapp.model.ModelArticle
import com.azhar.newsapp.model.VIewModel
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
    lateinit var mvm : VIewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
      this.mvm = ViewModelProvider(this).get(VIewModel::class.java)
        setSupportActionBar(binding.toolbar)
        assert(supportActionBar != null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.progressBar.max = 100

//        //get data intent
//        modelArticle = intent.getParcelableExtra(DETAIL_NEWS)!!

        if (modelArticle != null) {

            mvm.setNews(modelArticle.title,"",modelArticle.url)
            binding.tvTitle.text = mvm.strTitle
            binding.tvSubTitle.text=mvm.strSubTitle

            //share news
            binding.imageShare.setOnClickListener {
                startActivity(Intent.createChooser(mvm.share, "Share to : "))
            }
            //show news
            showWebView(mvm.strNewsURL)
        }
    }

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