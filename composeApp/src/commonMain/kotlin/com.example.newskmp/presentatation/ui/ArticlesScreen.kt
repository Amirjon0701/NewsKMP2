package com.example.newskmp.presentatation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.ScreenTransition
import cafe.adriel.voyager.transitions.SlideTransition
import com.example.newskmp.presentatation.store.ArticlesScreenState
import com.example.newskmp.presentatation.ui.component.ListView
import com.example.newskmp.presentatation.vm.ArticlesViewModel
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject


class ArticlesScreen(): Tab {
    @Composable
    override fun Content() {
        Navigator(NewsScreen()) {
            SlideTransition(it)
            //ScreenTransition(it)
        }
    }

    override val options: TabOptions
        @Composable
        get() = remember {
            TabOptions(
                index = 0u,
                title = "News",
                icon = null
            )
        }

}

class NewsScreen(): Screen{
    @Composable
    override fun Content() {
        val articlesViewModel: ArticlesViewModel = koinInject()
        val state = articlesViewModel.state.collectAsState()
        val navigator = LocalNavigator.current
        if(state.value is ArticlesScreenState.Success){
            //Navigator()
            ListView(modifier = Modifier.fillMaxSize(), (state.value as ArticlesScreenState.Success).articles){
                navigator?.push(DetailArticleScreen(it))
            }
        }
    }

}


