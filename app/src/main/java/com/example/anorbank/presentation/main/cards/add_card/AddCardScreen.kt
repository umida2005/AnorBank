package com.example.anorbank.presentation.main.cards.add_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Switch
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
import com.example.anorbank.presentation.main.cards.add_card.components.MyTop
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_light_grey
import com.example.anorbank.utils.spacers.SpacerHSixteen
import com.example.anorbank.utils.spacers.SpacerHTwentyFour
import com.example.anorbank.utils.spacers.SpacerWFourtyEight


class AddCardScreen : Screen {
    @Composable
    override fun Content() {

        val viewModel = getViewModel<AddCardModel>()
        AddingCardFun(viewModel::onEventDispatcher)
    }

}

@Composable
fun AddingCardFun(onEventDispatcher: (AddCardContract.MyIntent) -> Unit) {


    val expiredYear = "2028"
    val expiredMonth = "6"
    val checkedState = remember { mutableStateOf(false) }
    var cardNumber by rememberSaveable { mutableStateOf("") }
    var expire by rememberSaveable { mutableStateOf("") }
    var nameCard by rememberSaveable { mutableStateOf("") }
    var isButtonEnabled = cardNumber.length == 16 && expire.isNotEmpty()
            && nameCard.length > 2
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Anor_light_grey)
    ) {
        MyTop(modifier = Modifier, title = stringResource(id = R.string.add_card_top))

        Spacer(modifier = Modifier.weight(0.8f))
        Card(modifier = Modifier.padding(22.dp)) {

            Column(modifier = Modifier.background(color = Color.White)) {
                SpacerHTwentyFour()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 14.dp)
                        .background(
                            color = Anor_light_grey,
                            shape = RoundedCornerShape(16.dp)
                        ),
                ) {


                    PhoneField(
                        cardNumber,
                        modifier = Modifier
                            .weight(3f)
                            .padding(start = 14.dp, end = 8.dp),
                        mask = "0000 0000 0000 0000",
                        maskNumber = '0',
                        fontik = FontFamily(Font(R.font.monsbold)),
                        onPhoneChanged = { cardNumber = it },
                        hint = stringResource(id = R.string.add_card_number)
                    )

                    Image(
                        modifier = Modifier
                            .weight(0.2f)
                            .align(Alignment.CenterVertically),
                        painter = painterResource(id = R.drawable.ic_scanner),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.weight(0.21f))

                }
                SpacerHSixteen()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 14.dp)
                        .background(color = Anor_light_grey, shape = RoundedCornerShape(16.dp)),
                ) {


                    PhoneField(
                        expire,
                        modifier = Modifier
                            .weight(3f)
                            .padding(start = 14.dp, end = 8.dp),
                        mask = "00 / 00",
                        maskNumber = '0',
                        fontik = FontFamily(Font(R.font.monsbold)),
                        onPhoneChanged = { expire = it },
                        hint = stringResource(id = R.string.add_card_expire)
                    )

                    Spacer(modifier = Modifier.weight(0.3f))

                }
                SpacerHSixteen()

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 14.dp)
                        .background(color = Anor_light_grey, shape = RoundedCornerShape(16.dp)),
                ) {
                    StringInputField(hint = stringResource(id = R.string.add_card_name),
                        text = nameCard,
                        onValueChanged = { newText ->
                            nameCard = newText
                        })
                    Spacer(
                        modifier = Modifier
                            .height(24.dp)
                            .background(color = Anor_light_grey)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp)
                ) {

                    Text(
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .align(Alignment.CenterVertically),
                        fontFamily = FontFamily(Font(R.font.monsbold)),
                        text = stringResource(id = R.string.add_card_anor),
                        fontSize = 13.sp,
                        color = Anor_grey
                    )

                    SpacerWFourtyEight()

                    Switch(
                        checked = checkedState.value, onCheckedChange = {
                            checkedState.value = it
                        }, modifier = Modifier.align(Alignment.CenterVertically)
                        //  .size(width = 90.dp, height = 20.dp),
                    )


                }

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .height(56.dp)
                    .padding(horizontal = 14.dp),
                    enabled = isButtonEnabled,
                    shape = RoundedCornerShape(16.dp),
                    onClick = {

                        onEventDispatcher.invoke(
                            AddCardContract.MyIntent.AddCardData(
                                pan = cardNumber,
                                expireYear = expiredYear,
                                expireMoth = expiredMonth,
                                name = nameCard
                            )
                        )


                    }
                ) {
                    Text(
                        modifier = Modifier.background(color = Color.Transparent),
                        text = stringResource(id = R.string.btn_continue),
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.monsbold))
                    )

                }
                SpacerHTwentyFour()
            }
        }


        Spacer(modifier = Modifier.weight(2.2f))
    }

}

@Preview
@Composable
fun AddCardPrevs() {
    AddingCardFun({})
}