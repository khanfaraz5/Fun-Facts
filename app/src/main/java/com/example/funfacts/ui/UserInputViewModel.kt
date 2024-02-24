package com.example.funfacts.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.funfacts.data.UserDataUiEvents
import com.example.funfacts.data.UserInputScreenState

class UserInputViewModel:ViewModel() {

    private companion object{
        const val TAG = "UserInputViewModel"
    }
    var uiState = mutableStateOf(UserInputScreenState())

   // triggered when any name is entered or animal is selected
    fun onEvent(event: UserDataUiEvents){
        when(event){
            is UserDataUiEvents.UserNameEntered->{
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
                Log.d(TAG , "onEvent:UserNameEntered->>")
                Log.d(TAG , "${uiState.value}")
            }
            is UserDataUiEvents.AnimalSelected->{
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalValue
                )
                Log.d(TAG , "onEvent:AnimalSelected->>")
                Log.d(TAG , "${uiState.value}")
            }
        }
    }

    fun isValidState(): Boolean{
        return !uiState.value.nameEntered.isNullOrEmpty() && !uiState.value.animalSelected.isNullOrEmpty()
    }
}




