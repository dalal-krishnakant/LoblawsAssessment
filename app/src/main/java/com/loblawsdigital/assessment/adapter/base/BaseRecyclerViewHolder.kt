package com.loblawsdigital.assessment.adapter.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.loblawsdigital.assessment.adapter.interfaces.ViewHolderItemClickListener

abstract class BaseRecyclerViewHolder<T>(parent: ViewGroup, layoutId: Int) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutId, parent, false)),
    View.OnClickListener {

    private var item: T? = null

    init {
        this.setupView(itemView)
    }

    var clickListener: ViewHolderItemClickListener? = null
        set(value) {
            itemView.setOnClickListener(this)
            field = value
        }

    override fun onClick(view: View) {
        clickListener?.onViewHolderItemClick(this, view)
    }

    fun bind(item: T) {
        this.item = item
        onBind(item)
    }

    protected abstract fun setupView(view: View)

    protected abstract fun onBind(item: T)
}