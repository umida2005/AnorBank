package com.example.anorbank.presentation.auth.pin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.anorbank.R
import com.example.anorbank.presentation.components.TextCompo
import com.example.anorbank.ui.theme.Anor_black_medium
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_hint
import com.example.anorbank.ui.theme.Anor_light_grey

class PinScreen : Screen {
    @Composable
    override fun Content() {
        PinCode()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PinCode() {
    var pin1 by rememberSaveable { mutableStateOf("") }
    var pin2 by rememberSaveable { mutableStateOf("") }
    var pin3 by rememberSaveable { mutableStateOf("") }
    var pin4 by rememberSaveable { mutableStateOf("") }



    val (pincode, setPincode) = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Anor_light_grey)
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.height(56.dp))
            Image(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 24.dp)
                    .size(18.dp),

                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null
            )
            Box(modifier = Modifier.height(18.dp)) {}

            Image(
                modifier = Modifier
                    .size(160.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.ic_pin),
                contentDescription = null
            )
            Box(
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth()
            ) {
                TextCompo(
                    modifier = Modifier.align(Alignment.Center),
                    fontik = FontFamily(Font(R.font.monsbold)),
                    fontSize = 18.sp,
                    text = stringResource(
                        id = R.string.pin_first
                    )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 72.dp)
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .background(color = Color.White),
//                    .border(
//                        width = 1.dp,
//                        color = Anor_grey
//                    ),

                ) {
                    OutlinedTextField(
                        value = pin2,
                        onValueChange = { newText ->
                            pin2 = newText

                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            focusedBorderColor = Anor_light_grey,
                            unfocusedBorderColor = Anor_light_grey
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(0.2f))

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .background(color = Color.White)
                        .border(
                            width = 1.dp,
                            color = Anor_light_grey
                        )
                ) {
                    OutlinedTextField(
                        value = pin1,
                        onValueChange = { newtext ->
                            pin1 = newtext
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            focusedBorderColor = Anor_light_grey,
                            unfocusedBorderColor = Anor_light_grey
                        )
                    )
                }

                Spacer(modifier = Modifier.weight(0.2f))
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .background(color = Color.White)
                        .border(
                            width = 1.dp,
                            color = Anor_light_grey
                        )
                ) {
                    OutlinedTextField(
                        value = pin3,
                        onValueChange = { newItem ->
                            pin3 = newItem
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            focusedBorderColor = Anor_light_grey,
                            unfocusedBorderColor = Anor_light_grey
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(0.2f))

                Box(
                    modifier = Modifier
                        .weight(1f)

                        .background(color = Color.White)
                ) {
                    OutlinedTextField(
                        value = pin4,
                        onValueChange = { newText ->
                            pin4 = newText
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            focusedBorderColor = Anor_light_grey,
                            unfocusedBorderColor = Anor_light_grey
                        )
                    )

                }

            }
        }
        Column(
            modifier = Modifier
                .weight(0.8f)
                .clip(shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                //.fillMaxSize()
                .background(color = Color.White)
        ) {

            Spacer(modifier = Modifier.height(24.dp))

            repeat(4) { row ->
                Row(modifier = Modifier.weight(1f)) {
                    repeat(3) { col ->
                        if (row == 3 && col == 0) {
                            DeleteButton1(modifier = Modifier.weight(0.8f), onClick = { })
                        } else if (row == 3 && col == 1) {
                            MyButton(
                                number = "0", onClick = { setPincode(pincode + "0") },
                                modifier = Modifier.weight(0.5f)
                            )
                        } else if (row == 3 && col == 2) {
                            DeleteButton2(modifier = Modifier.weight(0.8f), onClick = { })
                        } else {
                            val number = (row * 3) + col + 1
                            MyButton(
                                number = number.toString(),
                                onClick = { setPincode(pincode + number) },
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}


@Composable
@Preview
fun checks() {
    PinCode()
}

@Composable
fun DeleteButton1(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .fillMaxHeight()
            .background(Color.Transparent),

        shape = RoundedCornerShape(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        onClick = onClick
    ) {

        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = R.drawable.ic_redel),

            contentDescription = null
        )
    }
}

@Composable
fun DeleteButton2(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .fillMaxHeight()
            .background(Color.Transparent),

        shape = RoundedCornerShape(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        onClick = onClick
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_delete),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = Anor_grey),
        )
    }
}

@Composable
fun MyButton(
    number: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current
) {
    Button(
        modifier = modifier
            .fillMaxHeight()
            .background(color = Color.White),
        shape = RoundedCornerShape(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        onClick = onClick
    ) {
        Text(
            text = number,
            color = Anor_black_medium,
            style = textStyle.copy(fontSize = 24.sp),
            fontFamily = FontFamily(Font(R.font.monsbold))
        )
    }
}