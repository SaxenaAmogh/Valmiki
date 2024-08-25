package com.example.projectsphere

import android.content.ContentValues.TAG
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projectsphere.R
import com.example.projectsphere.ui.theme.ProjectSphereTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        amoghsaxena@gmail.com test1234
        setContent {
            ProjectSphereTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    SignupPage(rememberNavController())
                }
            }
        }
    }
}

@Composable
fun SignupPage(navController: NavHostController){

    val auth: FirebaseAuth = Firebase.auth
    val context = LocalContext.current
    val activity = context as? ComponentActivity
    var nameValue:String by remember{ mutableStateOf("") }
    var emailValue:String by remember{ mutableStateOf("")}
    var passValue:String by remember{ mutableStateOf("")}

    fun signUp(){
        if (activity != null) {
            auth.createUserWithEmailAndPassword(emailValue, passValue)
                .addOnCompleteListener(activity) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
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
            Spacer(modifier = Modifier.padding(32.dp))
            Image(
                painter = painterResource(id = R.drawable.img2),
                contentDescription = "Signup",
                Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Text(text ="Create a new account", fontSize = 28.sp)
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
                value = nameValue,
                singleLine = true,
                label = {Text("Full Name")},
                onValueChange = {nameValue = it}
            )

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
        Spacer(modifier = Modifier.padding(40.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(Color(189,0,70,255)),
                onClick = {
                    signUp()
                    navController.navigate("LoginPage")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(8.dp),
            ){
                Text(
                    text = "Sign Up",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Text(text ="Already have an account? Log in", fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignupPagePreview(){
    SignupPage( rememberNavController())
}