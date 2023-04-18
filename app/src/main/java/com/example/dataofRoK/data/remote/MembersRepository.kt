package com.example.dataofRoK.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dataofRoK.data.model.Members

class MembersRepository ( private val api: GotApi) {

    private val  _members = MutableLiveData<List<Members>>()
    val members: LiveData<List<Members>>
        get() = _members

    suspend fun loadMembers(){

        Log.d("LoadMembers Repro",members.value.toString())

        _members.value = api.retrofitService.getMembers()

        Log.d("LoadMembers Repro",members.value.toString())
    }
}