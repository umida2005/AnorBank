package com.example.anorbank.presentation.main.payment.transfer_success

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import com.example.anorbank.R
import com.example.anorbank.presentation.components.TextCompo
import com.example.anorbank.presentation.components.TextCompoRed
import com.example.anorbank.ui.theme.Anor_hinting
import com.example.anorbank.utils.spacers.SpacerHEight
import com.example.anorbank.utils.spacers.SpacerHFourtyEight
import com.example.anorbank.utils.spacers.SpacerHSixteen
import kotlin.reflect.KFunction1

class SuccessTransferScreen : Screen {
    var senderName: String? = null
    var senderPan: String? = null
    var receiverName: String? = null
    var receiverPan: String? = null
    var amount: String? = null
    var realAmount: String? = null

    @Composable
    override fun Content() {


        val viewModel = getViewModel<SuccessModel>()
        senderName = viewModel.extra().senderName
        senderPan = viewModel.extra().senderPan
        receiverName = viewModel.extra().receiverName
        receiverPan = viewModel.extra().receiverPan
        amount = viewModel.extra().totalAmount
        realAmount = amount + 500
        SuccessTransfer(viewModel::onEventDispatcher)
    }


    @Composable
    fun SuccessTransfer(onEventDispatcher: KFunction1<SuccessContract.MyIntent, Unit>) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {

            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .border(
                        width = 0.3.dp,
                        color = Anor_hinting,
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {

                SpacerHFourtyEight()
                Image(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.only_anor),
                    contentDescription = null
                )

                Image(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.ic_success),
                    contentDescription = null
                )

                TextCompoRed(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontik = FontFamily(Font(R.font.monsbold)),
                    text = stringResource(id = R.string.success_success)
                )

                amount?.let {
                    TextCompo(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        fontik = FontFamily(Font(R.font.monsbold)),
                        text = it
                    )
                }

                SpacerHSixteen()

            }
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .border(
                        width = 0.3.dp,
                        color = Anor_hinting,
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {

                Column(modifier = Modifier.padding(start = 16.dp)) {
                    SpacerHEight()

                TextCompo(modifier = Modifier,
                    fontSize =12.sp ,
                    fontik = FontFamily(Font(R.font.mons_regular)),
                    text = stringResource(id = R.string.success_sender_name) )

                                   senderName?.let {
                    TextCompo(modifier = Modifier,
                        fontik = FontFamily(Font(R.font.monsbold)),
                        text = it
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))



                TextCompo(modifier = Modifier,
                    fontSize =12.sp ,
                    fontik = FontFamily(Font(R.font.mons_regular)),
                    text = stringResource(id = R.string.success_sender_pan) )

                senderPan?.let {
                    TextCompo(modifier = Modifier,
                        fontik = FontFamily(Font(R.font.monsbold)),
                        text = it
                    )
                }
                    Spacer(modifier = Modifier.height(4.dp))


                    //receiver
                    TextCompo(
                        modifier = Modifier,
                        fontSize = 12.sp,
                        fontik = FontFamily(Font(R.font.mons_regular)),
                        text = stringResource(id = R.string.success_receiver_name)
                    )

                    receiverName?.let {
                        TextCompo(
                            modifier = Modifier,
                            fontik = FontFamily(Font(R.font.monsbold)),
                            text = it
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))



                    TextCompo(
                        modifier = Modifier,
                        fontSize = 12.sp,
                        fontik = FontFamily(Font(R.font.mons_regular)),
                        text = stringResource(id = R.string.success_receiver_pan)
                    )

                    receiverPan?.let {
                        TextCompo(
                            modifier = Modifier,
                            fontik = FontFamily(Font(R.font.monsbold)),
                            text = it
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))


                    //summa
                    TextCompo(
                        modifier = Modifier,
                        fontSize = 12.sp,
                        fontik = FontFamily(Font(R.font.mons_regular)),
                        text = stringResource(id = R.string.success_valyuta)
                    )

                    TextCompo(
                        modifier = Modifier,
                        fontik = FontFamily(Font(R.font.monsbold)),
                        text = "1 000"
                    )
                    Spacer(modifier = Modifier.height(4.dp))


                    //comissiya
                    TextCompo(
                        modifier = Modifier,
                        fontSize = 12.sp,
                        fontik = FontFamily(Font(R.font.mons_regular)),
                        text = stringResource(id = R.string.success_commission)
                    )

                    TextCompo(
                        modifier = Modifier,
                        fontik = FontFamily(Font(R.font.monsbold)),
                        text = "5 000 UZS"
                    )
                    Spacer(modifier = Modifier.height(4.dp))


                    // amount
                    TextCompo(
                        modifier = Modifier,
                        fontSize = 12.sp,
                        fontik = FontFamily(Font(R.font.mons_regular)),
                        text = stringResource(id = R.string.success_amount)
                    )

                    TextCompo(
                        modifier = Modifier,
                        fontik = FontFamily(Font(R.font.monsbold)),
                        text = realAmount.toString()
                    )
                    SpacerHEight()


                    Button(

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .padding(horizontal = 24.dp),
                        shape = RoundedCornerShape(16.dp),

                        onClick = {
                            onEventDispatcher.invoke(SuccessContract.MyIntent.Intent)
                        }){
                        Text(
                            modifier = Modifier.background(color = Color.Transparent),
                            text = stringResource(id = R.string.btn_continue)
                        )
                    }

                }

            }

        }
    }
}

//@Preview
//@Composable
//fun SuccessPrev() {
//    SuccessTransfer()
//
//}