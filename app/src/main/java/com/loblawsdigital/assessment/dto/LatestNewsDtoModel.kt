package com.loblawsdigital.assessment.dto

import java.io.Serializable

data class LatestNewsDtoModel(var kind: String, var data: RootDto) : Serializable

data class RootDto(var modhash: String, var dist: Int, var children: ArrayList<NewsItemDto>) : Serializable

data class NewsItemDto(var kind: String, var data: NewsDataDto) : Serializable

data class NewsDataDto(var title: String, var url: String, var secure_media: SecureMediaDto) : Serializable

data class SecureMediaDto(var oembed: OembedDto) : Serializable

data class OembedDto(var thumbnail_url: String) : Serializable

