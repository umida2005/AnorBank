package com.example.anorbank.zed.expendables.home_ex

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anorbank.R
import com.example.anorbank.ui.theme.AnorBankTheme
import com.example.anorbank.ui.theme.Anor_dark
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.utils.spacers.SpacerHEight
import com.example.anorbank.utils.spacers.SpacerHSixteen
import com.example.anorbank.utils.spacers.SpacerHTwentyFour
import com.example.anorbank.utils.spacers.SpacerWEight


@Composable
fun MyHome() {

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
                    text = stringResource(id = R.string.ex_myhome),
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

                }


            }
            AnimatedVisibility(visible = isExpanded) {
                Column {

                    Homchik()
                    SpacerHSixteen()
                }
            }


            SpacerHTwentyFour()
        }


    }

}


@Composable
@Preview
fun PrevHome() {
    AnorBankTheme {
        MyHome()
    }
}


@Composable
fun Homchik() {
    Column {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)

                .size(70.dp),
            contentScale = ContentScale.FillHeight,
            painter = painterResource(id = R.drawable.ic_my_home),
            contentDescription = null
        )


        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 24.dp),
            shape = RoundedCornerShape(16.dp),
            onClick = {},
            colors = ButtonDefaults.buttonColors(Anor_dark)



        ) {

            Text(
                modifier = Modifier.background(color = Color.Transparent),
                text = stringResource(id = R.string.btn_add_home),
                fontFamily = FontFamily(Font(R.font.monsbold))
            )

        }

    }
}
