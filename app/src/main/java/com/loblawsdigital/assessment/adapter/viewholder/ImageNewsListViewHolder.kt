package com.loblawsdigital.assessment.adapter.viewholder

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.loblawsdigital.assessment.R
import com.loblawsdigital.assessment.adapter.base.BaseRecyclerViewHolder
import com.loblawsdigital.assessment.datamodel.NewsItemDataModel

class ImageNewsListViewHolder(parent: ViewGroup, layoutId: Int) : BaseRecyclerViewHolder<NewsItemDataModel>(parent, layoutId) {

    private lateinit var newsItemTitle: TextView
    private lateinit var newsItemImage: ImageView

    override fun setupView(view: View) {
        newsItemTitle = itemView.findViewById(R.id.news_item_title)
        newsItemImage = itemView.findViewById(R.id.news_item_image)
    }

    override fun onBind(item: NewsItemDataModel) {
        if (this::newsItemTitle.isInitialized) {
            newsItemTitle.text = item.data.newsTitle
        }

        if (this::newsItemImage.isInitialized) {
            val imageUrl =
                item.data.secureMedia?.oembed?.thumbnailUrl ?: "https://i.stack.imgur.com/VW0Qz.png"

            imageUrl?.let {
                Glide.with(newsItemImage.context)
                    .load(imageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .dontAnimate()
                    .into(newsItemImage)
            }
        }
    }
}