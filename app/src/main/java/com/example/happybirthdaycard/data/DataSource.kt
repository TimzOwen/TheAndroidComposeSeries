package com.example.happybirthdaycard.data

import com.example.happybirthdaycard.R

class DataSource {

    fun loadCourses(): List<Course> {
        return listOf(
            Course(courseNameResourceId = R.string.architecture, numberOfAssociatedCourses = 58, courseImageResourceId = R.drawable.architecture),
            Course(courseNameResourceId =R.string.crafts, numberOfAssociatedCourses =121,courseImageResourceId = R.drawable.crafts),
            Course(courseNameResourceId =R.string.business,numberOfAssociatedCourses = 78,courseImageResourceId = R.drawable.business),
            Course(courseNameResourceId =R.string.culinary,numberOfAssociatedCourses = 118,courseImageResourceId = R.drawable.culinary),
            Course(courseNameResourceId =R.string.design,numberOfAssociatedCourses = 423,courseImageResourceId = R.drawable.design),
            Course(courseNameResourceId =R.string.fashion,numberOfAssociatedCourses = 92,courseImageResourceId = R.drawable.fashion),
            Course(courseNameResourceId =R.string.film, numberOfAssociatedCourses =165, courseImageResourceId =R.drawable.film),
            Course(courseNameResourceId =R.string.gaming,numberOfAssociatedCourses = 164,courseImageResourceId = R.drawable.gaming),
            Course(courseNameResourceId =R.string.drawing,numberOfAssociatedCourses = 326,courseImageResourceId = R.drawable.drawing),
            Course(courseNameResourceId =R.string.lifestyle,numberOfAssociatedCourses = 305, courseImageResourceId =R.drawable.lifestyle),
            Course(courseNameResourceId =R.string.music, numberOfAssociatedCourses =212, courseImageResourceId =R.drawable.music),
            Course(courseNameResourceId =R.string.painting, numberOfAssociatedCourses =172,courseImageResourceId = R.drawable.painting),
            Course(courseNameResourceId =R.string.photography,numberOfAssociatedCourses = 321,courseImageResourceId = R.drawable.photography),
            Course(courseNameResourceId =R.string.tech, numberOfAssociatedCourses =118, courseImageResourceId =R.drawable.tech),
            Course(courseNameResourceId = R.string.architecture, numberOfAssociatedCourses = 58, courseImageResourceId = R.drawable.architecture),
            Course(courseNameResourceId =R.string.crafts, numberOfAssociatedCourses =121,courseImageResourceId = R.drawable.crafts),
            Course(courseNameResourceId =R.string.business,numberOfAssociatedCourses = 78,courseImageResourceId = R.drawable.business),
            Course(courseNameResourceId =R.string.culinary,numberOfAssociatedCourses = 118,courseImageResourceId = R.drawable.culinary),
            Course(courseNameResourceId =R.string.design,numberOfAssociatedCourses = 423,courseImageResourceId = R.drawable.design),
            Course(courseNameResourceId =R.string.fashion,numberOfAssociatedCourses = 92,courseImageResourceId = R.drawable.fashion),
            Course(courseNameResourceId =R.string.film, numberOfAssociatedCourses =165, courseImageResourceId =R.drawable.film),
            Course(courseNameResourceId =R.string.gaming,numberOfAssociatedCourses = 164,courseImageResourceId = R.drawable.gaming),
            Course(courseNameResourceId =R.string.drawing,numberOfAssociatedCourses = 326,courseImageResourceId = R.drawable.drawing),
            Course(courseNameResourceId =R.string.lifestyle,numberOfAssociatedCourses = 305, courseImageResourceId =R.drawable.lifestyle),
            Course(courseNameResourceId =R.string.music, numberOfAssociatedCourses =212, courseImageResourceId =R.drawable.music),
            Course(courseNameResourceId =R.string.painting, numberOfAssociatedCourses =172,courseImageResourceId = R.drawable.painting),
            Course(courseNameResourceId =R.string.photography,numberOfAssociatedCourses = 321,courseImageResourceId = R.drawable.photography),
            Course(courseNameResourceId =R.string.tech, numberOfAssociatedCourses =118, courseImageResourceId =R.drawable.tech)
        )
    }
}