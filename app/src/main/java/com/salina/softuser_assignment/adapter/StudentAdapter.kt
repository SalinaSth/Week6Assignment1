package com.salina.softuser_assignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.salina.softuser_assignment.R
import com.salina.softuser_assignment.model.Student
import de.hdodenhof.circleimageview.CircleImageView

class StudentAdapter(
    val lstStudent: ArrayList<Student>,
    val context: Context
):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgProfile: CircleImageView
        val tvFullname:TextView
        val tvAge:TextView
        val tvGender:TextView
        val tvAddress:TextView
        val btnDelete: ImageView
        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvFullname = view.findViewById(R.id.tvFullname)
            tvAge = view.findViewById(R.id.tvAge)
            tvGender = view.findViewById(R.id.tvGender)
            tvAddress = view.findViewById(R.id.tvAddress)
            btnDelete = view.findViewById(R.id.btnDelete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lstStudent.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = lstStudent[position]
        holder.tvFullname.text = student.studentName
        holder.tvAddress.text = student.studentAddress
        holder.tvAge.text = student.studentAge.toString()
        holder.tvGender.text = student.studentGender

        Glide.with(this.context!!)
            .load(student.studentImg)
            .into(holder.imgProfile)

        holder.btnDelete.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                lstStudent.removeAt(position)
                notifyDataSetChanged()

            }

        } )
    }
}