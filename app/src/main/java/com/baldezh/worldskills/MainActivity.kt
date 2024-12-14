package com.baldezh.worldskills

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.baldezh.worldskills.ui.theme.WorldSkillsTheme
import com.baldezh.worldskills.view.Home
import com.baldezh.worldskills.view.Login
import com.baldezh.worldskills.view.Splash

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorldSkillsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        val navController = rememberNavController()
                        NavHost(navController = navController, startDestination = Routes.Splash.route) {
                            composable(Routes.Splash.route) {
                                Splash(navigateToMainScreen = {
                                    navController.navigate(Routes.Home.route) {
                                        popUpTo(Routes.Splash.route) { inclusive = true }
                                    }
                                })
                            }
                            composable(Routes.Home.route) { Home(navController) }
                            composable(Routes.Login.route) { Login(navController)  }

                        }
                    }
                }
            }
        }
    }
}

