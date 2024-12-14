package com.baldezh.worldskills

sealed class Routes(val route: String) {

    data object Login : Routes("login")
    data object Home : Routes("home")
    data object Splash : Routes("splash")
}