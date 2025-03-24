package com.example.anorbank.presentation.main.payment.transaction

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.graphics.graphicsLayer
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
import com.example.anorbank.data.model.remote.response.card_response.GetCardResponse
import com.example.anorbank.data.source.dataUI.GetReceiverCardData
import com.example.anorbank.presentation.components.PhoneField
import com.example.anorbank.presentation.components.TextCompo
import com.example.anorbank.presentation.components.TextCompoRed
import com.example.anorbank.presentation.main.cards.add_card.components.MyTop
import com.example.anorbank.presentation.main.cards.item_cards.ItemPrimaryFun
import com.example.anorbank.presentation.main.payment.transaction.components.AmountMoney
import com.example.anorbank.presentation.main.payment.transaction.components.ItemPayment
import com.example.anorbank.presentation.main.payment.transaction.components.ItemSelectedTransaction
import com.example.anorbank.presentation.main.payment.transaction.components.ItemTransaction
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_light_grey
import com.example.anorbank.utils.spacers.SpacerHEight
import com.example.anorbank.utils.spacers.SpacerHSixteen
import com.example.anorbank.utils.spacers.SpacerHTwentyFour
import com.example.anorbank.utils.spacers.SpacerWSixteen
import org.orbitmvi.orbit.compose.collectAsState


class TransactionScreen : Screen {
    private var listCard = ArrayList<GetCardResponse>()

    @Composable
    override fun Content() {
        val viewModel = getViewModel<TransactionModel>()
        var uiState = viewModel.collectAsState()

        TransactonFuns(viewModel::onEventDispatcher, uiState = uiState.value)
        listCard=uiState.value.cardList
    }

    @SuppressLint("SuspiciousIndentation")
    @Composable
    fun TransactonFuns(
        onEventDispatcher: (TransactionContract.MyIntent) -> Unit,
        uiState: TransactionContract.UiState
    ) {
        var cardNumber by rememberSaveable { mutableStateOf("") }
        var senderId by rememberSaveable { mutableStateOf("") }
        var amount by rememberSaveable { mutableStateOf("") }
        var isButtonEnabled =   uiState.state &&amount.isNotEmpty()
        var selectedCardIndex by remember { mutableStateOf(-1) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            MyTop(modifier = Modifier, title = stringResource(id = R.string.transaction_top))
            SpacerHSixteen()

            if (uiState.state) {
                ItemPrimaryFun(name = "", pan = uiState.card.pan, amount = 0)


                Card(modifier = Modifier.clip(shape = RoundedCornerShape(32.dp))) {

                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .background(color = Color.White)
                    ) {
                        TextCompo(
                            modifier = Modifier.padding(start = 12.dp),
                            fontSize = 14.sp,
                            fontik = FontFamily(Font(R.font.mons_regular)),
                            text = stringResource(id = R.string.transaction_among)
                        )
                        SpacerHEight()


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


                            AmountMoney(
                                amount,
                                modifier = Modifier
                                    .weight(3f)
                                    .padding(start = 14.dp, end = 8.dp),
                                mask = "000.000.000",
                                maskNumber = '0',
                                fontik = FontFamily(Font(R.font.monsbold)),
                                onPhoneChanged = { amount = it },
                                hint = ""
                            )

                            Image(
                                modifier = Modifier
                                    .weight(0.2f)
                                    .graphicsLayer(rotationZ = 180f)
                                    .align(Alignment.CenterVertically),
                                painter = painterResource(id = R.drawable.ic_magnet),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.weight(0.21f))

                        }

                        Log.d("bbb", "Clicked card id: ")
                        SpacerHTwentyFour()
                        listCard.forEachIndexed{index, card ->
                            ItemTransaction(name = card.name, pan = card.pan, amount = card.amount,
                                onClicks = {
                                    senderId = card.id.toString()

                                    onEventDispatcher.invoke(TransactionContract.MyIntent.Data(
                                        senderName = card.name, senderPan = card.pan
                                    ))
                                })

                        }
                    }

                    Column(modifier = Modifier.fillMaxWidth()) {

                        Row(modifier = Modifier.fillMaxWidth()) {

                            TextCompo(
                                modifier = Modifier.padding(start = 12.dp),
                                fontSize = 12.sp,
                                fontik = FontFamily(Font(R.font.mons_regular)),
                                text = stringResource(id = R.string.transaction_amounts)
                            )
                        }
                        SpacerHEight()
                        Row(modifier = Modifier.fillMaxWidth()) {

                            TextCompo(
                                modifier = Modifier.padding(start = 12.dp),
                                fontSize = 12.sp,
                                fontik = FontFamily(Font(R.font.mons_regular)),
                                text = stringResource(id = R.string.transaction_comission)
                            )
                        }
                        SpacerHEight()
                        Row(modifier = Modifier.fillMaxWidth()) {

                            TextCompoRed(
                                modifier = Modifier.padding(start = 12.dp),
                                fontSize = 14.sp,
                                fontik = FontFamily(Font(R.font.mons_regular)),
                                text = stringResource(id = R.string.transaction_total)
                            )
                        }
                    }
                    SpacerHSixteen()
                }

                SpacerHTwentyFour()
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .height(56.dp)
                    .padding(horizontal = 14.dp),
                    enabled = isButtonEnabled,
                    shape = RoundedCornerShape(16.dp),
                    onClick = {

                        onEventDispatcher.invoke(TransactionContract.MyIntent.TransferMoney(
                            type = "third-card",
                            senderId = senderId,
                            receiverPan = cardNumber,
                            amount = amount.toInt()

                        ))
                    }
                ) {
                    Text(
                        modifier = Modifier.background(color = Color.Transparent),
                        text = stringResource(id = R.string.btn_continue),
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.monsbold))
                    )

                }

            } else {
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
                        hint = stringResource(id = R.string.transaction_receiving)
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
                Card(modifier = Modifier.clip(shape = RoundedCornerShape(32.dp))) {

                    Column(modifier = Modifier.background(color = Color.White)) {
                        SpacerHTwentyFour()


                        SpacerHSixteen()

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
                            SpacerWSixteen()

                            Image(
                                modifier = Modifier.align(Alignment.CenterVertically),
                                painter = painterResource(id = R.drawable.ic_tab_cards_def),
                                contentDescription = null
                            )

                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .weight(3f)
                                    .padding(start = 14.dp, end = 8.dp),
                                text = stringResource(id = R.string.transaction_among),
                                color = Anor_grey,
                                fontFamily = FontFamily(Font(R.font.monsbold))
                            )

                            Image(
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.CenterVertically),
                                painter = painterResource(id = R.drawable.ic_hamburger_def),
                                contentDescription = null
                            )

                            Spacer(modifier = Modifier.weight(0.3f))

                        }
                        SpacerHSixteen()


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
                            SpacerWSixteen()

                            Image(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .size(32.dp),
                                painter = painterResource(id = R.drawable.ic_star_def),
                                contentDescription = null
                            )

                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .weight(3f)
                                    .padding(start = 14.dp, end = 8.dp),
                                text = stringResource(id = R.string.transaction_saved),
                                color = Anor_grey,
                                fontFamily = FontFamily(Font(R.font.monsbold))
                            )
                            Image(
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.CenterVertically),
                                painter = painterResource(id = R.drawable.ic_hamburger_def),
                                contentDescription = null
                            )

                            Spacer(modifier = Modifier.weight(0.3f))

                        }

                        SpacerHTwentyFour()
                    }
                }
            }
        }
        if (cardNumber.length == 16) {
            onEventDispatcher.invoke(
                TransactionContract.MyIntent.GetReceiver(
                    GetReceiverCardData(
                        cardNumber
                    )
                )
            )
        }
        SpacerHSixteen()
    }
}


@Preview
@Composable
fun TransactionPrevs() {
//    TransactonFuns(onEventDispatcher = {}, uiState = remember {
//        mutableStateOf(TransactionContract.UiState())
//    })
}


