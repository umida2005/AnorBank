package com.example.anorbank.presentation.auth.register.reg

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import com.example.anorbank.R
import com.example.anorbank.presentation.components.PhoneField
import com.example.anorbank.presentation.components.TextCompo
import com.example.anorbank.presentation.components.TextPolicy
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_hinting
import com.example.anorbank.ui.theme.Anor_light_grey

class RegScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<RegModel>()
        RegFun(viewModel::onEventDispatcher)
    }


    @Composable
    fun RegFun(onEventDispatcher: (RegContract.MyIntent) -> Unit) {


        val isChecked = remember { mutableStateOf(false) }
        var phoneNumber by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        val countryCode = "+998"
        val fullNumber = countryCode + phoneNumber


        var name by rememberSaveable { mutableStateOf("") }
        var surName by rememberSaveable { mutableStateOf("") }
        var bornDate = "17072002"
        var gender = "1"


        val isMaleChecked = remember { mutableStateOf(false) }
        val isFemaleChecked = remember { mutableStateOf(false) }

        var isButtonEnabled = phoneNumber.length == 9 && isChecked.value && password.isNotEmpty() &&
                name.isNotEmpty() && surName.isNotEmpty()
        //&& bornDate.isNotEmpty() && (isFemaleChecked.value || isMaleChecked.value)


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Anor_light_grey)
        ) {


            Spacer(modifier = Modifier.weight(0.1f))

            Box(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                TextCompo(
                    modifier = Modifier,
                    FontFamily(Font(R.font.monsbold)),
                    fontSize = 18.sp,
                    stringResource(id = R.string.reg_title)
                )


            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.8f)
                    .padding(horizontal = 24.dp)
                    .clip(shape = RoundedCornerShape(24.dp))
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                ) {


                    Spacer(
                        modifier = Modifier
                            .height(24.dp)
                    )

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
                        PhoneField(
                            phoneNumber,
                            mask = "00 000 00 00",
                            maskNumber = '0',
                            fontik = FontFamily(Font(R.font.monsbold)),
                            onPhoneChanged = { phoneNumber = it },
                            hint = ""
                        )
                    }




                    Spacer(modifier = Modifier.height(8.dp))

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
                    }

                    Spacer(
                        modifier = Modifier
                            .height(8.dp)
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(horizontal = 24.dp)
                            .background(color = Anor_light_grey, shape = RoundedCornerShape(16.dp)),
                    ) {


                        StringInputField(
                            hint = stringResource(id = R.string.reg_name),
                            text = name,
                            onValueChanged = { newText ->
                                name = newText

                            }
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .height(8.dp)
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(horizontal = 24.dp)
                            .background(color = Anor_light_grey, shape = RoundedCornerShape(16.dp)),
                    ) {


                        StringInputField(
                            hint = stringResource(id = R.string.reg_surname),
                            text = surName,
                            onValueChanged = { newText ->
                                surName = newText
                            }
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .height(8.dp)
                    )
//
//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(56.dp)
//                            .padding(horizontal = 24.dp)
//                            .background(color = Anor_light_grey, shape = RoundedCornerShape(16.dp)),
//                    ) {
//
//                        StringInputField(
//                            hint = stringResource(id = R.string.reg_born),
//                            text = bornDate,
//                            onValueChanged = { newText ->
//                                bornDate = newText
//
//                            }
//                        )
//                    }
                    Spacer(
                        modifier = Modifier
                            .height(8.dp)
                    )

//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(56.dp)
//                            .padding(horizontal = 24.dp)
//                    ) {
//
//                        TextCompo(
//                            modifier = Modifier
//                                .weight(1f)
//                                .align(Alignment.CenterVertically),
//                            fontik = FontFamily(Font(R.font.monsbold)),
//                            text = stringResource(
//                                id = R.string.reg_gender
//                            )
//                        )
//                        Image(
//                            modifier = Modifier
//                                .weight(0.5f)
//                                .size(24.dp)
//                                .align(Alignment.CenterVertically),
//                            painter = painterResource(id = R.drawable.male),
//                            contentDescription = null
//                        )
//                        CheckMale(
//                            modifier = Modifier.weight(0.4f),
//                            checked = isMaleChecked.value,
//                            onCheckedChange = {
//                                isMaleChecked.value = it
//                                isFemaleChecked.value = !it
//                            },
//                        )
//                        Image(
//                            modifier = Modifier
//                                .weight(0.5f)
//                                .size(24.dp)
//                                .align(Alignment.CenterVertically),
//                            painter = painterResource(id = R.drawable.female),
//                            contentDescription = null
//                        )
//
//                        CheckFemale(
//                            modifier = Modifier.weight(0.5f),
//                            checked = isFemaleChecked.value,
//                            onCheckedChange = {
//                                isFemaleChecked.value = it
//                                isMaleChecked.value = !it
//                            },
//                        )
//
//                    }

                    Spacer(
                        modifier = Modifier
                            .height(18.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                    ) {
                        CustomCheckbox(
                            modifier = Modifier,
                            checked = isChecked.value,
                            onCheckedChange = { isChecked.value = it },
                        )

                        TextPolicy(
                            modifier = Modifier,
                            fontik = FontFamily(Font(R.font.monsbold)),
                            fontSize = 10.sp,
                            text = stringResource(
                                id = R.string.auth_policy
                            )
                        )

                    }

                    Spacer(
                        modifier = Modifier
                            .height(18.dp)
                    )
                    Button(

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .padding(horizontal = 24.dp),
                        shape = RoundedCornerShape(16.dp),

                        enabled = isButtonEnabled,
                        onClick = {

                            onEventDispatcher(
                                RegContract.MyIntent.Register(
                                    phone = fullNumber,
                                    firstName = name,
                                    lastName = surName,
                                    password = password,
                                    bornDate = bornDate,
                                    gender = gender
                                )
                            )


                        }) {
                        Text(
                            modifier = Modifier.background(color = Color.Transparent),
                            text = stringResource(id = R.string.btn_continue)
                        )

                    }
                }
            }
            Spacer(modifier = Modifier.weight(0.1f))


        }
    }

    @Composable
    @Preview
    fun PhonePreview() {
        RegFun({})
    }


}

@Composable
fun CustomCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,

    ) {
    Checkbox(modifier = modifier, checked = checked, onCheckedChange = onCheckedChange)

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StringInputField(
    hint: String,
    text: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val (currentText, setCurrentText) = remember { mutableStateOf(text) }

    TextField(
        value = currentText,
        onValueChange = { newText ->
            setCurrentText(newText)
            onValueChanged?.invoke(newText)
        },
        placeholder = if (text.isEmpty()) {
            { Text(text = hint, color = Anor_hinting, fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.monsbold))) }
        } else null,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Anor_light_grey,
            focusedBorderColor = Anor_light_grey,
            unfocusedBorderColor = Anor_light_grey
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = modifier.padding(horizontal = 12.dp),
        textStyle = LocalTextStyle.current.copy(color = Anor_grey, fontFamily = FontFamily(Font(R.font.monsbold))
    ))
}


@Composable
fun CheckMale(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,

    ) {
    Checkbox(
        modifier = modifier.padding(top = 3.dp),
        checked = checked,
        onCheckedChange = onCheckedChange
    )

}


@Composable
fun CheckFemale(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,

    ) {
    Checkbox(
        modifier = modifier.padding(top = 3.dp),
        checked = checked,
        onCheckedChange = onCheckedChange
    )

}

