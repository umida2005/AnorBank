package com.example.anorbank.zed.expendables.home_ex


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.anorbank.R
import com.example.anorbank.presentation.main.home.components.ItemData
import com.example.anorbank.presentation.main.home.components.TxtMoney
import com.example.anorbank.presentation.main.home.components.TxtSimpleColor
import com.example.anorbank.ui.theme.AnorBankTheme
import com.example.anorbank.ui.theme.Anor_green
import com.example.anorbank.ui.theme.Anor_green_light
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_hint
import com.example.anorbank.utils.spacers.SpacerHEight
import com.example.anorbank.utils.spacers.SpacerHSixteen
import com.example.anorbank.utils.spacers.SpacerHThirtyTwo
import com.example.anorbank.utils.spacers.SpacerHTwentyFour
import com.example.anorbank.utils.spacers.SpacerWEight

@ExperimentalAnimationApi
@Composable
fun Vkladi() {

    val resources = LocalContext.current.resources
    val itemList = listOf(
        ItemData(img = R.drawable.omonat1, text = resources.getString(R.string.home_item1)),
        ItemData(R.drawable.omonat2, text = resources.getString(R.string.home_item2)),
        ItemData(R.drawable.omonat3, text = resources.getString(R.string.home_item3)),
        ItemData(R.drawable.omonat4, text = resources.getString(R.string.home_item4)),
        ItemData(R.drawable.omonat5, text = resources.getString(R.string.home_item5)),
        ItemData(R.drawable.omonat6, text = resources.getString(R.string.home_item6)),
        ItemData(R.drawable.omonat7, text = resources.getString(R.string.home_item7)),
        ItemData(R.drawable.omonat8, text = resources.getString(R.string.home_item8)),
        ItemData(R.drawable.omonat9, text = resources.getString(R.string.home_item9)))

    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(18.dp))
            .clickable {
                isExpanded = !isExpanded
            }
    ) {
        Column(modifier = Modifier.background(color = Color.White)) {

       SpacerHEight()
            Row(modifier = Modifier.fillMaxWidth()) {
           SpacerWEight()
                Text(
                    text = stringResource(id = R.string.ex_vklad),
                    modifier = Modifier
                        .padding(top = 6.dp, start = 12.dp),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.monsbold)),
                    color = Anor_grey
                )

                if (!isExpanded) {
                    Image(
                        modifier = Modifier
                            .size(42.dp)
                            .padding(12.dp)
                        ,
                        painter = painterResource(id = R.drawable.ic_hamburger),
                        contentDescription = null
                    )
                } else {
                    Image(
                        modifier = Modifier
                            .size(42.dp)
                            .padding(12.dp),
                        painter = painterResource(id = R.drawable.ic_hamburger_bottom),
                        contentDescription = null
                    )
                    Text(
                        text = stringResource(id = R.string.all),
                        modifier = Modifier
                            .padding(top = 11.dp, end = 24.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.End,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.monsbold)),
                        color = Anor_grey
                    )
                }

              //  SpacerHTwentyFour()

            }
            AnimatedVisibility(visible = isExpanded) {
                Column {

                    LazyVkladi(data = itemList)

                   // SpacerHEight()
                }
            }

            SpacerHTwentyFour()
        }


    }

}


@Composable
fun LazyVkladi(data: List<ItemData>) {

    LazyRow {
        items(data){item->
            ItemVkladi(data = item)

        }
    }
}
@Composable
fun ItemVkladi(data: ItemData) {
    Column(modifier = Modifier.padding(horizontal = 6.dp)) {
        Image(
            painter = painterResource(id = data.img),
            contentDescription = data.text,
            modifier = Modifier
                .size(220.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.width(8.dp))
//        Text(
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            textAlign = TextAlign.Center,
//            text = data.text,
//            lineHeight = TextUnit(18f, TextUnitType.Sp),
//            color = Color.White,
//            fontSize = 12.sp,
//            fontFamily = FontFamily(Font(R.font.monsbold))
//
//
//        )
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview
fun VkladiPrev() {
    AnorBankTheme {
        Vkladi()
    }
}

