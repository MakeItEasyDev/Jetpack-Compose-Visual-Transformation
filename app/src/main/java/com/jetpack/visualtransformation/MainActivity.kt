package com.jetpack.visualtransformation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jetpack.visualtransformation.BrazilianNumberDefault.BR_PHONE_LENGTH
import com.jetpack.visualtransformation.BrazilianNumberDefault.BR_PHONE_MASK
import com.jetpack.visualtransformation.BrazilianNumberDefault.DATE_OF_BIRTH_LENGTH
import com.jetpack.visualtransformation.ui.theme.VisualTransformationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var phoneNumber by remember { mutableStateOf("") }
            var dateOfBirth by remember { mutableStateOf("") }
            VisualTransformationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Visual Transformation",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        }
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Date Of Birth",
                                modifier = Modifier.padding(bottom = 10.dp),
                                fontWeight = FontWeight.Bold
                            )

                            OutlinedTextField(
                                value = dateOfBirth,
                                onValueChange = {
                                    if (it.length <= DATE_OF_BIRTH_LENGTH) {
                                        dateOfBirth = it
                                    }
                                },
                                visualTransformation = DateTransformation(),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                )
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = "Mobile Number",
                                modifier = Modifier.padding(bottom = 10.dp),
                                fontWeight = FontWeight.Bold
                            )

                            OutlinedTextField(
                                value = phoneNumber,
                                onValueChange = {
                                    if (it.length <= BR_PHONE_LENGTH) {
                                        phoneNumber = it
                                    }
                                },
                                visualTransformation = MaskVisualTransformation(BR_PHONE_MASK),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

object BrazilianNumberDefault {
    const val BR_PHONE_MASK = "(##) #####-#####"
    const val BR_PHONE_LENGTH = 12
    const val DATE_OF_BIRTH_LENGTH = 8
}




















