package com.example.anorbank.presentation.main.payment.componenets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anorbank.R
import com.example.anorbank.presentation.components.TextCompo
import com.example.anorbank.ui.theme.Anor_black_medium


@Composable
fun LazyInTops(data: List<ItemsPay>,click: (Int) -> Unit) {

    LazyRow {

        for (i in data.indices){
           item {
               ItemTemp(data =data[i] , click ={
                   click.invoke(i)
               } )
           }
        }

    }
}

@Composable
fun ItemTemp(data: ItemsPay,click:(Unit)->Unit) {
    Column(modifier = Modifier.padding(2.dp)
        .clickable { click.invoke(Unit) }) {
        Image(
            painter = painterResource(id = data.img),
            contentDescription = data.text,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            text = data.text,
            lineHeight = TextUnit(18f, TextUnitType.Sp),
            color = Anor_black_medium,
            fontSize = 11.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontFamily = FontFamily(Font(R.font.mons_regular))


        )
    }
}
data class ItemsPay(
    val img: Int,
    val text: String
)


@Composable
fun ScrollItems(onClick: (Int) -> Unit, text: String, index: Int,) {

    Box(modifier = Modifier
        .padding(2.dp)
        .clip(shape = RoundedCornerShape(12.dp))
        .background(color = Color.White)
        .clickable { onClick(index) }

        ){
        Text(modifier = Modifier.padding(8.dp),
            text = text,
            fontSize = 12.sp,
            color = Anor_black_medium,
            fontFamily = FontFamily(Font(R.font.monsbold)),
            )
    }

}







