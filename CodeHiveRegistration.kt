package com.example.registration

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registration.databinding.ActivityCodeHiveRegistrationBinding


class CodeHiveRegistration : AppCompatActivity() {
    lateinit var rvcourses: RecyclerView
    lateinit var binding: ActivityCodeHiveRegistrationBinding
    val courseViewModel: CoursesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCodeHiveRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayCourses()
    }
    fun displayCourses(){
        var courseList= listOf(
            courses("Android Development","TWU75","Kotlin/Native","John Owuor"),
            courses("Backend Development","378KD","Python/Django","James Mwai"),
            courses("UX Research","BVS563E","User-centered research","Joy Wambui"),
            courses("Professional Development","MDNJDU","Personal and career development","Rodgers Owoko"),
            courses("UI/UX Design","BVNDT5","Figma/Adobe","Eric Asiago"),
            courses("Frontend web Development","47838JD","HTML/CSS/Javascript","Purity Maina"),
            courses("IoT","CVDN9","Internet of Things","Sir Barre"),
        )
        rvcourses=findViewById(R.id.rvCourses)
        var CoursesAdapter= CoursesAdapter(baseContext,courseList)
        binding.rvCourses.apply {
            layoutManager= LinearLayoutManager(baseContext)
            binding.rvCourses.adapter=CoursesAdapter
        }
    }
    override fun onResume() {
        super.onResume()
        CoursesViewModel.CoursesResponseLIveData.observe(this, { courseResponse ->
            if (!courseResponse.courseId.isNullOrEmpty()) {
                Toast.makeText(baseContext, "Course added successfully", Toast.LENGTH_LONG).show()
            }
        })
        CoursesViewModel.CoursesErrorLiveData.observe(this, { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_SHORT).show()
        })
    }
}
