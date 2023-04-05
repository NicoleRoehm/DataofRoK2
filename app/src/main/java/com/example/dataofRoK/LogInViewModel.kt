package com.example.dataofRoK

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


/**
 * Für Firebase, SHA1 Wert zu bekommen und in Terminal einfügen
 * >>keytool -alias androiddebugkey -keystore ~/.android/debug.keystore -list -v -storepass android<<

 */

class LogInViewModel:ViewModel (){

   private val firebaseAuth = FirebaseAuth.getInstance()


   private val _currentUser = MutableLiveData<FirebaseUser?>(firebaseAuth.currentUser)
    val currentUser : LiveData<FirebaseUser?>
    get() = _currentUser

    private val _toast = MutableLiveData<String?>()
    val toast : LiveData<String?>
    get() = _toast


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

}