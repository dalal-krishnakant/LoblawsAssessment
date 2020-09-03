package com.loblawsdigital.assessment.adapter.interfaces.impl

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.loblawsdigital.assessment.R
import com.loblawsdigital.assessment.adapter.interfaces.ViewHolderFactory
import com.loblawsdigital.assessment.adapter.viewholder.ImageNewsListViewHolder
import com.loblawsdigital.assessment.adapter.viewholder.TextNewsListViewHolder

class ViewHolderFactoryImpl : ViewHolderFactory {

    override fun getViewHolderForType(parent: ViewGroup, viewHolderType: Int): RecyclerView.ViewHolder? {
        when (viewHolderType) {
            TYPE_IMAGE_NEWS_VIEW_HOLDER -> return ImageNewsListViewHolder(
                parent,
                R.layout.view_holder_image_news_view
            )
            TYPE_TEXT_NEWS_VIEW_HOLDER -> return TextNewsListViewHolder(
                parent,
                R.layout.view_holder_text_news_view
            )
        }
        return null
    }

    companion object {
        const val TYPE_IMAGE_NEWS_VIEW_HOLDER = 101
        const val TYPE_TEXT_NEWS_VIEW_HOLDER = 102
    }
}