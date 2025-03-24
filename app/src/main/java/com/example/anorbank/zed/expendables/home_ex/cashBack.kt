package com.example.anorbank.zed.expendables.home_ex


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.anorbank.R
import com.example.anorbank.presentation.main.home.components.TxtMoney
import com.example.anorbank.presentation.main.home.components.TxtSimpleColor
import com.example.anorbank.ui.theme.AnorBankTheme
import com.example.anorbank.ui.theme.Anor_dark
import com.example.anorbank.ui.theme.Anor_green
import com.example.anorbank.ui.theme.Anor_green_light
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_hint
import com.example.anorbank.ui.theme.Anor_hinting
import com.example.anorbank.ui.theme.Anor_white
import com.example.anorbank.utils.spacers.SpacerHEight
import com.example.anorbank.utils.spacers.SpacerHSixteen
import com.example.anorbank.utils.spacers.SpacerHThirtyTwo
import com.example.anorbank.utils.spacers.SpacerHTwentyFour
import com.example.anorbank.utils.spacers.SpacerWEight

class ExpandabeScreen : Screen {
    @Composable
    override fun Content() {

    }
}


@ExperimentalAnimationApi
@Composable
fun CashBack() {

    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .clickable {
                isExpanded = !isExpanded
            }.background(color = Anor_white)
    ) {
        Column(modifier = Modifier.background(color = Anor_white)) {

            SpacerHEight()
            Row(modifier = Modifier.fillMaxWidth()) {
                SpacerWEight()
                Text(
                    text = stringResource(id = R.string.ex_cash),
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
                }

            }
            AnimatedVisibility(visible = isExpanded) {
                Column {

                    CashFrame()
                    SpacerHSixteen()
                }
            }

            SpacerHTwentyFour()
        }


    }

}


@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview
fun CashExPrev() {
    AnorBankTheme {
        //CashBack()
        CashFrame()
    }
}

@Composable
fun CashFrame() {
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .border(
                width = 1.dp,
                color = Anor_hinting,
                shape = RoundedCornerShape(12.dp)
            )
            .background(color = Anor_white)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string.ex_cash),
                modifier = Modifier
                    .weight(0.8f)
                    .padding(top = 24.dp, start = 16.dp),
                fontSize = 16.sp,
                color = Anor_grey,
                fontFamily = FontFamily(Font(R.font.monsbold))
            )
            Percentage(
                modifier = Modifier
                    .padding(top = 18.dp, end = 14.dp)
                    .weight(0.2f)
            )


        }
        Text(
            text = stringResource(id = R.string.ex_cash_nakopleno),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp),
            color = Anor_hinting,
            fontFamily = FontFamily(Font(R.font.monsbold)),
            fontSize = 11.sp
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            TxtMoney(
                modifier = Modifier.padding(start = 12.dp),
                fontik = FontFamily(Font(R.font.monsbold)),
                text = "0", fontSize = 18.sp,
                color = Anor_green
            )

            SpacerWEight()
            TxtMoney(
                modifier = Modifier.padding(start = 12.dp),
                fontik = FontFamily(Font(R.font.monsbold)),
                text = "UZS", fontSize = 18.sp,
                color = Anor_green
            )
        }

        SpacerHSixteen()


    }
}

@Composable
fun Percentage(modifier: Modifier) {

    Row(
        modifier = modifier

            .clip(shape = RoundedCornerShape(18.dp))
            .background(color = Anor_green_light)
    ) {
        SpacerWEight()

        TxtSimpleColor(
            modifier = Modifier.padding(top = 3.dp, bottom = 3.dp),
            text = stringResource(id = R.string.ex_untill),
            fontSize = 10.sp, fontik = FontFamily(Font(R.font.monsbold)),
            color = Anor_green
        )


        TxtSimpleColor(
            modifier = Modifier.padding(top = 3.dp, bottom = 3.dp),
            text = " 25.0%",
            fontSize = 9.sp, fontik = FontFamily(Font(R.font.monsbold)),
            color = Anor_green
        )


    }


}