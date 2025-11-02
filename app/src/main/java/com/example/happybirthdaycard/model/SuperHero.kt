package com.example.happybirthdaycard.model

import androidx.annotation.DrawableRes

data class SuperHero(
    var heroName: Int,
    var heroDescription: Int,
    @DrawableRes
    var hereImageRes: Int
)
