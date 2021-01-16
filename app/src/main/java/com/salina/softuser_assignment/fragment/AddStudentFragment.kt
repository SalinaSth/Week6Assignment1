package com.salina.softuser_assignment.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.salina.softuser_assignment.BottomNavActivity
import com.salina.softuser_assignment.R
import com.salina.softuser_assignment.model.Student

class AddStudentFragment : Fragment() {
    private lateinit var etImgUrl: EditText
    private lateinit var etFullname: EditText
    private lateinit var etAge: EditText
    private lateinit var etAddress: EditText
    private lateinit var rdoGrp: RadioGroup
    private lateinit var rbtnMale: RadioButton
    private lateinit var rbtnFemale: RadioButton
    private lateinit var rbtnOther: RadioButton
    private lateinit var btnSave: Button
    var gender = ""
    private var lstStudent = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_student, container, false)
        etImgUrl = view.findViewById(R.id.etImgUrl)
        etFullname = view.findViewById(R.id.etFullname)
        etAge = view.findViewById(R.id.etAge)
        etAddress = view.findViewById(R.id.etAddress)
        rdoGrp = view.findViewById(R.id.rdoGrp)
        rbtnMale = view.findViewById(R.id.rbtnMale)
        rbtnFemale = view.findViewById(R.id.rbtnFemale)
        rbtnOther = view.findViewById(R.id.rbtnOther)
        btnSave = view.findViewById(R.id.btnSave)

        btnSave.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                if (TextUtils.isEmpty(etFullname.text.toString())) {
                    etFullname.error = "Fullname is empty"
                    etFullname.requestFocus();
                } else if (TextUtils.isEmpty(etImgUrl.text.toString())) {
                    etAge.error = "Image url is empty"
                    etAge.requestFocus();
                }else if (TextUtils.isEmpty(etAge.text.toString())) {
                    etAge.error = "Age is empty"
                    etAge.requestFocus();
                } else if (TextUtils.isEmpty(etAddress.text.toString())) {
                    etAddress.error = "Address is empty"
                    etAddress.requestFocus();
                } else if (!rbtnMale.isChecked && !rbtnFemale.isChecked && !rbtnOther.isChecked) {
                    Toast.makeText(context, "Select a Gender", Toast.LENGTH_SHORT).show();
                } else {
                    val imgProfile = etImgUrl.text.toString()
                    val fullname = etFullname.text.toString();
                    val address = etAddress.text.toString();
                    val age = etAge.text.toString();
                    when {
                        rbtnMale.isChecked -> {
                            gender="Male"
                        }
                        rbtnFemale.isChecked -> {
                            gender="Female"
                        }
                        rbtnOther.isChecked -> {
                            gender="Others"
                        }
                        else -> {
                            Toast.makeText(context, "Select a gender", Toast.LENGTH_SHORT).show();
                        }
                    }

                    BottomNavActivity.lstStudent.add(Student(imgProfile, fullname, age.toString().toInt(), gender, address))
                    Toast.makeText(context, "Student Added Successfully", Toast.LENGTH_SHORT).show();
                    clearTxt();
                }
            }
        })
        return view
    }

    private fun clearTxt() {
        etImgUrl.setText("")
        etFullname.setText("");
        etAge.setText("");
        etAddress.setText("");
        rbtnMale.isChecked = false;
        rbtnFemale.isChecked = false;
        rbtnFemale.isChecked = false;
    }
}