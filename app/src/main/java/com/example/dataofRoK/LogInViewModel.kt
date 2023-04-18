package com.example.dataofRoK

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dataofRoK.data.model.Members
import com.example.dataofRoK.data.remote.GotApi
import com.example.dataofRoK.data.remote.MembersRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch


/**
 * Für Firebase, SHA1 Wert zu bekommen und in Terminal einfügen
 * >>keytool -alias androiddebugkey -keystore ~/.android/debug.keystore -list -v -storepass android<<

 */

class LogInViewModel:ViewModel (){

    private val repository = MembersRepository(GotApi)

    val members: LiveData<List<Members>> = repository.members

   private val firebaseAuth = FirebaseAuth.getInstance()


   private val _currentUser = MutableLiveData<FirebaseUser?>(firebaseAuth.currentUser)
    val currentUser : LiveData<FirebaseUser?>
    get() = _currentUser

    private val _toast = MutableLiveData<String?>()
    val toast : LiveData<String?>
    get() = _toast


    fun signUp(email: String, password: String){
        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    logIn(email,password)
                }
            }
    }
    fun logIn (email:String, password:String){

        firebaseAuth.signInWithEmailAndPassword(email, password)

            .addOnCompleteListener {

                if(it.isSuccessful){

                    _currentUser.value = firebaseAuth.currentUser
                }else{
                    Log.e(TAG, "Login failed: ${it.exception?.message}")
                    _toast.value = it.exception?.message
                    _toast.value = null
                }
            }
    }

    fun logOut (){

        firebaseAuth.signOut()
        _currentUser.value = firebaseAuth.currentUser
    }

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