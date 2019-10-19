package com.example.horn

import androidx.navigation.NavController

class NavigationRouter(private var navController: NavController) {

    fun openRegistrationFragment() {
        navController.navigate(R.id.action_loginFragment_to_registrationFragment)
    }

    fun openOnboardingFragment() {
        navController.navigate(R.id.action_loginFragment_to_onboardingFragment)
    }

    fun popBackStack() {
        navController.popBackStack()
    }
}