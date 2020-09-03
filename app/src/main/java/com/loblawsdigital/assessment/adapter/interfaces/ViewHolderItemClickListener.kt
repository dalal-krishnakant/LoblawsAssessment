package com.loblawsdigital.assessment.adapter.interfaces

import android.view.View
import com.loblawsdigital.assessment.adapter.base.BaseRecyclerViewHolder

interface ViewHolderItemClickListener {

    fun onViewHolderItemClick(holder: BaseRecyclerViewHolder<*>, view: View)
}