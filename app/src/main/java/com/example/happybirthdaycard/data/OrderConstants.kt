package com.example.happybirthdaycard.data

import androidx.annotation.StringRes
import com.example.happybirthdaycard.R

/** Price for a single cupcake */
const val PRICE_PER_CUPCAKE = 2.00

/** Additional cost for same day pickup of an order */
const val PRICE_FOR_SAME_DAY_PICKUP = 3.00

enum class CupCakeScreen(@StringRes val title: Int){
    Start(title = R.string.app_name),
    Flavor(title = R.string.choose_flavor),
    Pickup(title = R.string.choose_pickup_date),
    Summary(title = R.string.order_summary)
}