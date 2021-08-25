package com.example.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class CoursesActivity : AppCompatActivity() {
    lateinit var rvCourses: CourseAdapter.RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
    }


    }

    fun displayCourses(baseContext: Any) {
        var CourseList = listOf(
            courses("IOT", "UTEN674M", "IOT for 21st Centuary", "Barre Yassin"),
            courses("Kotlin", "67NDFSR2", "Android Development", "John Owuor"),
            courses("Javascript", "JH9834N", "Frontend Development", "Purity Maina"),
            courses("Python", "RE3628J", "Backend Development", "Mwai James")
        )
        var rvCourses = findViewById()
        var courses = CourseAdapter(CourseList)
        rvCourses.apply {


            var layoutManager = LinearLayoutManager(baseContext)

            rvCourses. adapter = courses
        }
    }

fun findViewById() {}





class LinearLayoutManager(baseContext: Any) {

}
