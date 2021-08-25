package com.example.registration

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CoursesAdapter (var courseList:List<courses>,var context: Context): RecyclerView.Adapter<CourseViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
            var itemView=LayoutInflater.from(parent.context).inflate(R.layout.course_list_items,parent,false)
            return CourseViewHolder(itemView)

        }

        override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
            var currentCourse=courseList.get(position)
            holder.name.text=currentCourse.CourseName
            holder.description.text=currentCourse.Description
            holder.id.text=currentCourse.CourseCode
            holder.trainer.text=currentCourse.Trainer
        }

        override fun getItemCount(): Int {
            return courseList.size
        }


    }
    class CourseViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var name=itemView.findViewById<TextView>(R.id.tvCourseName)
        var description=itemView.findViewById<TextView>(R.id.tvCourseName)
        var trainer=itemView.findViewById<TextView>(R.id.tvTrainer)
        var id=itemView.findViewById<TextView>(R.id.tvCourseCode)



    }
