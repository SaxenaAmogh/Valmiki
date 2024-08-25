package com.example.projectsphere

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddPageMain(navController: NavHostController) {

    val context = LocalContext.current
    val activity = context as? ComponentActivity

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Add Project",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            })
        },
        content = {innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding)
            ){
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
                                .shadow(
                                    elevation = 10.dp, // Elevation value
                                    shape = RoundedCornerShape(18.dp), // Shape of the box
                                    clip = true // If true, clips the shadow to the shape of the Box
                                )
                                .background(Color.White)
                                .clickable(
                                    onClick = {
                                        val intent = Intent(context, MyProjectsPage::class.java)
                                        context.startActivity(intent)
                                    }
                                ),
                        ){
                            Image(painter = painterResource(id = R.drawable.myproj), contentDescription ="" )
                        }
                    }
                    Spacer(modifier = Modifier.height(42.dp))
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
                                .shadow(
                                    elevation = 10.dp, // Elevation value
                                    shape = RoundedCornerShape(18.dp), // Shape of the box
                                    clip = true // If true, clips the shadow to the shape of the Box
                                )
                                .background(Color.White)
                                .clickable(
                                    onClick = {
                                        val intent = Intent(context, NewProjectsPage::class.java)
                                        context.startActivity(intent)
                                    }
                                ),
                        ) {
                            Image(painter = painterResource(id = R.drawable.newproj), contentDescription ="" )
                        }
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
                        onClick = {navController.navigate("home") }, // navController.navigate("Home") },
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
                        onClick = { navController.navigate("profile")},
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
fun AddPagePreview(){
    AddPageMain(navController = rememberNavController())
}
