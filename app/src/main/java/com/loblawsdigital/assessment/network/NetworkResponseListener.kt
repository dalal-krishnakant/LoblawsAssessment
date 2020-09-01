package com.loblawsdigital.assessment.network

import com.loblawsdigital.assessment.dto.LatestNewsDtoModel

interface NetworkResponseListener {

    /**
     * Callback method for network response success.
     */
    fun responseSuccess(requestCode: Int, response: LatestNewsDtoModel)

    /**
     * Callback method for network response failure.
     */
    fun responseError(requestCode: Int, errorResponse: String)
}