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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectsphere.ui.theme.ProjectSphereTheme
import com.google.firebase.firestore.FirebaseFirestore

class MyProjectsPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectSphereTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    MyProjectsPageMain()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyProjectsPageMain() {

    val context = LocalContext.current
    val activity = context as? ComponentActivity

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            navigationIcon = {
                IconButton(onClick = { activity?.onBackPressed() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            title = {
                Text(
                    text = "My Projects",)
            },
        )
    },
        content =  {innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
            ){
                repeat(3){
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
                                .background(Color.White)
                                .clickable(
                                    onClick = {
                                        val intent = Intent(context, NewProjectsPage::class.java)
                                        context.startActivity(intent)
                                    }
                                ),
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth(),
                                verticalArrangement = Arrangement.Center,
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 8.dp, end = 8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = "LivPol", fontSize = 24.sp)
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(Icons.Filled.Favorite, contentDescription = "likes")
                                        Text(text = "201")
                                    }
                                }
                                Box(
                                    modifier = Modifier
                                        .padding(start = 8.dp, top = 4.dp)
                                        .shadow(
                                            elevation = 5.dp, // Elevation value
                                            shape = RoundedCornerShape(8.dp), // Shape of the box
                                            clip = true // If true, clips the shadow to the shape of the Box
                                        )
                                        .background(Color.Green),
                                ) {
                                    Text(text = "Active", modifier = Modifier.padding(8.dp))
                                }
                                Column(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .padding(start = 8.dp, end = 8.dp),
                                ) {
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Row {
                                        Text(
                                            text = "Overview: ",
                                            fontWeight = FontWeight.W500
                                        )
                                        Text(
                                            text = "This is a project to increase voter turnout in elections.",
                                            maxLines = 2
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Row {
                                        Text(
                                            text = "Technology: ",
                                            fontWeight = FontWeight.W500
                                        )
                                        Text(text = "Kotlin, Firebase, Python, Js", maxLines = 2)
                                    }
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Row {
                                        Text(
                                            text = "Last Updated: ",
                                            fontWeight = FontWeight.W500
                                        )
                                        Text(text = "25/08/2024", maxLines = 2)
                                    }
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Row {
                                        Text(
                                            text = "Collaborators: ",
                                            fontWeight = FontWeight.W500
                                        )
                                        Text(text = "Ashish, Faizan, Amogh, Jayam", maxLines = 2)
                                    }
                                }
                                Spacer(modifier = Modifier.height(12.dp))
                            }
                        }

                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MyProjectsPagePreview(){
    MyProjectsPageMain()
}