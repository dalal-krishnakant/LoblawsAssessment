package com.loblawsdigital.assessment.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.loblawsdigital.assessment.R

internal class CustomProgressDialog(private val context: Context) {

    private var alertDialog: AlertDialog? = null

    companion object {
        @Volatile
        private var customProgressDialog: CustomProgressDialog? = null

        fun getInstance(context: Context): CustomProgressDialog =
            customProgressDialog ?: synchronized(this) {
                customProgressDialog ?: CustomProgressDialog(context).also {
                    customProgressDialog = it
                }
            }
    }

    private fun prepareAlertDialog() {
        alertDialog = AlertDialog.Builder(context)
            .setCancelable(false)
            .setView(R.layout.layout_loading_dialog).create()
    }

    fun showAlertDialog() {
        if (alertDialog == null) {
            prepareAlertDialog()
        }
        alertDialog?.show();
    }

    fun dismissAlertDialog() {
        alertDialog?.dismiss()
    }
}