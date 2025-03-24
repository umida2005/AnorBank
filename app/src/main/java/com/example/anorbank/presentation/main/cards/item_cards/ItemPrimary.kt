package com.example.anorbank.presentation.main.cards.item_cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anorbank.R
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_hint
import com.example.anorbank.ui.theme.Anor_hinting
import com.example.anorbank.ui.theme.Anor_pinky
import com.example.anorbank.utils.spacers.SpacerWEight
import com.example.anorbank.utils.spacers.SpacerWTwentyFour

@Composable
fun ItemPrimaryFun(name: String, pan: String,amount: Int) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 12.dp)
            .fillMaxWidth()
            .height(60.dp)
            .border(
                width = 0.3.dp,
                color = Anor_hinting,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.5.dp,
                    color = Anor_hint,
                    shape = RoundedCornerShape(12.dp)
                )
                .background(Color.White), 
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(modifier = Modifier
                .weight(1.5f)
                .padding(8.dp),
                painter = painterResource(id = R.drawable.ic_quenn),
                contentDescription = null)

            Column(modifier = Modifier
                .weight(4f)
                .padding(vertical = 4.dp)) {
                Spacer(modifier = Modifier.weight(0.3f))
                Text(modifier = Modifier.weight(1f),
                    text = name,
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.monsbold))
                )
                Row(modifier = Modifier.weight(1f)) {

                    Text(modifier = Modifier,
                        fontFamily = FontFamily(Font(R.font.monsbold)),
                        color = Anor_hinting,
                        text = "****")
                    Text(modifier = Modifier,
                        fontFamily = FontFamily(Font(R.font.monsbold)),
                        color = Anor_hinting,
                        fontSize = 10.sp,
                        text = pan)

                }

            }

           Row(modifier = Modifier.weight(3f)) {
               Text(modifier = Modifier,
                   fontFamily = FontFamily(Font(R.font.mons_regular)),
                   color = Anor_grey,
                   text = amount.toString())

               Text(modifier = Modifier.align(Alignment.CenterVertically),
                   fontSize = 8.sp,
                   color = Anor_hinting,
                   text = ".00UZS")
               SpacerWEight()
           }


        }

    }
}





@Preview
@Composable
fun ItemPrimaryPrev() {
ItemPrimaryFun(name = "Uzcard", amount = 100, pan = "78949897")
}
@Composable
fun BigCard(name: String, amount: Int, pan: String) {
    Box(
        modifier = Modifier
            .padding(horizontal = 6.dp)
            .width(300.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(18.dp))
            .border(
                width = 0.8.dp,
                color = Anor_hint,
                shape = RoundedCornerShape(18.dp)
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.final_card),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxSize()
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(0.7f)) {

            }
            Row {

            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1.3f)) {
                Text(
                    text = name,
                    color = Anor_grey,
                    fontFamily = FontFamily(Font(R.font.monsbold)),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Text(
                        text = amount.toString(),
                        fontFamily = FontFamily(Font(R.font.monsbold)),
                        color = Anor_grey,
                        modifier = Modifier.align(Alignment.CenterVertically).padding(start = 16.dp),
                        fontSize = 12.sp
                    )

                    Text(
                        text = ".UZS", color = Anor_grey,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontSize = 12.sp
                    )
                }

                Row(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 12.dp, top = 24.dp)
                ) {

                    Text(
                        modifier = Modifier,
                        fontFamily = FontFamily(Font(R.font.monsbold)),
                        color = Anor_hinting,
                        text = "****"
                    )
                    Text(
                        modifier = Modifier,
                        fontFamily = FontFamily(Font(R.font.monsbold)),
                        color = Anor_hinting,
                        fontSize = 12.sp,
                        text = pan
                    )

                    SpacerWTwentyFour()

                    Text(
                        modifier = Modifier,
                        fontFamily = FontFamily(Font(R.font.monsbold)),
                        color = Anor_grey,
                        fontSize = 12.sp,
                        text = "08/26"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun BigCardPrev() {
 //   BigCard("name", "12345", "1235687")
}





//Column(
//modifier = Modifier
//.clip(shape = RoundedCornerShape(18.dp))
//.background(Anor_hinting)
//){
//    Spacer(modifier = Modifier.height(200.dp))
//    Column(modifier = Modifier) {
//
//        Row (modifier = Modifier,){
//            Column (modifier = Modifier.weight(8f)){
//
//            }
//            Image(modifier = Modifier.weight(1f),
//                painter = painterResource(id = R.drawable.ic_doc),
//                contentDescription = null)
//
//        }
//
//
//    }
//}