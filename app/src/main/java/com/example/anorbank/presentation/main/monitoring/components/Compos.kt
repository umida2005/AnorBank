package com.example.anorbank.presentation.main.monitoring.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anorbank.R
import com.example.anorbank.data.model.remote.response.historyResponse.Child
import com.example.anorbank.ui.theme.Anor_black
import com.example.anorbank.ui.theme.Anor_black_medium
import com.example.anorbank.ui.theme.Anor_green
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_hint

@Composable
fun ItemHistory(name: String, pan: String,amount: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .border(
                width = 1.5.dp,
                color = Anor_black_medium,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.5.dp,
                    color = Anor_hint,
                    shape = RoundedCornerShape(18.dp)
                )
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(modifier = Modifier
                .weight(1.5f)
                .padding(8.dp),
                painter = painterResource(id = R.drawable.ic_uzcard),
                contentDescription = null)

            Column(modifier = Modifier
                .weight(6f)
                .padding(vertical = 4.dp)) {
                Text(modifier = Modifier.weight(1f),
                    text = name)
                Text(modifier = Modifier.weight(1f), text = pan)

            }

            Text(modifier = Modifier.weight(2f),
                text = amount.toString())


        }

    }
}





@Preview
@Composable
fun ItemPrimaryPrev() {
    HisItems(data = Child("fgd","df","gdfg","fgdf","dgf"))
}

@Composable
fun HisItems(data: Child) {
//    Column(
//        modifier = Modifier
//            .padding(horizontal = 12.dp, vertical = 1.dp)
//            .fillMaxWidth()
//            .clip(shape = RoundedCornerShape(10.dp))
//
//            .background(color = Color.White)
//    ) {
        Row(modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(10.dp)).background(color = Color.White)) {

            Image(
                modifier = Modifier.weight(1f)
                    .padding(3.dp)
                    .size(48.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(R.drawable.ic_uzcard_border),
                contentDescription = null
            )

            Text(
                text = data.from.toUpperCase(),
                modifier = Modifier.weight(3f)
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp),
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.mons_regular)),
                color = Anor_black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = data.amount.toUpperCase(),
                modifier = Modifier.weight(1f)
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp),
                textAlign = TextAlign.Start,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.mons_regular)),
                color = Anor_black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "00.UZS",
                modifier = Modifier.weight(1f)
                    .align(Alignment.CenterVertically),
                textAlign = TextAlign.Start,
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.mons_regular)),
                color = Anor_grey
            )

        }
    //}
}


data class SerItemData(
    val img: Int,
    val title: String
)


@Composable
fun BoxMoney( text: String, amount: String, modifier: Modifier, color: Color) {
    Box(modifier = modifier
        .clip(shape = RoundedCornerShape(12.dp))
        .background(color = Color.White)){

        Column (modifier = Modifier.fillMaxWidth().padding(start =8.dp, end = 8.dp, top = 8.dp)){
            Text(modifier = Modifier.align(Alignment.CenterHorizontally),
                text = text,
                fontSize = 10.sp,
                color = Anor_black,
                fontFamily = FontFamily(Font(R.font.poppins)))

            Row(modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 8.dp)) {
                Text(modifier = Modifier, textAlign = TextAlign.End,
                    text = amount,
                    fontSize = 12.sp,
                    color = color,
                    fontFamily = FontFamily(Font(R.font.poppins)))
                Text(modifier = Modifier.align(Alignment.CenterVertically),
                    fontSize = 8.sp,
                    text = ".00 UZS",
                    color = Anor_black_medium,
                    fontFamily = FontFamily(Font(R.font.mons_regular)))

            }
        }

    }

}




