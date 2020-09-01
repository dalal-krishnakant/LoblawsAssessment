package com.loblawsdigital.assessment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.loblawsdigital.assessment.dto.LatestNewsDtoModel

class LatestNewsViewModel() : ViewModel() {

    var dataModel: MutableLiveData<LatestNewsDtoModel> = MutableLiveData()
}