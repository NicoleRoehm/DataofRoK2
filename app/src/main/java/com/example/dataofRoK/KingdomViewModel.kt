package com.example.dataofRoK

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dataofRoK.data.Repository
import com.example.dataofRoK.data.model.Kingdoms

class KingdomViewModel : ViewModel() {

    private val repository = Repository()

    private val _kingdoms = MutableLiveData<List<Kingdoms>>()
    val kingdoms : LiveData<List<Kingdoms>>
        get() = _kingdoms

    init {
        _kingdoms.value = repository.loadKingdoms()
    }

}