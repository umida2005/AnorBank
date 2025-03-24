package com.example.anorbank.presentation.main.payment

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import com.example.anorbank.R
import com.example.anorbank.presentation.components.TextCompo
import com.example.anorbank.presentation.main.payment.componenets.ItemsPay
import com.example.anorbank.presentation.main.payment.componenets.LazyInTops
import com.example.anorbank.presentation.main.payment.componenets.ScrollItems
import com.example.anorbank.presentation.main.payment.componenetsimport.SearchBar
import com.example.anorbank.ui.theme.Anor_black_medium
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_hint
import com.example.anorbank.utils.spacers.SpacerHEight
import com.example.anorbank.utils.spacers.SpacerHSixteen

class PaymentScreen : Screen {

    @SuppressLint("SuspiciousIndentation")
    @Composable
    override fun Content() {
        val viewModel =  getViewModel<PaymentModel>()

            PaymentFuns(viewModel::onEventDispatcher)

    }
}

@Composable
fun PaymentFuns(onEventDispatcher: (PaymentContract.MyIntent) -> Unit) {
    var currentContent by remember { mutableStateOf<List<ImgsInGrid>>(emptyList()) }
    var selectedIndex by remember { mutableStateOf(0) }

    val resources = LocalContext.current.resources

    val itemList = listOf(
        ItemsPay(img = R.drawable.ic_new1, text = resources.getString(R.string.home_item2)),
        ItemsPay(img = R.drawable.ic_new2, text = resources.getString(R.string.home_item4)),
        ItemsPay(img = R.drawable.ic_new3, text = resources.getString(R.string.home_item3)),
        ItemsPay(img = R.drawable.ic_new4, text = resources.getString(R.string.home_item5                                                                                                           )),
        ItemsPay(img = R.drawable.ic_new5, text = resources.getString(R.string.home_item7   )),
        ItemsPay(img = R.drawable.ic_new6, text = resources.getString(R.string.home_item13)),
        ItemsPay(img = R.drawable.ic_new7, text = resources.getString(R.string.home_item10)),

        )
    val imgsCashback = listOf(
        ImgsInGrid(R.drawable.pay1),
        ImgsInGrid(R.drawable.pay2),
        ImgsInGrid(R.drawable.pay3),
        ImgsInGrid(R.drawable.pay4),
        ImgsInGrid(R.drawable.pay5),
        ImgsInGrid(R.drawable.pay6),
        ImgsInGrid(R.drawable.pay7),
        ImgsInGrid(R.drawable.pay8),
        ImgsInGrid(R.drawable.pay9),
        ImgsInGrid(R.drawable.pay10),
        ImgsInGrid(R.drawable.pay11),
        ImgsInGrid(R.drawable.pay12),
        ImgsInGrid(R.drawable.pay13),

    )

    val imgPayment = listOf(
        ImgsInGrid(R.drawable.pay14),
        ImgsInGrid(R.drawable.pay15),
        ImgsInGrid(R.drawable.pay16),
        ImgsInGrid(R.drawable.pay17),
        ImgsInGrid(R.drawable.pay18),
        ImgsInGrid(R.drawable.pay19),
        ImgsInGrid(R.drawable.pay20),
        ImgsInGrid(R.drawable.pay21),
        ImgsInGrid(R.drawable.pay22),
        ImgsInGrid(R.drawable.pay23),
        ImgsInGrid(R.drawable.pay24),
        ImgsInGrid(R.drawable.pay25),

    )

    val all = imgPayment + imgsCashback
    val s1 = stringResource(id = R.string.pays_all)
    val s2 =  stringResource(id = R.string.pays_cash)
    val s3 =  stringResource(id = R.string.pays_)
    val items = listOf(s1, s2, s3)


    currentContent = all

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { SearchBar() }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(top = 5.dp)
        ) {
            LazyColumn(content = {
                item {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        fontFamily = FontFamily(Font(R.font.monsbold)),
                        color = Anor_black_medium,
                        text = stringResource(id = R.string.pays_operations)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                item {
                    LazyInTops(data = itemList){
                        if(it==0){

                            onEventDispatcher.invoke(PaymentContract.MyIntent.openTransfer)
                        }
                    }
                }
                item {
                    Column {
                        SpacerHSixteen()
                        Text(
                            modifier = Modifier.padding(start = 16.dp),
                            fontFamily = FontFamily(Font(R.font.monsbold)),
                            color = Anor_black_medium,
                            text = stringResource(id = R.string.pays_extra)
                        )
                        SpacerHEight()
                        LazyRow(modifier =Modifier.padding(start = 12.dp)) {
                            itemsIndexed(items) { index, text ->
                                ScrollItems(
                                    onClick = {
                                        selectedIndex = index
                                        currentContent = when (index) {
                                            0 -> all
                                            1 -> imgsCashback
                                            2 -> imgPayment
                                            else -> all
                                        }
                                    },
                                    text = text,
                                    index = index
                                )
                            }
                        }
                        SpacerHEight()
                    }
                }
            })
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(3),
                modifier = Modifier.padding(bottom = 56.dp),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalItemSpacing = 8.dp
            ) {
                currentContent.forEach {
                    item {
                        GridItemContainer(it)
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
fun PrevMains() {
    PaymentFuns({})
}

data class ImgsInGrid(
    val img: Int
)

@Composable
fun GridItemContainer(data: ImgsInGrid) {
    Box(modifier = Modifier) {

        Image(painter = painterResource(id = data.img),
            contentDescription = null)
    }
}



