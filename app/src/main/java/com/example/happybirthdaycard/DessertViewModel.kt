package com.example.happybirthdaycard

import androidx.lifecycle.ViewModel
import com.example.happybirthdaycard.data.Datasource.dessertList
import com.example.happybirthdaycard.data.DessertUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel: ViewModel() {
    private val _dessertUiSate = MutableStateFlow(DessertUiState())
    val dessertUiState: StateFlow<DessertUiState> = _dessertUiSate.asStateFlow()


    fun onDessertClicked(){
        _dessertUiSate.update { currentUiState ->
            val dessertSold = currentUiState.dessertsSold + 1
            val nextDessertIndex = determineDessertIndex(dessertSold)
            currentUiState.copy(
                currentDessertIndex = nextDessertIndex,
                revenue = currentUiState.revenue + currentUiState.currentDessertPrice,
                dessertsSold = dessertSold,
                currentDessertImageId = dessertList[nextDessertIndex].imageId,
                currentDessertPrice = dessertList[nextDessertIndex].price
            )
        }
    }

    fun determineDessertIndex(dessertSold: Int): Int{
        var dessertIndex = 0
        for (index in dessertList.indices){
            if (dessertSold >= dessertList[index].startProductionAmount){
                dessertIndex = index
            }else{
                break
            }
        }
        return dessertIndex
    }


}