package com.example.anorbank.presentation.auth.verify

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
import com.example.anorbank.presentation.components.PhoneFieldSms
import com.example.anorbank.presentation.components.TextCompo
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_light_grey

class SmsScreen : Screen {
    @Composable
    override fun Content() {

        val viewModel = getViewModel<SmsModel>()
        SmsFun(viewModel::onEventDispatcher)
    }


    @Composable
    fun SmsFun(onEventDispatcher: (SmsContract.MyIntent)->Unit) {

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

                            onEventDispatcher(SmsContract.MyIntent.OtpIntent(
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


//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun PhoneFieldSms(
//    phone: String,
//    modifier: Modifier = Modifier,
//    mask: String = "000000",
//    maskNumber: Char = '0',
//    onPhoneChanged: (String) -> Unit
//) {
//    var hasInput by rememberSaveable { mutableStateOf(false) }
//    TextField(
//        value = phone,
//        onValueChange = { it ->
//            onPhoneChanged(it.take(mask.count { it == maskNumber }))
//            hasInput = it.isNotEmpty()
//        },
//        placeholder = if (!hasInput) {
//            { Text(stringResource(id = R.string.msg_txt), color = Anor_grey,fontFamily = FontFamily(Font(R.font.monsbold),
//
//            )) }
//        } else null,
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            containerColor = Anor_light_grey,
//            focusedBorderColor = Anor_light_grey,
//            unfocusedBorderColor = Anor_light_grey
//        ),
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
//        visualTransformation = PhoneVisualTransformationSms(mask, maskNumber),
//        modifier = modifier
//            .padding(end = 8.dp, start = 8.dp)
//
//
//    )
//}
//
//
//class PhoneVisualTransformationSms(val mask: String, val maskNumber: Char) : VisualTransformation {
//
//    private val maxLength = mask.count { it == maskNumber }
//
//    override fun filter(text: AnnotatedString): TransformedText {
//        val trimmed = if (text.length > maxLength) text.take(maxLength) else text
//
//        val annotatedString = buildAnnotatedString {
//            if (trimmed.isEmpty()) return@buildAnnotatedString
//
//            var maskIndex = 0
//            var textIndex = 0
//            while (textIndex < trimmed.length && maskIndex < mask.length) {
//                if (mask[maskIndex] != maskNumber) {
//                    val nextDigitIndex = mask.indexOf(maskNumber, maskIndex)
//                    append(mask.substring(maskIndex, nextDigitIndex))
//                    maskIndex = nextDigitIndex
//                }
//                append(trimmed[textIndex++])
//                maskIndex++
//            }
//        }
//
//        return TransformedText(annotatedString, PhoneOffsetMapper(mask, maskNumber))
//    }
//
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (other !is PhoneVisualTransformationSms) return false
//        if (mask != other.mask) return false
//        if (maskNumber != other.maskNumber) return false
//        return true
//    }
//
//
//    override fun hashCode(): Int {
//        return mask.hashCode()
//    }
//}
//
//private class PhoneOffsetMapper(val mask: String, val numberChar: Char) : OffsetMapping {
//
//    override fun originalToTransformed(offset: Int): Int {
//        var noneDigitCount = 0
//        var i = 0
//        while (i < offset + noneDigitCount) {
//            if (mask[i++] != numberChar) noneDigitCount++
//        }
//        return offset + noneDigitCount
//    }
//
//    override fun transformedToOriginal(offset: Int): Int =
//        offset - mask.take(offset).count { it != numberChar }
//}
//
