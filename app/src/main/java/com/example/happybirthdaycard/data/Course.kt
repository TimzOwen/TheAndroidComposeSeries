package com.example.happybirthdaycard.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course(
    @StringRes val courseNameResourceId: Int,
    @DrawableRes val courseImageResourceId: Int,
    val numberOfAssociatedCourses: Int
)
