package com.loblawsdigital.assessment.adapter

import com.loblawsdigital.assessment.adapter.base.BaseRecyclerViewAdapter
import com.loblawsdigital.assessment.adapter.base.BaseRecyclerViewHolder
import com.loblawsdigital.assessment.adapter.interfaces.impl.ViewHolderFactoryImpl
import com.loblawsdigital.assessment.datamodel.NewsItemDataModel

class NewsListAdapter(private val newsItems: List<NewsItemDataModel>) : BaseRecyclerViewAdapter<NewsItemDataModel>(newsItems) {

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<NewsItemDataModel>, position: Int) {
        holder.bind(newsItems[position])
    }

    override fun getItemViewType(position: Int): Int {
        val imageUrl = newsItems[position].data.secureMedia?.oembed?.thumbnailUrl

        return if (imageUrl == null) {
            ViewHolderFactoryImpl.TYPE_TEXT_NEWS_VIEW_HOLDER
        } else {
            ViewHolderFactoryImpl.TYPE_IMAGE_NEWS_VIEW_HOLDER
        }
    }
}