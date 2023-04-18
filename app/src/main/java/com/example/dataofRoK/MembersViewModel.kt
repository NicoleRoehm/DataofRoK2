package com.example.dataofRoK

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dataofRoK.data.model.Members
import com.example.dataofRoK.data.remote.GotApi
import com.example.dataofRoK.data.remote.MembersRepository
import kotlinx.coroutines.launch

class MembersViewModel : ViewModel() {

    private val repository = MembersRepository(GotApi)

    val members: LiveData<List<Members>> = repository.members

    init {
        loadMembers()
    }

    private fun loadMembers() {

        viewModelScope.launch {
            repository.loadMembers()
        }
    }

    fun loadProfil(id: Long): Members {

        if (!(id == (-1).toLong())) {
            for (member in members.value!!) {

                if (member.Id == id) {

                    return member
                }

            }
        }
        return members.value!!.find { it ->
            it.Id == (53585738).toLong()
        }!!

    }
}