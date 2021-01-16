package com.salina.softuser_assignment.fragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.annotation.RequiresApi
import com.salina.softuser_assignment.R

class AboutUsFragment : Fragment() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about_us, container, false)
        webView = view.findViewById(R.id.webView)
        webView.settings.javaScriptEnabled
        webView.webViewClient
        webView.loadUrl("https://softwarica.edu.np/")
        return view
    }

}