package com.example.projectsphere

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectsphere.ui.theme.ProjectSphereTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val auth: FirebaseAuth = Firebase.auth
        val user = auth.currentUser
        if (user == null) {
            setContent {
                ProjectSphereTheme{
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ){
                        NavigateMain()
                    }
                }
            }
        }
        else{
            val intent = Intent(this, HomeActivity::class.java)
            this.startActivity(intent)
            finish()
        }
    }
}

@Composable
fun NavigateMain(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "startPage"){
        composable("startPage"){
            StartPage(navController)
        }
        composable("SignupPage"){
            SignupPage(navController)
        }
        composable("LoginPage"){
            LoginPage()
        }
    }
}
