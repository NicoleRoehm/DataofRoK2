package com.example.dataofRoK

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dataofRoK.data.model.Members

class MembersViewModel : ViewModel() {

    private var _members = MutableLiveData<List<Members>>()
       val members:  LiveData<List<Members>>
       get() = _members

    fun getMembers(){


    }
}