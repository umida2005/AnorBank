package com.example.anorbank.zed.expendables.home_ex

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anorbank.R
import com.example.anorbank.ui.theme.AnorBankTheme
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.utils.spacers.SpacerHEight
import com.example.anorbank.utils.spacers.SpacerHSixteen
import com.example.anorbank.utils.spacers.SpacerHTwentyFour
import com.example.anorbank.utils.spacers.SpacerWEight


@Composable
fun Valyuta() {

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
                    text = stringResource(id = R.string.ex_valyuta),
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
                            .padding(12.dp),
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


            }
            AnimatedVisibility(visible = isExpanded) {
                Column {

                    Image(
                        painter = painterResource(id = R.drawable.ic_my_home),
                        contentDescription = null
                    )
                    SpacerHSixteen()
                }
            }


            SpacerHTwentyFour()
        }


    }

}


@Composable
@Preview
fun PrevValyuta() {
    AnorBankTheme {
        Valyuta()
    }
}
