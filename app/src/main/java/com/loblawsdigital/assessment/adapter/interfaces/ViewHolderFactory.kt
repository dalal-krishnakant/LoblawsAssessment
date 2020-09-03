package com.loblawsdigital.assessment.adapter.interfaces

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface ViewHolderFactory {

    fun getViewHolderForType(parent: ViewGroup, viewHolderType: Int): RecyclerView.ViewHolder?
}