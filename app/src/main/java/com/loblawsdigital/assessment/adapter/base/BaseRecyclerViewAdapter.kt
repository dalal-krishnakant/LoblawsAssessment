package com.loblawsdigital.assessment.adapter.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.loblawsdigital.assessment.adapter.interfaces.ViewHolderFactory
import com.loblawsdigital.assessment.adapter.interfaces.impl.ViewHolderFactoryImpl
import com.loblawsdigital.assessment.adapter.interfaces.ViewHolderItemClickListener

open class BaseRecyclerViewAdapter<T>(private val listItems: List<T>) :
    RecyclerView.Adapter<BaseRecyclerViewHolder<T>>() {

    var onItemClickListener : ViewHolderItemClickListener? = null

    private val viewHolderFactory: ViewHolderFactory

    init {
        viewHolderFactory =
            ViewHolderFactoryImpl()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder<T> {
        val holder = viewHolderFactory.getViewHolderForType(parent, viewType) as BaseRecyclerViewHolder<T>

        holder.let {
            apply {
                it.clickListener = onItemClickListener
            }
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<T>, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}