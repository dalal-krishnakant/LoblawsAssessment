package com.loblawsdigital.assessment

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.loblawsdigital.assessment.databinding.ActivityKotlinNewsBinding
import com.loblawsdigital.assessment.datamodel.LatestNewsDataModel
import com.loblawsdigital.assessment.network.FetchKotlinNewsRequest
import com.loblawsdigital.assessment.network.NetworkResponseListener
import com.loblawsdigital.assessment.utils.Constants
import com.loblawsdigital.assessment.viewmodel.LatestNewsViewModel

class KotlinNewsActivity : AppCompatActivity(), KotlinNewsListFragment.Listener, NetworkResponseListener {

    private var viewModel: LatestNewsViewModel? = null

    private lateinit var navigationController: NavController
    private lateinit var contentBinding: ActivityKotlinNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contentBinding = ActivityKotlinNewsBinding.inflate(layoutInflater)
        setContentView(contentBinding.root)

        setupLayout()
    }

    private fun setupLayout() {
        setSupportActionBar(contentBinding.toolbar)
        navigationController = Navigation.findNavController(this, R.id.nav_host_fragment)
        viewModel = ViewModelProvider(this).get(LatestNewsViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun fetchKotlinNewsList() {
        FetchKotlinNewsRequest(this).executeJsonObjRequest(
            Constants.fetchKotlinNewsRequest, getString(R.string.kotlin_news_request_url), this
        )
    }

    override fun responseSuccess(requestCode: Int, response: LatestNewsDataModel) {
        viewModel?.dataModel?.value = response
    }

    override fun responseError(requestCode: Int, errorResponse: String) {
        Snackbar.make(contentBinding.root, R.string.network_request_error_content, Snackbar.LENGTH_SHORT).show()
    }
}