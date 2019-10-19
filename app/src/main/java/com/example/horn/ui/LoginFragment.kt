package com.example.horn.ui

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.method.MovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.horn.R
import com.example.horn.core.FragmentBase


class LoginFragment : FragmentBase() {

    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var title: TextView
    private lateinit var logo: ImageView
    private lateinit var phoneNumber: EditText
    private lateinit var fingerprintLogo: ImageView
    private lateinit var btnLogin: Button
    private lateinit var registerNow: TextView

    private val REGISTER_NOW_TEXT = "У вас нету аккаунта? Зарегестрироваться сейчас"
    private lateinit var spannableString: SpannableString
    private lateinit var clickableSpan: ClickableSpan

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        constraintLayout = view.findViewById(R.id.fragment_login_constraint_layout)
        title = view.findViewById(R.id.fragment_login_tv_title)
        logo = view.findViewById(R.id.fragment_login_iv_logo)
        phoneNumber = view.findViewById(R.id.fragment_login_et_phone)
        fingerprintLogo = view.findViewById(R.id.fragment_login_iv_fingerprint)
        btnLogin = view.findViewById(R.id.fragment_login_btn_login)
        registerNow = view.findViewById(R.id.fragment_login_tv_register_now)

        spannableString = SpannableString(REGISTER_NOW_TEXT)
        clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                getRouter().openRegistrationFragment()
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = resources.getColor(R.color.colorLightOrange)
                ds.isUnderlineText = false
                ds.clearShadowLayer()
            }
        }

        spannableString.setSpan(clickableSpan, 21, 46, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        registerNow.text = spannableString
        registerNow.movementMethod = LinkMovementMethod.getInstance()


        btnLogin.setOnClickListener {
            showSnackbar(constraintLayout, "Login", activity!!)
        }
    }

}
