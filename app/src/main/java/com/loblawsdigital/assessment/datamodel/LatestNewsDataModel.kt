package com.loblawsdigital.assessment.datamodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LatestNewsDataModel(
    var kind: String,
    @SerializedName("data") var dataModel: RootDataModel
) : Serializable

data class RootDataModel(
    var modhash: String,
    var dist: Int,
    @SerializedName("children") var newsItemList: ArrayList<NewsItemDataModel>
) : Serializable

data class NewsItemDataModel(var kind: String, var data: NewsData) : Serializable

data class NewsData(
    @SerializedName("title") var newsTitle: String,
    @SerializedName("url") var newsLinkUrl: String,
    @SerializedName("secure_media") var secureMedia: SecureMediaDataModel?
) : Serializable

data class SecureMediaDataModel(var oembed: OembedDataModel?) : Serializable

data class OembedDataModel(@SerializedName("thumbnail_url") var thumbnailUrl: String) : Serializable

