package com.azhar.newsapp.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject

/**
 * Created by Azhar Rivaldi on 10-04-2021
 * Github : https://github.com/AzharRivaldi
 * Linkedin : https://www.linkedin.com/in/azhar-rivaldi
 * Instagram : https://www.instagram.com/azhardvls_
 * Twitter : https://twitter.com/azharrvldi_
 * Youtube Channel : https://bit.ly/2PJMowZ
 */

data class ModelArticle (
        @SerializedName("source")
        var modelSource: ModelSource?,

        @SerializedName("author")
        var author: String = "",

        @SerializedName("title")
        var title: String = "",

        @SerializedName("description")
        var description: String = "",

        @SerializedName("url")
        var url: String = "",

        @SerializedName("urlToImage")
        var urlToImage: String = "",

        @SerializedName("publishedAt")
        var publishedAt: String = ""
) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readParcelable(ModelSource::class.java.classLoader),
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeParcelable(modelSource, flags)
                parcel.writeString(author)
                parcel.writeString(title)
                parcel.writeString(description)
                parcel.writeString(url)
                parcel.writeString(urlToImage)
                parcel.writeString(publishedAt)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<ModelArticle> {
                override fun createFromParcel(parcel: Parcel): ModelArticle {
                        return ModelArticle(parcel)
                }

                override fun newArray(size: Int): Array<ModelArticle?> {
                        return arrayOfNulls(size)
                }
        }
}

data class ModelSource(
        @SerializedName("id")
        val id: String? = "",

        @SerializedName("name")
        val name: String? = ""
) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(id)
                parcel.writeString(name)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<ModelSource> {
                override fun createFromParcel(parcel: Parcel): ModelSource {
                        return ModelSource(parcel)
                }

                override fun newArray(size: Int): Array<ModelSource?> {
                        return arrayOfNulls(size)
                }
        }
}
