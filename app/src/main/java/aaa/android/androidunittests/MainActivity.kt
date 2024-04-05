package aaa.android.androidunittests

import aaa.android.androidunittests.ui.theme.AndroidUnitTestsTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidUnitTestsTheme {
                CalculatorFunctions()
            }
        }
    }
}

@Composable
@Preview
fun CalculatorFunctions() {
    val fieldOneValue = remember { mutableStateOf("") }
    val fieldTwoValue = remember { mutableStateOf("") }
    val fieldResultValue = remember { mutableStateOf("") }
    Column {
        TextField(
            textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
            value = " Simple Calculator",
            onValueChange = {},
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .padding(24.dp)
                .background(color = Color.Magenta),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Yellow,
                focusedContainerColor = Color.Yellow
            )
        )

        OutlinedTextField(
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = fieldOneValue.value,
            onValueChange = {
                fieldOneValue.value = it
            },
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .padding(8.dp)

        )
        OutlinedTextField(
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = fieldTwoValue.value,
            onValueChange = { fieldTwoValue.value = it },
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .padding(8.dp)

        )

        TextField(
            value = fieldResultValue.value,
            onValueChange = {},
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .padding(8.dp)

        )
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize()
                .padding(10.dp)
        ) {
            ElevatedButton(onClick = {
                val result = addTheValues(fieldOneValue, fieldTwoValue)
                fieldResultValue.value = result
            }) {
                Text(
                    text = "+",
                    modifier = Modifier
                        .padding(start = 2.dp, end = 2.dp)
                        .padding(start = 2.dp, end = 2.dp)
                )
            }
            ElevatedButton(onClick = {
                val result = minusTheValues(fieldOneValue, fieldTwoValue)
                fieldResultValue.value = result
            }) {
                Text(
                    text = "-",
                    modifier = Modifier
                        .padding(start = 2.dp, end = 2.dp)
                        .padding(start = 2.dp, end = 2.dp)
                )
            }
            ElevatedButton(onClick = {
                val result = multiplyTheValues(fieldOneValue, fieldTwoValue)
                fieldResultValue.value = result
            }) {
                Text(
                    text = "*",
                    modifier = Modifier
                        .padding(start = 2.dp, end = 2.dp)
                        .padding(start = 2.dp, end = 2.dp)
                )
            }
            ElevatedButton(onClick = {
                val result = divideTheValues(fieldOneValue, fieldTwoValue)
                fieldResultValue.value = result
            }) {
                Text(
                    text = "/",
                    modifier = Modifier
                        .padding(start = 2.dp, end = 2.dp)
                        .padding(start = 2.dp, end = 2.dp)
                )
            }
            ElevatedButton(onClick = {
                fieldOneValue.value = ""
                fieldTwoValue.value = ""
                fieldResultValue.value = ""
            }) {
                Text(
                    text = "clear",
                    modifier = Modifier
                        .padding(start = 2.dp, end = 2.dp)
                        .padding(start = 2.dp, end = 2.dp)
                )
            }
        }

    }
}


fun addTheValues(inputOne: MutableState<String>, inputTwo: MutableState<String>): String {
    return (inputOne.value.toFloat() + inputTwo.value.toFloat()).toString()
}

fun minusTheValues(inputOne: MutableState<String>, inputTwo: MutableState<String>): String {
    return (inputOne.value.toFloat() - inputTwo.value.toFloat()).toString()
}

fun multiplyTheValues(inputOne: MutableState<String>, inputTwo: MutableState<String>): String {
    return (inputOne.value.toFloat() * inputTwo.value.toFloat()).toString()
}

fun divideTheValues(inputOne: MutableState<String>, inputTwo: MutableState<String>): String {
    return (inputOne.value.toFloat() / inputTwo.value.toFloat()).toString()
}

