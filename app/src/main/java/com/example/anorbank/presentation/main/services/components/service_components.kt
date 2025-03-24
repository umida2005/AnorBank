package com.example.anorbank.presentation.main.services.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.anorbank.R
import com.example.anorbank.ui.theme.Anor_black
import com.example.anorbank.ui.theme.Anor_black_child
import com.example.anorbank.ui.theme.Anor_black_medium
import com.example.anorbank.ui.theme.Anor_frame
import com.example.anorbank.ui.theme.Anor_hint
import com.example.anorbank.utils.spacers.SpacerHSixteen


@Composable
fun GovServices() {
    Column(
        modifier = Modifier
            .padding(top = 32.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(10.dp))
            .border(
                width = 1.dp,
                color = Anor_frame,
                shape = RoundedCornerShape(12.dp)
            )
            .background(color = Color.White)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {


            Image(
                modifier = Modifier
                    .weight(0.8f)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = R.drawable.ic_govs),
                contentDescription = null
            )

            Column(modifier = Modifier.weight(3f)) {
                SpacerHSixteen()
                Text(
                    text = stringResource(id = R.string.service_gov),
                    modifier = Modifier,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.monsbold)),
                    color = Anor_black
                )

                Text(
                    text = stringResource(id = R.string.service_govs2),
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .padding(end = 12.dp),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.mons_regular)),
                    color = Anor_black_child
                )

                SpacerHSixteen()
            }
        }


    }
}


@Composable
fun GovInsurance() {

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                color = Anor_frame,
                shape = RoundedCornerShape(10.dp)
            )
            .background(color = Color.White)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {


            Column(
                modifier = Modifier
                    .weight(3f)
                    .padding(start = 14.dp)
            ) {
                SpacerHSixteen()
                Text(
                    text = stringResource(id = R.string.service_insurance),
                    modifier = Modifier,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.monsbold)),
                    color = Anor_black_medium
                )

                Text(
                    text = stringResource(id = R.string.service_insurance2),
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .padding(end = 12.dp),
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.mons_regular)),
                    color = Anor_black_child
                )

                //  SpacerHEight()
            }
            Image(
                modifier = Modifier
                    .padding(2.dp)
                    .weight(0.85f),
                painter = painterResource(id = R.drawable.ic_insurance),
                contentDescription = null
            )
        }


    }

}

@Preview
@Composable
fun GovPrev() {
    //ServiceItems()
}


@Composable
fun ServiceLazyColumn(listData: List<SerItemData>) {
    LazyColumn(content = {
        items(listData) { item ->
            ServiceItems(data = item)

        }
    })
}


@Composable
fun ServiceItems(data: SerItemData) {
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(10.dp))

            .background(color = Color.White)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {

            Image(
                modifier = Modifier
                    .padding(3.dp)
                    .size(56.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = data.img),
                contentDescription = null
            )

            Text(
                text = data.title,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp),
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.mons_regular)),
                color = Anor_black_medium
            )

        }
    }
}


data class SerItemData(
    val img: Int,
    val title: String
)