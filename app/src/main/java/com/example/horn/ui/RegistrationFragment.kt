package com.example.horn.ui

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.horn.R
import com.example.horn.core.FragmentBase

class RegistrationFragment : FragmentBase() {
    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var name: EditText
    private lateinit var phone: EditText
    private lateinit var tvAdmin: TextView
    private lateinit var ifAdmin: Switch
    private lateinit var nameOrganization: EditText
    private lateinit var tvTermsAndConditions: TextView
    private lateinit var btnRegistration: Button

    private val TERMS_AND_CONDITIONS =
        "By registering you agree to Terms & Conditions \nand Privacy Policy"
    private lateinit var spannableString: SpannableString
    private lateinit var clickableSpanTC: ClickableSpan
    private lateinit var clickableSpanPP: ClickableSpan

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        constraintLayout = view.findViewById(R.id.fragment_registration_constraint_layout)
        name = view.findViewById(R.id.fragment_registration_et_name)
        phone = view.findViewById(R.id.fragment_registration_et_phone)
        tvAdmin = view.findViewById(R.id.fragment_registration_tv_admin)
        ifAdmin = view.findViewById(R.id.fragment_registration_switch_admin)
        nameOrganization = view.findViewById(R.id.fragment_registration_et_name_organization)
        tvTermsAndConditions = view.findViewById(R.id.fragment_registration_tv_terms_and_conditions)
        btnRegistration = view.findViewById(R.id.fragment_registration_btn_registration)

        spannableString = SpannableString(TERMS_AND_CONDITIONS)
        clickableSpanTC = object : ClickableSpan() {
            override fun onClick(widget: View) {
                showSnackbar(constraintLayout, "Terms & Conditions", activity!!)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = resources.getColor(R.color.colorLightOrange)
                ds.isUnderlineText = false
                ds.clearShadowLayer()
            }
        }
        clickableSpanPP = object : ClickableSpan() {
            override fun onClick(widget: View) {
                showSnackbar(constraintLayout, "Privacy Policy", activity!!)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = resources.getColor(R.color.colorLightOrange)
                ds.isUnderlineText = false
                ds.clearShadowLayer()
            }
        }

        spannableString.setSpan(clickableSpanTC, 28, 46, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(clickableSpanPP, 52, 66, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvTermsAndConditions.text = spannableString
        tvTermsAndConditions.movementMethod = LinkMovementMethod.getInstance()

        hide(nameOrganization)

        ifAdmin.setOnClickListener {
            if (ifAdmin.isChecked) {
                show(nameOrganization)
            } else {
                hide(nameOrganization)
            }
        }
    }
}
