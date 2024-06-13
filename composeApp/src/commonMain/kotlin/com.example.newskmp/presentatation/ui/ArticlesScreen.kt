package com.example.newskmp.presentatation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.newskmp.presentatation.store.ArticlesScreenEvent
import com.example.newskmp.presentatation.store.ArticlesScreenState
import com.example.newskmp.presentatation.ui.component.ListView
import com.example.newskmp.presentatation.ui.component.SearchAppBar
import com.example.newskmp.presentatation.ui.component.state.SearchWidgetState
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
        val appBarState by articlesViewModel.searchAppBarState
        val searchText by articlesViewModel.searchText

        val navigator = LocalNavigator.current
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                SearchAppBar(
                    "News",
                    searchWidgetState = appBarState,
                    searchTextState = searchText,
                    onTextChange = {
                                   articlesViewModel.obtainEvent(ArticlesScreenEvent.UpdateSearchText(it))
                    },
                    onCloseClicked = {
                                     articlesViewModel.obtainEvent(ArticlesScreenEvent.UpdateAppBarState(SearchWidgetState.CLOSED))
                        articlesViewModel.obtainEvent(ArticlesScreenEvent.GetArticles)
                    },
                    onSearchClicked = {
                                      articlesViewModel.obtainEvent(ArticlesScreenEvent.SearchArticle(it))
                    },
                    onSearchTriggered = {
                        articlesViewModel.obtainEvent(ArticlesScreenEvent.UpdateAppBarState(SearchWidgetState.OPENED))
                    }
                )
            }
        ) {
            if (state.value is ArticlesScreenState.Success) {
                //Navigator()
                ListView(
                    modifier = Modifier.fillMaxSize().padding(it),
                    (state.value as ArticlesScreenState.Success).articles
                ) {
                    navigator?.push(DetailArticleScreen(it))
                }
            }
        }
    }
}


