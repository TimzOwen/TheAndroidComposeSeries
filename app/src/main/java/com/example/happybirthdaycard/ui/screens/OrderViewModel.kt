package com.example.happybirthdaycard.ui.screens

import androidx.lifecycle.ViewModel
import com.example.happybirthdaycard.data.OrderUiState
import com.example.happybirthdaycard.data.PRICE_FOR_SAME_DAY_PICKUP
import com.example.happybirthdaycard.data.PRICE_PER_CUPCAKE
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class OrderViewModel : ViewModel() {
    private val _orderUiState = MutableStateFlow(OrderUiState(pickUpOptions = pickUpOptions()))
    val orderUiState: StateFlow<OrderUiState> = _orderUiState.asStateFlow()

    fun setQuantity(numberOfCupcakes: Int){
        _orderUiState.update {
            it.copy(
                quantity = numberOfCupcakes,
                price = calculatePrice(quantity = numberOfCupcakes)
            )
        }
    }

    fun setFlavor(desiredFlavor: String){
        _orderUiState.update {
            it.copy(
                flavor = desiredFlavor
            )
        }
    }

    fun setDate(pickupDate: String) {
        _orderUiState.update { currentState ->
            currentState.copy(
                date = pickupDate,
                price = calculatePrice(pickupDate=pickupDate)
            )
        }
    }

    fun resetOrder() {
        _orderUiState.value = OrderUiState(pickUpOptions = pickUpOptions())
    }

    private fun calculatePrice(
        quantity: Int = _orderUiState.value.quantity,
        pickupDate: String = _orderUiState.value.date
    ): String {
        var calculatedPrice = quantity * PRICE_PER_CUPCAKE
        if (pickUpOptions()[0] == pickupDate) {
            calculatedPrice += PRICE_FOR_SAME_DAY_PICKUP
        }
        val formattedPrice = NumberFormat.getCurrencyInstance().format(calculatedPrice)
        return formattedPrice
    }

    private fun pickUpOptions(): List<String> {
        val dateOptions = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()

        repeat(4) {
            dateOptions.add(formatter.format(calendar))
            calendar.add(Calendar.DATE, 1)
        }
        return dateOptions
    }

}