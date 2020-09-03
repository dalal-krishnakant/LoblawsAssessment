package com.loblawsdigital.assessment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.loblawsdigital.assessment.adapter.NewsListAdapter
import com.loblawsdigital.assessment.adapter.base.BaseRecyclerViewHolder
import com.loblawsdigital.assessment.adapter.interfaces.ViewHolderItemClickListener
import com.loblawsdigital.assessment.databinding.FragmentKotlinNewsListBinding
import com.loblawsdigital.assessment.datamodel.LatestNewsDataModel
import com.loblawsdigital.assessment.viewmodel.LatestNewsViewModel


class KotlinNewsListFragment : Fragment(), ViewHolderItemClickListener {

    private lateinit var contentBinding: FragmentKotlinNewsListBinding
    private lateinit var listRecyclerView: RecyclerView

    private var adapter: NewsListAdapter? = null
    private var listener: Listener? = null
    private var viewModel: LatestNewsViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        contentBinding = FragmentKotlinNewsListBinding.inflate(layoutInflater, container, false)
        return contentBinding.root
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

        listRecyclerView = contentBinding.listRecyclerView
        listRecyclerView.layoutManager = LinearLayoutManager(context)

        onAttachViewModel()
    }

    private fun onAttachViewModel() {
        viewModel = activity?.let { ViewModelProvider(it).get(LatestNewsViewModel::class.java) }

        viewModel?.let { viewModel ->
            viewModel.dataModel.observe(viewLifecycleOwner, Observer {
                it?.let { latestNewsModel ->
                    adapter = NewsListAdapter(latestNewsModel.dataModel.newsItemList)
                    listRecyclerView.adapter = adapter
                    adapter?.onItemClickListener = this
                }
            })
        }
    }

    override fun onViewHolderItemClick(holder: BaseRecyclerViewHolder<*>, view: View) {
        viewModel?.let {
            val newsDataModel :LatestNewsDataModel = it.dataModel.value as LatestNewsDataModel
            val newsItem = newsDataModel.dataModel.newsItemList[holder.adapterPosition]

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(newsItem.data.newsLinkUrl))
            startActivity(intent)
        }
    }

    interface Listener {
        /**
         * Listener to initiate network request to fetch latest news.
         */
        fun fetchKotlinNewsList()
    }
}