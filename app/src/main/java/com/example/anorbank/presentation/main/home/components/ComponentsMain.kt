package com.example.anorbank.presentation.main.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anorbank.R
import com.example.anorbank.presentation.main.home.MainContract
import com.example.anorbank.ui.theme.Anor_dark

@Composable
fun Tops(onEventDispatcher: (MainContract.MyIntent.OpenProfile) -> Unit) {
    TopAppBar(
        modifier = Modifier.background(color = Anor_dark),
        navigationIcon = {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(28.dp)
            ) {
                Image(
                    modifier = Modifier.clickable {
                        onEventDispatcher.invoke(MainContract.MyIntent.OpenProfile)

                    },
                    painter = painterResource(id = R.drawable.pg_profile),
                    contentDescription = null,
                )
            }
        },
        title = {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(168.dp),
                    painter = painterResource(id = R.drawable.ic_anor_title),
                    contentDescription = null
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth(0f)
                        .weight(1f)
                )
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(8.dp),
                    painter = painterResource(id = R.drawable.ic_chat),
                    contentDescription = null
                )
                //Spacer(modifier = Modifier.width(8.dp))
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(8.dp),
                    painter = painterResource(id = R.drawable.ic_notify),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(4.dp))
            }

        },

        backgroundColor = Color.Transparent,
        elevation = 0.dp
    )

}

@Composable
fun LazyInTop(data: List<ItemData>) {

    LazyRow {
        items(data) { item ->
            Item(data = item)

        }
    }
}

@Composable
fun Item(data: ItemData) {
    Column(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = data.img),
            contentDescription = data.text,
            modifier = Modifier
                .size(72.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            text = data.text,
            lineHeight = TextUnit(18f, TextUnitType.Sp),
            color = Color.White,
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.monsbold))


        )
    }
}
data class ItemData(
    val img: Int,
    val text: String
)


@Composable
fun TxtSimpleWhite(
    modifier: Modifier,
    text: String,
    fontSize: TextUnit,
    fontik: FontFamily,
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        fontFamily = fontik,
        color = Color.White
    )
}

@Composable
fun TxtSimpleColor(
    modifier: Modifier,
    text: String,
    color: Color = Anor_dark,
    fontSize: TextUnit,
    fontik: FontFamily,
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        fontFamily = fontik,
        color = color
    )
}



@Composable
fun TxtMoney(
    modifier: Modifier,
    text: String,
    color: Color = Anor_dark,
    fontSize: TextUnit,
    fontik: FontFamily,
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        fontFamily = fontik,
        color = color
    )
}




@Composable
fun ItemList() {
    val resources = LocalContext.current.resources
    val itemList = listOf(
        ItemData(img = R.drawable.item_1, text = resources.getString(R.string.home_item1)),
        ItemData(R.drawable.item_2, text = resources.getString(R.string.home_item2)),
        ItemData(R.drawable.item_3, text = resources.getString(R.string.home_item3)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item4)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item5)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item6)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item7)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item8)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item9)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item1)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item1)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item1))
    )
}



@Composable
fun ItemText(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun prevCompo() {
}
