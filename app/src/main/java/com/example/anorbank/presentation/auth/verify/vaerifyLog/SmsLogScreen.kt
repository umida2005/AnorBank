package com.example.anorbank.presentation.auth.verify.vaerifyLog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import com.example.anorbank.R
import com.example.anorbank.presentation.auth.verify.SmsContract
import com.example.anorbank.presentation.auth.verify.SmsModel
import com.example.anorbank.presentation.components.PhoneFieldSms
import com.example.anorbank.presentation.components.TextCompo
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_light_grey

class SmsLogScreen : Screen {
    @Composable
    override fun Content() {

        val viewModel = getViewModel<SmsLogModel>()
        SmsFun(viewModel::onEventDispatcher)
    }


    @Composable
    fun SmsFun(onEventDispatcher: (SmsLogContract.MyIntent)->Unit) {

        var otp by rememberSaveable { mutableStateOf("") }

        var isButtonEnabled = otp.length==6
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Anor_light_grey)
        ) {


            Spacer(modifier = Modifier.weight(0.6f))
            Box(
                modifier = Modifier
                    .weight(1.5f)
                    .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    modifier = Modifier
                        .size(150.dp, 150.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.ic_auth),
                    contentDescription = "Back",
                )
            }

            Column(
                modifier = Modifier
                    .weight(0.8f)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TextCompo(
                    modifier = Modifier,
                    FontFamily(Font(R.font.monsbold)),
                    fontSize = 18.sp,
                    stringResource(id = R.string.verify_title)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextCompo(
                    modifier = Modifier,
                    FontFamily(Font(R.font.monsbold)),
                    fontSize = 12.sp,
                    stringResource(id = R.string.verify_text)
                )

            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.5f)
                    .padding(horizontal = 24.dp)
                    .clip(shape = RoundedCornerShape(24.dp))
            ) {

                Column (modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)){


                    Spacer(
                        modifier = Modifier
                            .height(24.dp)
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(horizontal = 24.dp)
                            .background(color = Anor_light_grey, shape = RoundedCornerShape(16.dp)),
                    ) {


                        PhoneFieldSms(otp,
                            mask = "000000",
                            maskNumber = '0',
                            onPhoneChanged = { otp = it })
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    Button(

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .padding(horizontal = 24.dp),
                        shape = RoundedCornerShape(16.dp),

                        enabled = isButtonEnabled,
                        onClick = {

                            onEventDispatcher(
                                SmsLogContract.MyIntent.OtpIntent(
                                otp
                            ))
                        }) {
                        Text(
                            modifier = Modifier.background(color = Color.Transparent),
                            text = stringResource(id = R.string.btn_continue)
                        )

                    }
//                    Spacer(
//                        modifier = Modifier
//                            .height(24.dp)
//                    )
                }


            }

            Box(modifier = Modifier
                .weight(1.5f)
                .fillMaxSize()) {

                Text(modifier = Modifier.align(Alignment.Center),
                    fontSize = 10.sp,
                    color = Anor_grey,
                    text = stringResource(id = R.string.msg_sms),
                    fontFamily = FontFamily(Font(R.font.monsbold),))


            }
        }
    }

    @Composable
    @Preview
    fun PhonePreview() {
        SmsFun(onEventDispatcher = {})
    }


}