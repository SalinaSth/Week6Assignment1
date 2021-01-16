package com.salina.softuser_assignment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.salina.softuser_assignment.BottomNavActivity
import com.salina.softuser_assignment.BottomNavActivity.Companion.lstStudent
import com.salina.softuser_assignment.R
import com.salina.softuser_assignment.adapter.StudentAdapter


class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)

        val adapter = StudentAdapter(BottomNavActivity.lstStudent, this.context!!)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = adapter
        return view
    }

}