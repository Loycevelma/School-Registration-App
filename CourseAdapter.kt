package com.example.registration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class CourseAdapter( var CourseList:List<courses>): RecyclerView.Adapter<CoursesViewHolder>() {
    class RecyclerView {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_list_items, parent, false)
        return CoursesViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {//function on display
       var currentCourse=CourseList.get(position)//Reference
        holder.tvCourseName.text=currentCourse.CourseName
        holder.tvCourseCode.text=currentCourse.CourseCode
        holder.tvDescription.text=currentCourse.Description
        holder.tvTrainer.text=currentCourse.Trainer


    }

    override fun getItemCount(): Int {
       return CourseList.size

    }//size of the list.
}
class CoursesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    var tvCourseName = itemView.findViewById<TextView>(R.id.tvCourseName)
    var tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
    var tvCourseCode = itemView.findViewById<TextView>(R.id.tvCourseCode)
    var tvTrainer = itemView.findViewById<TextView>(R.id.tvTrainer)



}

