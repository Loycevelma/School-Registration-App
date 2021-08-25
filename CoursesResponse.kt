package com.example.registration

data class CoursesResponse(
    val dateCreated:String,
    val dateUpdated:String,
    val createdBy:String,
    val updatedBy:String,
    val courseId:String,
    val courseName:String,
    val description:String,
    val courseInstructor:String,
)
