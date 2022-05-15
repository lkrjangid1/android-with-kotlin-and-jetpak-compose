package com.example.viewmodalscopeandroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.viewmodalscopeandroid.modal.User
import com.example.viewmodalscopeandroid.modal.UserRepo
import kotlinx.coroutines.Dispatchers.IO
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers.IO
//import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModal:ViewModel() {
    private val userRepo: UserRepo = UserRepo()

    var users = liveData(IO) {
        emit(userRepo.getUsers())
    }





    /*var users: MutableLiveData<List<User>> = MutableLiveData()*/

//    private val myJob = Job()
//    private val myScope = CoroutineScope(IO + myJob)

   /* fun getUserData() {
        viewModelScope.launch {
            var result : List<User>? = null
            withContext(IO) {
                result = userRepo.getUsers()
            }
            users.value = result!!
        }
    } */

//    override fun onCleared() { // ctrl + o to override
//        super.onCleared()
//        myJob.cancel()
//    }

}
