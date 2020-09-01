package com.loblawsdigital.assessment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

/**
 * [Fragment] subclass as the default destination in the navigation.
 */
class KotlinNewsListFragment : Fragment() {

    private var listener: Listener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_kotlin_news_list, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? Listener
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener?.fetchKotlinNewsList()
        onAttachViewModel()
    }

    private fun onAttachViewModel() {

    }

    interface Listener {
        /**
         * Listener to initiate network request to fetch latest news.
         */
        fun fetchKotlinNewsList()
    }
}