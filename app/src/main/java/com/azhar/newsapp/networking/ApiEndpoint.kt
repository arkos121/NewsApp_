package com.azhar.newsapp.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Azhar Rivaldi on 10-04-2021
 * Github : https://github.com/AzharRivaldi
 * Linkedin : https://www.linkedin.com/in/azhar-rivaldi
 * Instagram : https://www.instagram.com/azhardvls_
 * Twitter : https://twitter.com/azharrvldi_
 * Youtube Channel : https://bit.ly/2PJMowZ
 */

object ApiEndpoint {

    const val BASE_URL = "https://newsapi.org/v2/"
//    const val BASE_URL="https://newsapi.org/v2/everything?q=tesla&from=2024-08-12&sortBy=publishedAt&apiKey=a50e64baeb734e69b1b9ade276cdb44b/"
    fun getApiClient(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}
