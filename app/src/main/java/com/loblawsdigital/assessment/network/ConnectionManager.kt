package com.loblawsdigital.assessment.network

import android.content.Context
import android.text.TextUtils
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

internal class ConnectionManager(private val context: Context) {

    private var mRequestQueue: RequestQueue? = null
    private val connectionManagerTag = ConnectionManager::class.java.simpleName

    companion object {
        @Volatile
        private var connectionManager: ConnectionManager? = null

        fun getInstance(context: Context): ConnectionManager =
            connectionManager ?: synchronized(this) {
                connectionManager ?: ConnectionManager(context.applicationContext).also { connectionManager = it }
            }
    }

    private val requestQueue: RequestQueue?
        get() {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(context)
            }
            return mRequestQueue
        }

    fun <T> addToRequestQueue(req: Request<T>, tag: String?) {
        // set the default tag if tag is empty
        req.tag = if (TextUtils.isEmpty(tag)) connectionManagerTag else tag
        requestQueue?.add(req)
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        req.tag = connectionManagerTag
        requestQueue?.add(req)
    }

    fun cancelPendingRequests(tag: Any?) {
        mRequestQueue?.cancelAll(tag)
    }
}