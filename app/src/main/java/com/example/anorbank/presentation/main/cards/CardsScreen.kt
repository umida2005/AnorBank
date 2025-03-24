//package com.example.anorbank.presentation.main.cards

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.example.anorbank.R
import com.example.anorbank.ui.theme.Anor_dark
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.hilt.getViewModel
import com.example.anorbank.data.model.remote.response.card_response.GetCardResponse
import com.example.anorbank.presentation.components.TextCompoRed
import com.example.anorbank.presentation.main.cards.CardContract
import com.example.anorbank.presentation.main.cards.CardModel
import com.example.anorbank.presentation.main.cards.item_cards.BigCard
import com.example.anorbank.presentation.main.home.MainContract
import com.example.anorbank.presentation.main.home.components.Item
import com.example.anorbank.presentation.main.home.components.ItemData
import com.example.anorbank.presentation.main.payment.transaction.TransactionContract
import com.example.anorbank.presentation.main.payment.transaction.TransactionModel
import com.example.anorbank.ui.theme.Anor_black_medium
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_hint
import com.example.anorbank.utils.spacers.SpacerHEight
import com.example.anorbank.utils.spacers.SpacerHSixteen
import com.example.anorbank.utils.spacers.SpacerHThirtyTwo
import com.example.anorbank.utils.spacers.SpacerHTwentyFour
import com.example.anorbank.utils.spacers.SpacerWEight
import com.example.anorbank.zed.expendables.home_ex.AddCardsss
import org.orbitmvi.orbit.compose.collectAsState

// Your Screen class
class CardsScreens : Screen {
    private var listCard = ArrayList<GetCardResponse>()

    @Composable
    override fun Content() {
        val viewModel = getViewModel<CardModel>()
        var uiState = viewModel.collectAsState()
        CardFuns(viewModel::onEventDispatcher, uiState = uiState.value)
        listCard = uiState.value.myCardList
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CardFuns(
        onEventDispatcher: (CardContract.MyIntent) -> Unit,
        uiState: CardContract.UiState
    ) {

        val listImg = listOf(
            ItemData(R.drawable.ic_debit1, ""),
            ItemData(R.drawable.ic_debit2, ""),
            ItemData(R.drawable.ic_debit3, ""),
            ItemData(R.drawable.ic_debit4, ""),
        )


        var selectedIndex by remember { mutableStateOf(0) }
        val items = listOf(
            stringResource(id = R.string.cards_all),
            stringResource(id = R.string.cards_debet),
            stringResource(id = R.string.carda_packet),
            stringResource(id = R.string.cards_transport),

        )

        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_back_toolbar),
                        contentDescription = "App Bar Background",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(45.dp)
                    )
                    androidx.compose.material3.TopAppBar(
                        modifier = Modifier.fillMaxWidth(),
                        title = {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.Center),
                                text = stringResource(id = R.string.card_my),
                                color = Color.White,
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.monsbold)),
                                textAlign = TextAlign.Center
                            )
                        },
                        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent)
                    )
                }
            }) { paddingValues ->
            Box(
                modifier = Modifier
                    .background(color = Anor_dark)
                    .padding(paddingValues)
                    .clip(shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.White)
                            .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    ) {
                        LazyRow(
                            modifier = Modifier
                                .weight(5f)
                                .padding(start = 12.dp, top = 8.dp, bottom = 8.dp)
                        ) {
                            itemsIndexed(items) { index, text ->
                                ScrollItemsMine(
                                    onClick = {
                                        selectedIndex = index
                                    },
                                    text = text,
                                    index = index,
                                    isSelected = index == selectedIndex
                                )
                            }
                        }

                        Image(
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically)
                                .size(24.dp)
                                .clickable {
                                           onEventDispatcher.invoke(CardContract.MyIntent.OpenCardScreen)
                                },
                            painter = painterResource(id = R.drawable.ic_card_pus),
                            contentDescription = null
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.White)
                    ) {
                        Log.d("as", "dsasddssaas${listImg.size}")
                        when (selectedIndex) {
                            0 -> Vse()
                            1 -> Debetoviye(listCard, listImg)
                            2 -> Wallet()
                            3->Transportniye()
                            else -> Vse()
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun ScrollItems(onClick: () -> Unit, text: String, index: Int, isSelected: Boolean) {
    Text(
        text = text,
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick)
            .background(if (isSelected) Color.Gray else Color.Transparent),
        color = if (isSelected) Color.White else Color.Black
    )
}
@Composable
fun ScrollItemsMine(onClick: () -> Unit, text: String, index: Int, isSelected: Boolean) {

    Box(modifier = Modifier
        .padding(2.dp)
        .clip(shape = RoundedCornerShape(12.dp))
        .clickable(onClick = onClick)
        .background(if (isSelected) Anor_dark else Anor_hint)

    ){
        Text(modifier = Modifier.padding(8.dp),
            text = text,
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.monsbold)),
            color = if (isSelected) Color.White else Anor_black_medium
        )
    }

}

@Composable
fun Vse() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                fontFamily = FontFamily(Font(R.font.monsbold)),
                color = Anor_grey,
                text = stringResource(id = R.string.cards_cards)
            )
            Spacer(modifier = Modifier.weight(2f))

            Row (modifier = Modifier.weight(1f)){
                Image(modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(18.dp),
                    painter = painterResource(id = R.drawable.ic_reloading),
                    contentDescription =null,
                    colorFilter = ColorFilter.tint(Anor_dark))
                Spacer(modifier = Modifier.weight(0.3f))

                Image(modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(18.dp),
                    painter = painterResource(id = R.drawable.ic_equality),
                    contentDescription =null )
                Spacer(modifier = Modifier.weight(0.3f))
                Image(modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(18.dp),
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription =null )
                Spacer(modifier = Modifier.weight(0.3f))
            }
        }
    }

    //Debetoviye()
}

@Composable

fun Debetoviye(dataList: List<GetCardResponse>, imgList: List<ItemData>) {

//    val listItem = listOf(
//        ItemData()
//    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        LazyRow(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            items(dataList) { card ->
                BigCard(
                    name = card.name,
                    amount = card.amount,
                    pan = card.pan
                )
            }
        }


        SpacerHTwentyFour()

        Row (modifier = Modifier.fillMaxWidth()){
            Spacer(modifier = Modifier.weight(0.1f))
            Image(modifier = Modifier.weight(1f),
                painter = painterResource(id = R.drawable.new1),
                contentDescription =null )
            Spacer(modifier = Modifier.weight(0.1f))
            Image(modifier = Modifier.weight(1f),
                painter = painterResource(id = R.drawable.new2),
                contentDescription =null )
            Spacer(modifier = Modifier.weight(0.1f))
            Image(modifier = Modifier.weight(1f),
                painter = painterResource(id = R.drawable.new3),
                contentDescription =null )
            Spacer(modifier = Modifier.weight(0.1f))
            Image(modifier = Modifier.weight(1f),
                painter = painterResource(id = R.drawable.new4),
                contentDescription =null )
            Spacer(modifier = Modifier.weight(0.1f))
        }
//        LazyRow(
//            modifier = Modifier
//        ) {
//            items(imgList) { img ->
//                Item(
//                    data = img
//                )
//            }
//        }

    }
}
















@Composable
fun Transportniye() {
    Column {
        SpacerHThirtyTwo()
        Text(modifier=Modifier.align(Alignment.CenterHorizontally),
            fontFamily = FontFamily(Font(R.font.monsbold)),
            color = Anor_grey,
            text = stringResource(id = R.string.carda_sms))
        SpacerHThirtyTwo()
        AddCardss({})
    }
}

@Composable
fun Wallet() {
   Column {
       SpacerHThirtyTwo()
       Text(modifier=Modifier.align(Alignment.CenterHorizontally),
           fontFamily = FontFamily(Font(R.font.monsbold)),
           color = Anor_grey,
           text = stringResource(id = R.string.carda_sms_wallet))
       SpacerHThirtyTwo()
       AddCardss({})
   }
}


@Preview
@Composable
fun CardScreenPreview() {
}
@Composable
fun AddCardss(onEventDispatcher :(MainContract.MyIntent)->Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    onEventDispatcher.invoke(MainContract.MyIntent.OpenAddCard)
                }
                .align(Alignment.TopCenter)
        ) {
            Image(modifier = Modifier
                .size(18.dp)
                .clickable {
                    onEventDispatcher.invoke(MainContract.MyIntent.OpenAddCard)
                },
                painter = painterResource(id = R.drawable.ic_add_card),

                contentDescription = null,


                )
            SpacerWEight()
            TextCompoRed(modifier = Modifier
                .clickable {
                    onEventDispatcher.invoke(MainContract.MyIntent.OpenAddCard)
                },
                fontSize = 14.sp,
                fontik = FontFamily(Font(R.font.monsbold)),
                text = stringResource(id = R.string.add_cards)
            )
        }
    }
}



