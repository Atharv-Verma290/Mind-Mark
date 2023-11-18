package com.example.mindmark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mindmark.ui.theme.MindMarkTheme
import com.example.mindmark.ui.theme.md_theme_light_onPrimaryContainer
import com.example.mindmark.ui.theme.md_theme_light_primaryContainer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MindMarkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MindMarkTheme {
        Greeting("Android")
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = md_theme_light_primaryContainer,
                contentColor = md_theme_light_onPrimaryContainer
            )) {
            Text(text = "Yo")
        }
    }
}