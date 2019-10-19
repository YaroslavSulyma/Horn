package com.example.horn.core

import android.content.Context
import android.opengl.Visibility
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.horn.MainActivity
import com.example.horn.NavigationRouter
import com.example.horn.R
import com.google.android.material.snackbar.Snackbar

open class FragmentBase : Fragment() {

    fun showSnackbar(layoutId: View, message: String, context: Context) {
        val snackbar = Snackbar.make(layoutId, message, Snackbar.LENGTH_SHORT)
        val sbView = snackbar.view
        val sbText = sbView.findViewById<TextView>(R.id.snackbar_text)
        sbView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorBackground))
        sbText.setTextColor(ContextCompat.getColor(context, R.color.colorLightOrange))
        snackbar.show()
    }

    fun getRouter(): NavigationRouter {
        return (activity as MainActivity).navigationRouter
    }

    fun hide(view:View){
        view.visibility = View.GONE
    }
    fun show(view:View){
        view.visibility = View.VISIBLE
    }

}