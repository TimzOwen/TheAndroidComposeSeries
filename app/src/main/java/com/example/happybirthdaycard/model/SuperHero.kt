package com.example.happybirthdaycard.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SuperHero(
    @StringRes
    var heroName: Int,
    var heroDescription: Int,
    @DrawableRes
    var hereImageRes: Int
)
