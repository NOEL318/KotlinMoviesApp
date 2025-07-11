package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.test.presentation.MainScreen
import com.example.test.presentation.Popular
import com.example.test.ui.theme.TestTheme

object Destinations {
    const val MAINSCREEN = "main_screen"
    const val POPULAR = "popular"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestTheme {
                MainScreen()
            }
        }
    }
}

/*
@Composable
fun AppNav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destinations.MAINSCREEN) {
        composable(Destinations.MAINSCREEN) {
            MainScreen(navController)
        }
        composable(Destinations.POPULAR) {
                Popular()
        }
    }
}
*/

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestTheme {
        Popular()
    }
}
