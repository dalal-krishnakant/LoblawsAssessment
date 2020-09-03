package com.loblawsdigital.assessment.adapter.viewholder

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.loblawsdigital.assessment.R
import com.loblawsdigital.assessment.adapter.base.BaseRecyclerViewHolder
import com.loblawsdigital.assessment.datamodel.NewsItemDataModel

class TextNewsListViewHolder(parent: ViewGroup, layoutId: Int) : BaseRecyclerViewHolder<NewsItemDataModel>(parent, layoutId) {

    private lateinit var newsItemTitle: TextView

    override fun setupView(view: View) {
        newsItemTitle = itemView.findViewById<TextView>(R.id.news_item_title)
    }

    override fun onBind(item: NewsItemDataModel) {
        if (this::newsItemTitle.isInitialized) {
            newsItemTitle.text = item.data.newsTitle
        }
    }
}