package com.example.anorbank.presentation.main.bottom

import CardsScreens
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.anorbank.R
import com.example.anorbank.presentation.main.home.MainScreen
import com.example.anorbank.presentation.main.monitoring.MonitoringScreen
import com.example.anorbank.presentation.main.payment.PaymentScreen
import com.example.anorbank.presentation.main.services.ServiceScreen

object MainTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(id = R.string.tab_home)
            val icon = painterResource(id = R.drawable.ic_tab_home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @RequiresApi(Build.VERSION_CODES.Q)
    @Composable
    override fun Content() {
        MainScreen().Content()
    }
}


object CardsTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(id = R.string.tab_cards)
            val icon = painterResource(id = R.drawable.ic_tab_cards)

            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        CardsScreens().Content()
    }
}


object PaymentTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(id = R.string.tab_payment)
            val icon = painterResource(id = R.drawable.ic_tab_pay)

            return remember {
                TabOptions(
                    index = 2u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        PaymentScreen().Content()
    }

}

object MonitoringTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(id = R.string.tab_monitoring)
            val icon = painterResource(id = R.drawable.ic_tab_monitoring)

            return remember {
                TabOptions(
                    index = 3u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        MonitoringScreen().Content()
    }

}


object ServicesTab: Tab{
    override val options: TabOptions

        @Composable
        get() {
            val title =  stringResource(id = R.string.tab_service)
            val icon =  painterResource(id = R.drawable.ic_tab_services)
            return remember {
                TabOptions(
                    index =4u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
       ServiceScreen().Content()
    }
}






