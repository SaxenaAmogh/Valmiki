package com.example.projectsphere

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun StartPage(navController: NavHostController) {

    val context = LocalContext.current
    val activity = context as MainActivity

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.img1),
                contentDescription = "Welcome to App!"
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "Welcome to App!", fontSize = 24.sp)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Inspire, Connect, Admire!", fontSize = 20.sp)
        }
        Column {
            Button(
                colors = ButtonDefaults.buttonColors(Color(189,0,70,255)),
                onClick = { navController.navigate("SignupPage") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Get Started")
            }
            Button(
                colors = ButtonDefaults.buttonColors(Color(189,0,70,255)),
                onClick = {navController.navigate("LoginPage")}, //
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = "Already Have an Account? Log In")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartPagePreview() {
    StartPage(navController = rememberNavController())
}
