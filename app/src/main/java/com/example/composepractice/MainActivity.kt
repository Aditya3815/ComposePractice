package com.example.composepractice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var num1 by remember {
                mutableIntStateOf(0)
            }

            var num2 by remember {

                mutableIntStateOf(0)
            }

            Column(
                modifier = Modifier.padding(start = 40.dp, top = 180.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {


                Text(
                    text = "Calculator",
                    fontSize = 25.sp,
                    color = androidx.compose.ui.graphics.Color.Magenta,
                )

                Spacer(modifier = Modifier.padding(10.dp))

                TextField(
                    value = num1.toString(),
                    onValueChange = { it ->
                    if (it.all { it.isDigit() }) {
                        num1 = it.toInt()
                    }
                },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text("Enter numbers only") }
                )

                TextField(
                    value = num2.toString(),
                    onValueChange = {it ->
                        if (it.all { it.isDigit() }) {
                            num2 = it.toInt()
                        }
                },  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text("Enter numbers only")}
                )

                Spacer(modifier = Modifier.padding(start = 10.dp))


                var res by remember {
                    mutableIntStateOf("0".toInt())
                }

                Text(
                    text = "$res",
                    modifier = Modifier.padding(start = 10.dp, top = 15.dp, bottom = 15.dp),
                    fontSize = 25.sp,
                    color = androidx.compose.ui.graphics.Color.Magenta,
                )


                Row {
                    Button(onClick = {
                        res = num1.toInt() + num2.toInt()
                        Toast.makeText(this@MainActivity, res.toString(), Toast.LENGTH_SHORT).show()
                    }) { Text(text = "Add") }
                    Spacer(modifier = Modifier.padding(start = 10.dp))

                    Button(onClick = {
                        res = num1.toInt() - num2.toInt()
                        Toast.makeText(this@MainActivity, res.toString(), Toast.LENGTH_SHORT).show()
                    }) { Text(text = "Sub") }
                    Spacer(modifier = Modifier.padding(start = 10.dp))

                    Button(onClick = {
                        res = num1.toInt() * num2.toInt()
                        Toast.makeText(this@MainActivity, res.toString(), Toast.LENGTH_SHORT).show()
                    }) { Text(text = "Mul") }
                    Spacer(modifier = Modifier.padding(start = 10.dp))

                    Button(onClick = {
                        if (num2.toInt() <= 0) {

                            Toast.makeText(
                                this@MainActivity,
                                "Can't be divided by zero",
                                Toast.LENGTH_SHORT
                            ).show()

                        } else {
                            res = num1.toInt() / num2.toInt()
                            Toast.makeText(
                                this@MainActivity,
                                res.toDouble().toString(),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }) { Text(text = "Div") }
                }

            }


        }
    }
}


