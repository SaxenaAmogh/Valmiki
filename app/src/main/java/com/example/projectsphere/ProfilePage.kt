package com.example.projectsphere

import android.annotation.SuppressLint
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfilePageMain(navController: NavHostController) {

    val context = LocalContext.current
    val activity = context as? ComponentActivity

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Profile",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            })
        },
        content = {innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
            )  {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
                            .shadow(
                                elevation = 5.dp, // Elevation value
                                shape = RoundedCornerShape(8.dp), // Shape of the box
                                clip = true // If true, clips the shadow to the shape of the Box
                            )
                            .background(Color.White),
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(
                                Icons.Filled.AccountCircle,
                                modifier = Modifier.size(42.dp),
                                contentDescription = "Icon Profile")
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Aditya Paswan",
                                textAlign = TextAlign.Center,
                                fontSize = 24.sp,
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        FloatingActionButton(
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(0.3f),
                            onClick = {}
                        )
                        {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 20.dp),
                                    text = "Completed")
                                Icon(Icons.Filled.Home, contentDescription = "Home", Modifier.size(20.dp))
                                Text(text = "5", fontSize = 28.sp, modifier = Modifier.padding(12.dp))
                            }
                        }
                        FloatingActionButton(
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(0.3f),
                            onClick = {}
                        )
                        {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 20.dp),
                                    text = "In Progress")
                                Icon(Icons.Filled.Home, contentDescription = "Home", Modifier.size(20.dp))
                                Text(text = "4", fontSize = 28.sp, modifier = Modifier.padding(12.dp))
                            }
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        FloatingActionButton(
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(0.3f),
                            onClick = {}
                        )
                        {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 20.dp),
                                    text = "Proposals")
                                Icon(Icons.Filled.Home, contentDescription = "Home", Modifier.size(20.dp))
                                Text(text = "3", fontSize = 28.sp, modifier = Modifier.padding(12.dp))
                            }
                        }
                        FloatingActionButton(
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(0.3f),
                            onClick = {}
                        )
                        {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 20.dp),
                                    text = "Collaborators")
                                Icon(Icons.Filled.Home, contentDescription = "Home", Modifier.size(20.dp))
                                Text(text = "15", fontSize = 28.sp, modifier = Modifier.padding(12.dp))
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
                            .shadow(
                                elevation = 5.dp, // Elevation value
                                shape = RoundedCornerShape(8.dp), // Shape of the box
                                clip = true // If true, clips the shadow to the shape of the Box
                            )
                            .background(Color.White),
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                        ){
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Platform Overview",
                                fontSize = 18.sp,
                                )
                            Spacer(modifier = Modifier.padding(16.dp))
                            Column {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Total Projects",
                                        fontSize = 16.sp,
                                    )
                                    Text(
                                        text = "157",
                                        fontSize = 16.sp,
                                    )
                                }
                                Spacer(modifier = Modifier.padding(8.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Active Users",
                                        fontSize = 16.sp,
                                    )
                                    Text(
                                        text = "570",
                                        fontSize = 16.sp,
                                    )
                                }
                                Spacer(modifier = Modifier.padding(8.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Ongoing Projects",
                                        fontSize = 16.sp,
                                    )
                                    Text(
                                        text = "89",
                                        fontSize = 16.sp,
                                    )
                                }
                                Spacer(modifier = Modifier.padding(8.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Total Proposals",
                                        fontSize = 16.sp,
                                    )
                                    Text(
                                        text = "269",
                                        fontSize = 16.sp,
                                    )
                                }
                            }
                        }
                    }
                    Button(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        onClick = {
                            Firebase.auth.signOut()
                            val intent = Intent(context, MainActivity::class.java)
                            context.startActivity(intent)
                            activity?.finish()
                    }){
                        Text(text = "Logout", fontSize = 18.sp, modifier = Modifier.fillMaxWidth())
                    }
                }
            }

        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.width(24.dp))
                    FloatingActionButton(
                        onClick = { navController.navigate("home")}, // navController.navigate("Home") },
                        modifier = Modifier
                            .width(100.dp)
                            .padding(end = 16.dp)
                    ) {
                        Icon(Icons.Filled.Home, contentDescription = "Home", Modifier.size(28.dp))
                    }

                    Spacer(modifier = Modifier.width(24.dp))

                    FloatingActionButton(
                        onClick = {navController.navigate("add")},
                        modifier = Modifier
                            .width(100.dp)
                            .padding(end = 16.dp)
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = "Search", Modifier.size(28.dp))
                    }

                    Spacer(modifier = Modifier.width(24.dp))

                    FloatingActionButton(
                        onClick = {navController.navigate("profile") },
                        modifier = Modifier
                            .width(100.dp)
                            .padding(end = 16.dp)
                    ) {
                        Icon(Icons.Filled.AccountCircle, contentDescription = "Profile", Modifier.size(28.dp))
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview(){
    ProfilePageMain(navController = rememberNavController())
}