package com.canerture.detektsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.canerture.detektsample.ui.theme.DetektSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DetektSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }

                exampleComplexFunction(5)
            }
        }
    }
}

fun exampleComplexFunction(input: Int): String {
    val result = when {
        input > 0 && input % 2 == 0 -> "Positive Even"
        input > 0 && input % 2 != 0 -> "Positive Odd"
        input < 0 && input % 2 == 0 -> "Negative Even"
        input < 0 && input % 2 != 0 -> "Negative Odd"
        else -> "Zero"
    }

    printNumberDescription(input)
    printComparisonToInput(input)

    return result
}

private fun printNumberDescription(input: Int) {
    when (input) {
        1 -> println("One")
        2 -> println("Two")
        3 -> println("Three")
        4 -> println("Four")
        5 -> println("Five")
        else -> println("Other")
    }
}

private fun printComparisonToInput(input: Int) {
    for (i in 1..10) {
        when {
            i == input -> println("Match: $i")
            i < input -> println("Less than input: $i")
            i > input -> println("Greater than input: $i")
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
    DetektSampleTheme {
        Greeting("Android")
    }
}
