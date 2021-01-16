package com.salina.softuser_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.salina.softuser_assignment.fragment.AboutUsFragment
import com.salina.softuser_assignment.fragment.AddStudentFragment
import com.salina.softuser_assignment.fragment.HomeFragment
import com.salina.softuser_assignment.model.Student

class BottomNavActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView
//    val selectedFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        bottomNav = findViewById(R.id.bottom_nav)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, HomeFragment())
            addToBackStack(null)
            commit()
            bottomNav.setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.nav_home -> {
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragment_container, HomeFragment())
                            addToBackStack(null)
                            commit()
                            return@setOnNavigationItemSelectedListener true
                        }

                    }
                    R.id.nav_add_student -> {
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragment_container, AddStudentFragment())
                            addToBackStack(null)
                            commit()
                            return@setOnNavigationItemSelectedListener true
                        }
                    }
                    R.id.nav_about -> {
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragment_container, AboutUsFragment())
                            addToBackStack(null)
                            commit()
                            return@setOnNavigationItemSelectedListener true
                        }
                    }
                }
                false
            }

        }
        loadStudent()
    }
    companion object{
        val lstStudent = arrayListOf<Student>()
    }
    private fun loadStudent(){
        lstStudent.add(
            Student("https://pyxis.nymag.com/v1/imgs/5d0/f76/76757fe4d67429ae87f807fabeab55eab2-20-timothee-chalamet.rsquare.w1200.jpg", "Tim Chalamet",
                24, "Male", "New York")
        )
    }
}