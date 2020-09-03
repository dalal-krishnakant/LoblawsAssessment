package com.loblawsdigital.assessment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.loblawsdigital.assessment.datamodel.LatestNewsDataModel

class LatestNewsViewModel() : ViewModel() {

    var dataModel: MutableLiveData<LatestNewsDataModel> = MutableLiveData()
}