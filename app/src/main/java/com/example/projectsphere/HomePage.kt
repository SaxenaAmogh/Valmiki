package com.example.projectsphere

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomePageMain(navController: NavHostController) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                text = "Valmiki")
        },
        actions = {
            Icon(Icons.Filled.Notifications, contentDescription = "add")
            Spacer(modifier = Modifier.width(16.dp))
            Icon(Icons.Filled.Search, contentDescription = "search")
        }
        )
    },
        content =  {innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
            ){
                repeat(5){
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
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth(),
                                verticalArrangement = Arrangement.Center,
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxHeight(),
                                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                                ) {
                                    Icon(
                                        Icons.Filled.AccountCircle,
                                        contentDescription = "Home",
                                        Modifier.size(48.dp)
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Column(
                                        modifier = Modifier.weight(1f),
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(text = "LivPol", fontSize = 20.sp)
                                        Text(text = "Robogyan", fontSize = 12.sp)
                                    }
                                }
                                Column(
                                    modifier = Modifier.fillMaxHeight(),
                                ) {
                                    var expanded by remember { mutableStateOf(false) }
                                    val minimizedMaxLines = 2
                                    Text(
                                        modifier = Modifier.padding(4.dp),//.clickable{expanded = !expanded}
                                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ac lorem ut nisi hendrerit maximus. Donec quis massa porta, iaculis leo at, dictum neque. Mauris euismod urna quis vehicula sollicitudin. Donec vulputate ante at enim malesuada, nec pellentesque leo mollis. Donec in diam eu felis venenatis pellentesque. Mauris eleifend non sem in feugiat. Vivamus ultrices metus ipsum, et pretium diam gravida nec. Etiam eu turpis feugiat, malesuada nibh sodales, condimentum nisi.".trimIndent(),
                                        maxLines = if (expanded) Int.MAX_VALUE else minimizedMaxLines,
                                        overflow = TextOverflow.Ellipsis,
                                    )
                                    Text(
                                        text = if (expanded) "Read Less" else "Read More",
                                        color = androidx.compose.ui.graphics.Color.Blue,
                                        modifier = Modifier
                                            .padding(start = 4.dp)
                                            .clickable { expanded = !expanded }
                                    )
                                }
                                Column {
                                    Image(
                                        painter = painterResource(id = R.drawable.img1),
                                        contentDescription = "image"
                                    )
                                }
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceAround
                                ) {
                                    var liked by remember { mutableStateOf(false) }
                                    var commented by remember { mutableStateOf(false) }
                                    var shared by remember { mutableStateOf(false) }
                                    IconButton(onClick = { liked = !liked }) {
                                        Icon(
                                            imageVector = Icons.Filled.ThumbUp,
                                            contentDescription = "Like",
                                            tint = if (liked) Color.DarkGray else Color.LightGray
                                        )
                                    }
                                    IconButton(onClick = { commented = !commented }) {
                                        Icon(
                                            imageVector = Icons.Filled.MailOutline,
                                            contentDescription = "Comment",
                                            tint = if (commented) Color.DarkGray else Color.LightGray
                                        )
                                    }
                                    IconButton(onClick = { shared = !shared }) {
                                        Icon(
                                            imageVector = Icons.Filled.Share,
                                            contentDescription = "Share",
                                            tint = if (shared) Color.DarkGray else Color.LightGray
                                        )
                                    }
                                }
                            }
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
                        onClick = { navController.navigate("home") }, // navController.navigate("Home") },
                        modifier = Modifier
                            .width(100.dp)
                            .padding(end = 16.dp)
                    ) {
                        Icon(Icons.Filled.Home, contentDescription = "Home", Modifier.size(28.dp))
                    }

                    Spacer(modifier = Modifier.width(24.dp))

                    FloatingActionButton(
                        onClick =  { navController.navigate("add") },
                        modifier = Modifier
                            .width(100.dp)
                            .padding(end = 16.dp)
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = "Search", Modifier.size(28.dp))
                    }

                    Spacer(modifier = Modifier.width(24.dp))

                    FloatingActionButton(
                        onClick =  { navController.navigate("profile") },
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
fun HomePagePreview(){
    HomePageMain(navController = rememberNavController())
}