package com.example.anorbank.presentation.auth.register.phone

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import com.example.anorbank.R
import com.example.anorbank.presentation.auth.register.reg.StringInputField
import com.example.anorbank.presentation.components.PhoneField
import com.example.anorbank.presentation.components.TextCompo
import com.example.anorbank.presentation.components.TextCompoRed
import com.example.anorbank.ui.theme.AnorBankTheme
import com.example.anorbank.ui.theme.Anor_light_grey


class AuthScreen : Screen {
    @Composable
    override fun Content() {

        val viewModel = getViewModel<AuthModel>()

        PhoneFuns(viewModel::onEventDispatcher)
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun PhoneFuns(onEventDispatcher: (AuthContract.MyIntent) ->Unit) {
    var number = rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable { mutableStateOf("") }

    var phoneNumber by rememberSaveable { mutableStateOf("") }
    val isChecked = remember { mutableStateOf(false) }

    var isButtonEnabled = phoneNumber.length == 9&& password.isNotEmpty()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Anor_light_grey)
    ) {
        Spacer(modifier = Modifier.weight(0.3f))

        Box(
            modifier = Modifier
                .weight(0.8f)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                modifier = Modifier
                    .size(153.dp, 153.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = R.drawable.ic_auth),
                contentDescription = "Back",
            )
        }

        Column(
            modifier = Modifier
                .weight(0.7f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            TextCompo(
                modifier = Modifier,
                FontFamily(Font(R.font.monsbold)),
                fontSize = 14.sp,
                stringResource(id = R.string.auth_title)
            )
            Spacer(modifier = Modifier.height(24.dp))
            TextCompo(
                modifier = Modifier,
                FontFamily(Font(R.font.monsbold)),
                fontSize = 12.sp,
                stringResource(id = R.string.auth_text)
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()

                .weight(1.6f)
                .padding(horizontal = 24.dp)
                .clip(shape = RoundedCornerShape(24.dp))
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxSize()

            ) {
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 24.dp)
                        .background(color = Anor_light_grey, shape = RoundedCornerShape(16.dp)),
                ) {

                    Image(
                        modifier = Modifier
                            .size(width = 43.dp, height = 43.dp)
                            .align(Alignment.CenterVertically)
                            .padding(start = 16.dp),
                        painter = painterResource(id = R.drawable.uzb),
                        contentDescription = null,
                    )


                    Spacer(modifier = Modifier.width(8.dp))
                    TextCompo(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontik = FontFamily(Font(R.font.monsbold)),
                        text = "+998"
                    )


                    PhoneField(phoneNumber,
                        mask = "00 000 00 00",
                        maskNumber = '0',
                        fontik = FontFamily(Font(R.font.monsbold)),
                        onPhoneChanged = { phoneNumber = it },
                        hint = "")

                }

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 24.dp)
                        .background(color = Anor_light_grey, shape = RoundedCornerShape(16.dp)),
                ) {
                    StringInputField(
                        hint = stringResource(id = R.string.reg_password),
                        text = password,
                        onValueChanged = { newText ->
                            password = newText
                        }
                    )
                    Spacer(
                        modifier = Modifier
                            .height(24.dp)
                            .background(color = Anor_light_grey)
                    )


                }

                Spacer(modifier = Modifier.height(16.dp))
                    Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .height(48.dp)
                    .padding(horizontal = 24.dp),
                    enabled = isButtonEnabled,
                    shape = RoundedCornerShape(16.dp),
                    onClick = {

                        onEventDispatcher(AuthContract.MyIntent.LoginToSms(phoneNumber, password))

                    }) {
                    Text(
                        modifier = Modifier.background(color = Color.Transparent),
                        text = stringResource(id = R.string.btn_continue)
                    )

                }


            }


        }

        Box(modifier = Modifier.weight(1f).fillMaxSize()){

            TextCompoRed(modifier = Modifier.align(Alignment.Center),
                fontik = FontFamily(Font(R.font.monsbold)),
                fontSize = 12.sp,
                onClick = {
                    onEventDispatcher(AuthContract.MyIntent.RegScreen)
                },
                text = stringResource(
                id = R.string.sign_up,

            ) )
        }
    }
}

@Composable
@Preview
fun authPreing(){
    AnorBankTheme {
        PhoneFuns({})
    }
}
