package com.salina.softuser_assignment.model

import androidx.lifecycle.ViewModel
import java.io.Serializable

data class Student(
    val studentImg:String,
    val studentName: String,
    val studentAge: Int,
    val studentGender: String,
    val studentAddress: String
): ViewModel(), Serializable {
    override fun toString(): String {
        return studentName
    }
}
