package com.example.happybirthdaycard.affirmations

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @DrawableRes val affirmationImageResourceId: Int,
    @StringRes val affirmationStringResourceId: Int
)