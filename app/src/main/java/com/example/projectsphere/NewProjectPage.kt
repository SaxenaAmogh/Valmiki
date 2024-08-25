package com.example.projectsphere

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectsphere.ui.theme.ProjectSphereTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class NewProjectsPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectSphereTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    NewProjectsPageMain()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewProjectsPageMain() {

    fun addProjectToUser(userId: String, projectName: String, overview: String, fullInfo: String, technologiesUsed: List<String>, progress: String, collaborators: List<String>, images: List<String>, githubLink: String, linkedInLink: String) {
        val db = FirebaseFirestore.getInstance()

        // Reference to the user's 'projects'
        val projectsRef = db.collection("users").document(userId).collection("projects")

        // Create a new project object
        val newProject = hashMapOf(
            "projectName" to projectName,
            "overview" to overview,
            "fullInfo" to fullInfo,
            "technologiesUsed" to technologiesUsed,
            "progress" to progress,
            "collaborators" to collaborators,
            "images" to images,
            "githubLink" to githubLink,
            "linkedInLink" to linkedInLink
        )

        projectsRef.add(newProject)
            .addOnSuccessListener { documentReference ->
                println("Project added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                println("Error adding project: $e")
            }
    }

    val user = FirebaseAuth.getInstance().currentUser
    val userId = user?.uid
    val context = LocalContext.current
    val activity = context as? ComponentActivity

    var projectName by remember { mutableStateOf("") }
    var overview by remember { mutableStateOf("") }
    var fullinfo by remember { mutableStateOf("") }
    var technologies by remember { mutableStateOf("") }
    var collaborators by remember { mutableStateOf("") }
    var media by remember { mutableStateOf("") }
    var github by remember { mutableStateOf("") }
    var linkedin by remember { mutableStateOf("") }
    var sliderValue by remember { mutableFloatStateOf(0f) }

    Scaffold(
        topBar = {
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
                    text = "New Projects",)
            },
        )
    },
        content = {innerPadding ->
            Column (modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = projectName,
                        onValueChange = {projectName = it},
                        label = { Text("Project Name") },
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                            .shadow(
                                elevation = 5.dp, // Elevation value
                                shape = RoundedCornerShape(4.dp), // Shape of the box
                                clip = true // If true, clips the shadow to the shape of the Box
                            )
                            .background(Color.Green),
                    ) {
                        Text(text = "Active", modifier = Modifier.padding(5.dp))
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Overview", fontWeight = FontWeight.W600, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = overview,
                        onValueChange = {overview = it}
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Full Info", fontWeight = FontWeight.W600, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = fullinfo,
                        onValueChange = {fullinfo = it}
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Technologies", fontWeight = FontWeight.W600, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = technologies,
                        onValueChange = {technologies = it}
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Progress", fontWeight = FontWeight.W600, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Slider(
                        value = sliderValue,
                        onValueChange = { newValue -> sliderValue = newValue },
                        valueRange = 0f..100f,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                    Text(
                        text = "Selected Value: ${sliderValue.toInt()}%",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Collaborators", fontWeight = FontWeight.W600, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = collaborators,
                        onValueChange = {collaborators = it}
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Media", fontWeight = FontWeight.W600, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = media,
                        onValueChange = {media = it}
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Social Links", fontWeight = FontWeight.W600, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = github,
                        onValueChange = {github = it},
                        label = { Text("Github") },
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = linkedin,
                        onValueChange = {linkedin = it},
                        label = { Text("LinkedIn") },
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            addProjectToUser(userId!!, projectName, overview, fullinfo, technologies.split(","), sliderValue.toInt().toString(), collaborators.split(","), media.split(","), github, linkedin)
                            activity?.finish()
                                  },
                        shape = RoundedCornerShape(12.dp)
                    ) {
                       Text("Create Project", Modifier.padding(16.dp))
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun NewProjectsPagePreview(){
    NewProjectsPageMain()
}