package com.example.projectsphere

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectsphere.UserManager.clearUserId
import com.example.projectsphere.ui.theme.ProjectSphereTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        UserManager.initialize(this)
        setContent {
            ProjectSphereTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    LoginPage()
                }
            }
        }
    }
}

@SuppressLint("MutableCollectionMutableState")
@Composable
fun LoginPage(){

    val auth: FirebaseAuth = Firebase.auth
    val context = LocalContext.current
    val activity = context as? ComponentActivity
    var emailValue by remember{ mutableStateOf("") }
    var passValue by remember{ mutableStateOf("") }

    fun login() {
        Log.d("Check4", "Testing1")
        if (activity != null) {
            Log.d("Check0", "Testing1")
            auth.signInWithEmailAndPassword(emailValue, passValue)
                .addOnCompleteListener(activity) { task ->
                    Log.d("Check5", "Testing1")
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Check2", "signInWithEmail:success")
                        val user = auth.currentUser
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.d("Fail1", "signInWithEmail:failure")
                        Toast.makeText(
                            context,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.padding(24.dp))
            Image(
                painter = painterResource(id = R.drawable.loginmain),
                contentDescription = "Signup",
                Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.padding(32.dp))
            Text(text ="Welcome Back!", fontSize = 34.sp)
            Text(text ="Sign in to your account using your password", fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                shape = RoundedCornerShape(8.dp),
                value = emailValue,
                singleLine = true,
                label = {Text("Email")},
                onValueChange = {emailValue = it}
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                shape = RoundedCornerShape(8.dp),
                value = passValue,
                singleLine = true,
                label = {Text("Password")},
                onValueChange = {passValue = it}
            )
        }
        Spacer(modifier = Modifier.padding(24.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(Color(189,0,70,255)),
                onClick = {
                    login()
                    val intent = Intent(context, HomeActivity::class.java)
                    context.startActivity(intent)
                    activity?.finish()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(8.dp),
            ){
                Text(
                    text = "Log In",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPage()
}