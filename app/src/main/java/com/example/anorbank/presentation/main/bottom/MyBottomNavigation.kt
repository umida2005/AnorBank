package com.example.anorbank.presentation.main.bottom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.anorbank.presentation.components.TextNormal
import com.example.anorbank.ui.theme.Anor_dark
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_light

class MyBottomNavigation : Screen {
    @Composable
    override fun Content() {
        TabNavigator(MainTab) {
            Scaffold(content = {
                Box(modifier = Modifier.padding(it))
                CurrentTab()
            },
                bottomBar = {
                    Row(modifier = Modifier.background(Color.White)) {
                       TabNavigationItem(MainTab)
                       TabNavigationItem(CardsTab)
                       TabNavigationItem(PaymentTab)
                       TabNavigationItem(MonitoringTab)
                       TabNavigationItem(ServicesTab)
                    }

                  })
             }
        }
}

@Composable
fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            Icon(
                tint = if (tabNavigator.current == tab)   Anor_dark else Anor_grey,
                painter = tab.options.icon!! ,
                contentDescription = tab.options.title)
        },
          label = {
              TextNormal(
                  text = tab.options.title,
                  fontSize = 11.sp,
                  color = Anor_grey
              )
          }, selectedContentColor = Anor_light
        )
    
}


@Preview
@Composable
fun Bbbbbb() {
    
}
