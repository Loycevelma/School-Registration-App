package com.example.registration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CoursesResponseActivity( var coursesResponseList:List<CoursesResponse>):
    CourseAdapter.RecyclerView.Adapter<coursesResponseViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): coursesResponseViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.course_list_items,parent,false)
        return  coursesResponseViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: coursesResponseViewHolder, position: Int) {
        var currentCourse=coursesResponseList.get(position)
        holder.tvdatecreated.text=currentCourse.dateCreated
        holder.tvdateupdate.text=currentCourse.dateUpdated
        holder.tvcreator.text=currentCourse.createdBy
        holder.tvupdator.text=currentCourse.updatedBy
        holder.tvcourseId.text=currentCourse.courseId
        holder.tvcourseName.text=currentCourse.courseName
        holder.tvdescription.text=currentCourse.description
        holder.tvinstructor.text=currentCourse.courseInstructor
    }

    override fun getItemCount(): Int {
        return coursesResponseList.count()
    }
}
class coursesResponseViewHolder(itemView: View): CourseAdapter.RecyclerView.ViewHolder(itemView){
    var tvdatecreated=itemView.findViewById<TextView>(R.id.tvDateCreated)
    var tvdateupdate=itemView.findViewById<TextView>(R.id.tvDateUdated)
    var tvcreator=itemView.findViewById<TextView>(R.id.tvCreatedBy)
    var tvupdator=itemView.findViewById<TextView>(R.id.tvUpdatedBY)
    var tvcourseId=itemView.findViewById<TextView>(R.id.tvCoursesId)
    var tvcourseName=itemView.findViewById<TextView>(R.id.tvCourseName)
    var tvdescription=itemView.findViewById<TextView>(R.id.tvDescriptions)
    var tvinstructor=itemView.findViewById<TextView>(R.id.tvInsructor)
}


