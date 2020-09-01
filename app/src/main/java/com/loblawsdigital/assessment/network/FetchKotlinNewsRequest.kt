package com.loblawsdigital.assessment.network

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.google.gson.Gson
import com.loblawsdigital.assessment.dto.LatestNewsDtoModel
import com.loblawsdigital.assessment.utils.CustomProgressDialog

class FetchKotlinNewsRequest(private val context: Context) {

    private val requestTag = FetchKotlinNewsRequest::class.java.simpleName

    fun executeJsonObjRequest(requestCode: Int, networkUrl: String, listener: NetworkResponseListener) {
        getCustomLoader().showAlertDialog()

        val jsonObjReq = JsonObjectRequest(
            Request.Method.GET, networkUrl, null,
            Response.Listener { response ->
                getCustomLoader().dismissAlertDialog()
                var responseModel = Gson().fromJson(response.toString(), LatestNewsDtoModel::class.java)
                listener.responseSuccess(requestCode, responseModel)
            },
            Response.ErrorListener { error ->
                getCustomLoader().dismissAlertDialog()
                listener.responseError(requestCode, error.toString())
            })
        ConnectionManager.getInstance(context).addToRequestQueue(jsonObjReq, requestTag)
    }

    private fun getCustomLoader(): CustomProgressDialog {
        return CustomProgressDialog.getInstance(context)
    }

}