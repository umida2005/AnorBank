package com.example.anorbank.presentation.auth.pincode

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import com.example.anorbank.R
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_hint
import com.example.anorbank.ui.theme.Anor_light
import com.example.anorbank.utils.spacers.SpacerWTwentyFour
import org.orbitmvi.orbit.compose.collectSideEffect

class PinCodeScreen : Screen {
    private val list = ArrayList<Int>()

    @Composable
    override fun Content() {

        var s by remember {
            mutableStateOf(false)
        }
        val viewModel = getViewModel<PinCodeViewModel>()


        viewModel.collectSideEffect(sideEffect = {
            when (it) {
                is PinCodeContract.SideEffect.IsFUl -> {
                    s = it.isFul
                }
            }

        })
        PinCodeFun(openPinCode = viewModel::onEventDispatcher)
        if (s) {
            PinCodeFun(openPinCode = viewModel::onEventDispatcher)
            list.clear()
        }
    }

    @SuppressLint("NotConstructor", "LogNotTimber")
    @Composable
    fun PinCodeFun(openPinCode: (PinCodeContract.Intent) -> Unit = {}) {

        var pinCode1 by remember { mutableStateOf(false) }
        var pinCode2 by remember { mutableStateOf(false) }
        var pinCode3 by remember { mutableStateOf(false) }
        var pinCode4 by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Anor_hint)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                Spacer(modifier = Modifier.size(100.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(start = 16.dp)
                    )

                    SpacerWTwentyFour()

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterVertically)

                    ) {
                        Image(
                            modifier = Modifier.size(150.dp,150.dp)
                                .padding(end = 35.dp).align(Alignment.Center),
                            painter = painterResource(id = R.drawable.ic_pin),
                            contentDescription = null
                        )
                    }
                }
                Spacer(modifier = Modifier.size(35.dp))

                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally), text = stringResource(
                        id =
                        R.string.pins_enter,
                    ), fontSize = 14.sp
                )
                Spacer(modifier = Modifier.size(55.dp))
                Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    if (!pinCode1) {
                        RowWithCircle(color = Anor_grey)
                    } else {
                        RowWithCircle(color = Color.Black)
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    if (!pinCode2) {
                        RowWithCircle(color = Anor_grey)
                    } else {
                        RowWithCircle(color = Color.Black)
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    if (!pinCode3) {

                        RowWithCircle(color = Anor_grey)
                    } else {


                        RowWithCircle(color = Color.Black)

                    }

                    Spacer(modifier = Modifier.size(20.dp))
                    if (!pinCode4) {

                        RowWithCircle(color = Anor_grey)
                    } else {
                        RowWithCircle(color = Color.Black)
                    }

                }
                Spacer(modifier = Modifier.size(70.dp))
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),

                    text = stringResource(id = R.string.pins_enter)
                )


                Row(modifier = Modifier.weight(0.2f)) {

                }
                Row(modifier = Modifier.weight(0.2f)) {
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .weight(0.9f)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.3f)
                        .padding(start = 16.dp, end = 16.dp)
                ) {

                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.5f)
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(
                            text = "1", modifier = Modifier
                                .align(Alignment.Center)
                                .fillMaxWidth()
                                .clickable {
                                    list.add(1)
                                    if (list.size <= 4) {
                                        when (list.size) {
                                            1 -> {
                                                pinCode1 = true
                                            }

                                            2 -> {
                                                pinCode2 = true

                                            }

                                            3 -> {
                                                pinCode3 = true
                                            }

                                            4 -> {
                                                pinCode4 = true

                                                val s =
                                                    (list[0].toString() + list[1].toString() + list[2].toString() + list[3].toString()).toString()
                                                openPinCode.invoke(
                                                    PinCodeContract.Intent.OpenMainScreen(
                                                        s
                                                    )
                                                )

                                            }
                                        }

                                    }

                                },
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center

                        )
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "2",
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {

                                    list.add(2)
                                    if (list.size <= 4) {

                                        when (list.size) {

                                            1 -> {
                                                pinCode1 = true
                                            }

                                            2 -> {
                                                pinCode2 = true

                                            }

                                            3 -> {
                                                pinCode3 = true
                                            }

                                            4 -> {
                                                pinCode4 = true
                                                val s =
                                                    (list[0].toString() + list[1].toString() + list[2].toString() + list[3].toString()).toString()
                                                openPinCode.invoke(
                                                    PinCodeContract.Intent.OpenMainScreen(
                                                        s
                                                    )
                                                )
                                                pinCode4 = true
                                            }
                                        }

                                    }

                                }
                                .align(Alignment.Center),
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center

                        )
                    }
                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "3",
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center)
                                .clickable {
                                    list.add(3)

                                    if (list.size <= 4) {
                                        when (list.size) {
                                            1 -> {
                                                pinCode1 = true
                                            }

                                            2 -> {
                                                pinCode2 = true

                                            }

                                            3 -> {
                                                pinCode3 = true
                                            }

                                            4 -> {
                                                pinCode4 = true
                                                val s =
                                                    (list[0].toString() + list[1].toString() + list[2].toString() + list[3].toString()).toString()
                                                openPinCode.invoke(
                                                    PinCodeContract.Intent.OpenMainScreen(
                                                        s
                                                    )
                                                )
                                                pinCode4 = true
                                            }
                                        }

                                    }

                                },
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center

                        )
                    }

                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.5f)
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "4", modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center)
                                .fillMaxWidth()
                                .clickable {

                                    list.add(4)
                                    if (list.size <= 4) {
                                        when (list.size) {
                                            1 -> {
                                                pinCode1 = true
                                            }

                                            2 -> {
                                                pinCode2 = true

                                            }

                                            3 -> {
                                                pinCode3 = true
                                            }

                                            4 -> {
                                                pinCode4 = true
                                                val s =
                                                    (list[0].toString() + list[1].toString() + list[2].toString() + list[3].toString())
                                                openPinCode.invoke(
                                                    PinCodeContract.Intent.OpenMainScreen(
                                                        s
                                                    )
                                                )
                                            }
                                        }
                                    }


                                },
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center

                        )
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "5", modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center)
                                .clickable {

                                    list.add(5)
                                    if (list.size <= 4) {
                                        when (list.size) {
                                            1 -> {
                                                pinCode1 = true
                                            }

                                            2 -> {
                                                pinCode2 = true

                                            }

                                            3 -> {
                                                pinCode3 = true
                                            }

                                            4 -> {
                                                pinCode4 = true
                                                val s =
                                                    (list[0].toString() + list[1].toString() + list[2].toString() + list[3].toString()).toString()
                                                openPinCode.invoke(
                                                    PinCodeContract.Intent.OpenMainScreen(
                                                        s
                                                    )
                                                )
                                            }
                                        }

                                    }

                                },
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center

                        )
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "6", modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center)
                                .clickable {

                                    list.add(6)
                                    if (list.size <= 4) {

                                        when (list.size) {
                                            1 -> {
                                                pinCode1 = true
                                            }

                                            2 -> {
                                                pinCode2 = true

                                            }

                                            3 -> {
                                                pinCode3 = true
                                            }

                                            4 -> {
                                                pinCode4 = true
                                                val s =
                                                    (list[0].toString() + list[1].toString() + list[2].toString() + list[3].toString()).toString()
                                                openPinCode.invoke(
                                                    PinCodeContract.Intent.OpenMainScreen(
                                                        s
                                                    )
                                                )

                                            }
                                        }

                                    }

                                },
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center

                        )
                    }

                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.5f)
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "7", modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center)
                                .clickable {

                                    list.add(7)
                                    if (list.size <= 4) {
                                        when (list.size) {
                                            1 -> {
                                                pinCode1 = true
                                            }

                                            2 -> {
                                                pinCode2 = true

                                            }

                                            3 -> {
                                                pinCode3 = true
                                            }

                                            4 -> {
                                                pinCode4 = true
                                                val s =
                                                    (list[0].toString() + list[1].toString() + list[2].toString() + list[3].toString()).toString()
                                                openPinCode.invoke(
                                                    PinCodeContract.Intent.OpenMainScreen(
                                                        s
                                                    )
                                                )

                                            }
                                        }

                                    }

                                },
                            fontSize = 24.sp, textAlign = TextAlign.Center
                        )
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "8", modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center)
                                .clickable {

                                    list.add(8)
                                    if (list.size <= 4) {
                                        when (list.size) {
                                            1 -> {
                                                pinCode1 = true
                                            }

                                            2 -> {
                                                pinCode2 = true

                                            }

                                            3 -> {
                                                pinCode3 = true
                                            }

                                            4 -> {
                                                pinCode4 = true
                                                val s =
                                                    (list[0].toString() + list[1].toString() + list[2].toString() + list[3].toString()).toString()
                                                openPinCode.invoke(
                                                    PinCodeContract.Intent.OpenMainScreen(
                                                        s
                                                    )
                                                )
                                                pinCode4 = true
                                            }
                                        }

                                    }

                                },
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center

                        )
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "9", modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center)
                                .clickable {
                                    list.add(9)
                                    if (list.size <= 4) {
                                        when (list.size) {
                                            1 -> {
                                                pinCode1 = true
                                            }

                                            2 -> {
                                                pinCode2 = true

                                            }

                                            3 -> {
                                                pinCode3 = true
                                            }

                                            4 -> {
                                                pinCode4 = true
                                                val s =
                                                    (list[0].toString() + list[1].toString() + list[2].toString() + list[3].toString()).toString()
                                                openPinCode.invoke(
                                                    PinCodeContract.Intent.OpenMainScreen(
                                                        s
                                                    )
                                                )
                                            }
                                        }

                                    } else {

                                    }
                                },
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.5f)
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        Image(
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp)
                                .align(Alignment.Center),
                            painter = painterResource(id = R.drawable.ic_touches),
                            contentDescription = null
                        )
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "0",
                            modifier = Modifier
                                .align(Alignment.Center)
                                .clickable {
                                    list.add(9)
                                    if (list.size <= 4) {
                                        when (list.size) {
                                            1 -> {
                                                pinCode1 = true
                                            }

                                            2 -> {
                                                pinCode2 = true

                                            }

                                            3 -> {
                                                pinCode3 = true
                                            }

                                            4 -> {
                                                pinCode4 = true
                                                val s =
                                                    (list[0].toString() + list[1].toString() + list[2].toString() + list[3].toString()).toString()
                                                openPinCode.invoke(
                                                    PinCodeContract.Intent.OpenMainScreen(
                                                        s
                                                    )
                                                )
                                            }
                                        }

                                    } else {

                                    }
                                },
                            fontSize = 24.sp
                        )
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_delete),
                            contentDescription = null,
                            modifier = Modifier
                                .size(25.dp)
                                .align(Alignment.Center)
                                .clickable {
                                    when (list.size) {
                                        1 -> {
                                            pinCode1 = false
                                            list.removeAt(0)
                                        }

                                        2 -> {
                                            pinCode2 = false
                                            list.removeAt(1)
                                        }

                                        3 -> {
                                            pinCode3 = false
                                            list.removeAt(2)
                                        }

                                        4 -> {
                                            pinCode4 = false
                                            list.removeAt(3)
                                        }
                                    }
                                }
                        )
                    }

                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.2f)

                ) {

                }
            }
        }
    }


    @Preview
    @Composable
    fun PinCodePreview() {
        PinCodeFun()
    }}


@Composable
fun RowWithCircle(color: Color = Anor_light) {
    Card(
        modifier = Modifier
            .size(width = 40.dp, height = 45.dp)
            .background(Color.Transparent),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, Anor_hint),
        elevation = 4.dp
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape),
                onClick = {
                },
                colors = ButtonDefaults.buttonColors( Anor_grey),
                contentPadding = PaddingValues(0.dp)
            ) {
            }
        }
    }
}



@Preview
@Composable
fun preview() {
    RowWithCircle()
}