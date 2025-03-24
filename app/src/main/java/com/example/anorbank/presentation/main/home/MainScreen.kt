package com.example.anorbank.presentation.main.home

import android.annotation.SuppressLint
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.anorbank.R
import com.example.anorbank.data.model.remote.response.card_response.GetCardResponse
import com.example.anorbank.presentation.main.home.components.ItemData
import com.example.anorbank.presentation.main.home.components.LazyInTop
import com.example.anorbank.presentation.main.home.components.Tops
import com.example.anorbank.presentation.main.home.components.TxtSimpleWhite
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.utils.spacers.SpacerHSixteen
import com.example.anorbank.utils.spacers.SpacerHThirtyTwo
import com.example.anorbank.zed.expendables.home_ex.CashBack
import com.example.anorbank.zed.expendables.home_ex.Credits
import com.example.anorbank.zed.expendables.home_ex.MyCard2
import com.example.anorbank.zed.expendables.home_ex.MyHome
import com.example.anorbank.zed.expendables.home_ex.Podskazki
import com.example.anorbank.zed.expendables.home_ex.Rassrochki
import com.example.anorbank.zed.expendables.home_ex.Saves
import com.example.anorbank.zed.expendables.home_ex.Valyuta
import com.example.anorbank.zed.expendables.home_ex.Vkladi
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

class MainScreen : Screen {
    var newBalance: String? = null

    var list = ArrayList<GetCardResponse>()

    @SuppressLint("ShowToast")
    @RequiresApi(Build.VERSION_CODES.Q)
    @Composable
    override fun Content() {
        val totalBalance = remember {
            mutableStateOf("")
        }

        newBalance = totalBalance.toString()
        val cardList = remember { mutableStateOf(0) }
        val context = LocalContext.current
        val viewModel = getViewModel<MainModel>()
        cardList.value = viewModel.list.size

        MainsFun(viewModel::onEventDispatcher, viewModel.collectAsState().value)

        viewModel.collectSideEffect {
            when (it) {
                is MainContract.SideEffect.Toast -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT)
                }
            }
        }

        SideEffect {
            viewModel.loadAllCards()
        }


    }

    @OptIn(ExperimentalAnimationApi::class)
    @RequiresApi(Build.VERSION_CODES.Q)
    @Composable
    fun MainsFun(
        onEventDispatcher: (MainContract.MyIntent) -> Unit,
        uiState: MainContract.UiState
    ) {

        val composition by rememberLottieComposition(LottieCompositionSpec.Asset("my_lottie.json"))



        when (uiState) {
            is MainContract.UiState.CardLists -> {
                list = uiState.cards as ArrayList<GetCardResponse>
            }

            else -> {}
        }
        var sum=0;
        for (i in 0 until list.size){
            sum+=list[i].amount
        }


        val resources = LocalContext.current.resources
        val itemList = listOf(
            ItemData(img = R.drawable.item_1, text = resources.getString(R.string.home_item2)),
            ItemData(R.drawable.item_3, text = resources.getString(R.string.home_item6)),
            ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item4)),
            ItemData(R.drawable.item_5, text = resources.getString(R.string.home_item1)),
            ItemData(R.drawable.item_mejdunarodniye, text = resources.getString(R.string.home_item11)),
            ItemData(R.drawable.item_pogasheniye, text = resources.getString(R.string.home_item10)),
            ItemData(R.drawable.item_zapros, text = resources.getString(R.string.home_item8)),
            ItemData(R.drawable.item_rassrochki, text = resources.getString(R.string.home_item9)),
            ItemData(R.drawable.item_humo, text = resources.getString(R.string.home_item12)),
            ItemData(R.drawable.item_qr, text = resources.getString(R.string.home_item5)),
            ItemData(R.drawable.item_anor, text = resources.getString(R.string.home_item3)),

            )
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                Tops(onEventDispatcher)
            }) {



            LazyColumn(modifier = Modifier.padding(it)) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(240.dp)
                            .clip(
                                shape = RoundedCornerShape(
                                    bottomStart = 32.dp,
                                    bottomEnd = 32.dp
                                )
                            )
                    ) {
                        Image(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .fillMaxSize(),
                            painter = painterResource(id = R.drawable.ic_backgound),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )

                        LottieAnimation(
                            composition = composition,
                            iterations = LottieConstants.IterateForever,
                            modifier = Modifier.fillMaxSize(),
                            isPlaying = true,
                            restartOnPlay = true
                        )
                        Column(modifier = Modifier.fillMaxSize()) {

                            SpacerHSixteen()
                            TxtSimpleWhite(
                                modifier = Modifier.padding(start = 24.dp),
                                text = "",
                                fontSize = 16.sp,
                                fontik = FontFamily(Font(R.font.monsbold))
                            )
                            SpacerHSixteen()
                            var sum=0;
                            for (i in 0 until list.size){
                                sum+=list[i].amount
                            }
                            TxtSimpleWhite(
                                modifier = Modifier.padding(start = 24.dp),
                                text = "",
                                fontSize = 16.sp,
                                fontik = FontFamily(Font(R.font.monsbold))
                            )

                            LazyInTop(data = itemList)
                            SpacerHThirtyTwo()

                        }
                    }
                }
                item {
                    ClientItem()
                }
                item {
                    CashBack()
                }

                item {
                    Podskazki()
                }

                item {
                    MyCard2(onEventDispatcher, uiState)
                }

                item {
                    Saves()
                }

                item {
                    Rassrochki()
                }

                item {
                    Credits()
                }

                item {
                    Vkladi()
                }

                item {
                    MyHome()
                }

                item {
                    Valyuta()
                }

            }

        }
    }

}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
fun PrevMains() {

}


@Composable
fun ClientItem() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
            .height(102.dp)
            .clip(shape = RoundedCornerShape(16.dp))
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_become_client),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )




        Text(
            modifier = Modifier.align(Alignment.Center),
            text = stringResource(id = R.string.client), fontSize = 16.sp,
            color = Anor_grey,
            fontFamily = FontFamily(Font(R.font.monsbold))
        )

    }

}
