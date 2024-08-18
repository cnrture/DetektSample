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

private const val ZERO = 0
private const val ONE = 1
private const val TWO = 2
private const val THREE = 3
private const val FOUR = 4
private const val FIVE = 5
private const val TEN = 10

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

                exampleComplexFunction(FIVE)
            }
        }
    }
}

fun exampleComplexFunction(input: Int): String {
    val result = when {
        input > ZERO && input % TWO == ZERO -> "Positive Even "
        input > ZERO && input % TWO != ZERO -> "Positive Odd"
        input < ZERO && input % TWO == ZERO -> "Negative Even"
        input < ZERO && input % TWO != ZERO -> "Negative Odd"
        else -> "Zero"
    }

    printNumberDescription(input)
    printComparisonToInput(input)

    return result
}

private fun printNumberDescription(input: Int) {
    when (input) {
        ONE -> println("One")
        TWO -> println("Two")
        THREE -> println("Three")
        FOUR -> println("Four")
        FIVE -> println("Five")
        else -> println("Other")
    }
}

private fun printComparisonToInput(input: Int) {
    for (i in ONE..TEN) {
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
