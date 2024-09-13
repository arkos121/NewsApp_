package com.azhar.newsapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.azhar.newsapp.R
import com.azhar.newsapp.adapter.NewsAdapter
import com.azhar.newsapp.databinding.RagementNewsBinding
import com.azhar.newsapp.databinding.RagmentSearchBinding
import com.azhar.newsapp.model.ModelArticle
import com.azhar.newsapp.model.ModelNews
import com.azhar.newsapp.networking.ApiEndpoint.getApiClient
import com.azhar.newsapp.networking.ApiInterface
import com.azhar.newsapp.util.Utils.getCountry
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * Created by Azhar Rivaldi on 10-04-2021
 * Github : https://github.com/AzharRivaldi
 * Linkedin : https://www.linkedin.com/in/azhar-rivaldi
 * Instagram : https://www.instagram.com/azhardvls_
 * Twitter : https://twitter.com/azharrvldi_
 * Youtube Channel : https://bit.ly/2PJMowZ
 */

class FragmentSports : Fragment() {

    companion object {
        const val API_KEY = "a50e64baeb734e69b1b9ade276cdb44b"
    }

    var strCategory = "sports"
    var strCountry: String? = null
    var modelArticle: MutableList<ModelArticle> = ArrayList()
    var newsAdapter: NewsAdapter? = null
private lateinit var binding: RagementNewsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = RagementNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTitle.setText("Berita Olahraga")

        binding.rvListNews.setLayoutManager(LinearLayoutManager(context))
        binding.rvListNews.setHasFixedSize(true)
        binding.rvListNews.showShimmerAdapter()

        //reload news
        binding.imageRefresh.setOnClickListener {
            binding.rvListNews.showShimmerAdapter()
            getListNews()
        }

        //get news
        getListNews()
    }

    //set api
    private fun getListNews() {

            //get country/
            strCountry = getCountry()

            //set api
            val apiInterface = getApiClient().create(ApiInterface::class.java)
            val call = apiInterface.getSports(strCountry, strCategory, API_KEY)
            call.enqueue(object : Callback<ModelNews> {
                override fun onResponse(call: Call<ModelNews>, response: Response<ModelNews>) {
                    if (response.isSuccessful && response.body() != null) {
                        modelArticle = response.body()?.modelArticle as MutableList<ModelArticle>
                        newsAdapter = NewsAdapter(modelArticle, context!!)
                        binding.rvListNews.adapter = newsAdapter
                        newsAdapter?.notifyDataSetChanged()
                        binding.rvListNews.hideShimmerAdapter()
                    }
                }

                override fun onFailure(call: Call<ModelNews>, t: Throwable) {
                    Toast.makeText(context, "Oops, jaringan kamu bermasalah.", Toast.LENGTH_SHORT).show()
                }
            })
        }

}