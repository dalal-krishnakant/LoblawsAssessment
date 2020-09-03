package com.loblawsdigital.assessment.network

import com.loblawsdigital.assessment.datamodel.LatestNewsDataModel

interface NetworkResponseListener {

    /**
     * Callback method for network response success.
     */
    fun responseSuccess(requestCode: Int, response: LatestNewsDataModel)

    /**
     * Callback method for network response failure.
     */
    fun responseError(requestCode: Int, errorResponse: String)
}