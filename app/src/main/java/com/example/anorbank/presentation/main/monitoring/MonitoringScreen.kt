package com.example.anorbank.presentation.main.monitoring

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import com.example.anorbank.R
import com.example.anorbank.data.model.remote.response.historyResponse.Child
import com.example.anorbank.presentation.main.monitoring.components.BoxMoney
import com.example.anorbank.presentation.main.monitoring.components.HisItems
import com.example.anorbank.ui.theme.Anor_black
import com.example.anorbank.ui.theme.Anor_green
import com.example.anorbank.ui.theme.Anor_hint
import com.example.anorbank.utils.spacers.SpacerHTwentyFour
import org.orbitmvi.orbit.compose.collectAsState

class MonitoringScreen : Screen {
    private var historyList = ArrayList<Child>()
    private var l = listOf<Child>()


    @Composable

    override fun Content() {
        val pageCount = remember { mutableStateOf(1) }
        val viewModel = getViewModel<MonitoringModel>()
        var uiState = viewModel.collectAsState()
        MonitoringContent(
            viewModel.collectAsState().value,
            viewModel.getHistory(size = 10, pageCount = pageCount.value)
                .collectAsLazyPagingItems(), pageCount,
            viewModel::onEventDispatcher
        )
        historyList = uiState.value.historyList


    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MonitoringContent(
        uiState: MonitoringContract.UiState,
        lazyItemsData: LazyPagingItems<Child>,
        pageCount: MutableState<Int>,
        onEventDispatchers: (MonitoringContract.MyIntent) -> Unit
    ) {

        Scaffold(modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize(),
            topBar = {
                Box(
                    modifier = Modifier
                        .background(color = Anor_hint)
                        .fillMaxWidth()
                ) {

                    TopAppBar(
                        modifier = Modifier
                            .background(color = Anor_hint)
                            .fillMaxWidth(),
                        title = {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(color = Anor_hint),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    modifier = Modifier
                                        .background(color = Anor_hint)
                                        .align(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center,
                                    text = stringResource(id = R.string.monitor_title),
                                    color = Anor_black,
                                    fontSize = 18.sp,
                                    fontFamily = FontFamily(Font(R.font.monsbold)),

                                    )

                                Image(
                                    modifier = Modifier
                                        .size(72.dp)
                                        .padding(end = 12.dp),
                                    painter = painterResource(id = R.drawable.ic_monitorings),
                                    contentDescription = null
                                )

                            }
                        },
                    )
                }
            }) {

            Column(
                modifier = Modifier
                    .padding(it)
                    .background(color = Anor_hint)
            ) {
                SpacerHTwentyFour()
                Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Spacer(modifier = Modifier.weight(0.2f))
                    BoxMoney(
                        text = stringResource(id = R.string.monitor_plus),
                        amount = "22121",
                        modifier = Modifier.weight(1f),
                        color = Anor_green
                    )
                    Spacer(modifier = Modifier.weight(0.1f))
                    BoxMoney(
                        text = stringResource(id = R.string.monitor_minus),
                        amount = "1212",
                        modifier = Modifier.weight(1f),
                        color = Anor_black
                    )
                    Spacer(modifier = Modifier.weight(0.2f))
                }

                LazyColumn(modifier = Modifier.padding(it)) {
                    items(
                        lazyItemsData.itemCount,
                        key = lazyItemsData.itemKey { it.time },
                        contentType = lazyItemsData.itemContentType { "contentType" }
                    ) {
                        val item = lazyItemsData[it]
                        if (item != null) {
                            HisItems(item)
                        }
                    }
                }
            }

        }


    }
}

//@Preview
//@Composable
//fun PPPPPP() {
//    MonitoringContent(onEventDispatcher = {}, MonitoringContract.UiState())
//}