package com.example.newskmp.presentatation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import com.example.newskmp.presentatation.store.ArticlesScreenEvent
import com.example.newskmp.presentatation.store.FavoriteScreenEvent
import com.example.newskmp.presentatation.store.FavoriteScreenState
import com.example.newskmp.presentatation.ui.component.ListView
import com.example.newskmp.presentatation.ui.component.SearchAppBar
import com.example.newskmp.presentatation.ui.component.state.SearchWidgetState
import com.example.newskmp.presentatation.vm.FavoriteViewModel
import org.koin.compose.koinInject

class FavoriteScreen: Tab {
    @Composable
    override fun Content() {
        Navigator(FavScreen()){
            SlideTransition(it)
        }
    }

    override val options: TabOptions
        @Composable
        get() = remember {
            TabOptions(
                index = 1u,
                title = "Favorite",
                icon = null
            )
        }
}

class FavScreen(): Screen {
    @Composable
    override fun Content() {
        val favoriteViewModel: FavoriteViewModel = koinInject()
        val state = favoriteViewModel.state.collectAsState()
        val navigator = LocalNavigator.current
        val appBarState by favoriteViewModel.searchAppBarState
        val searchText by favoriteViewModel.searchText

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                SearchAppBar(
                    "Favorites",
                    searchWidgetState = appBarState,
                    searchTextState = searchText,
                    onTextChange = {
                        favoriteViewModel.obtainEvent(FavoriteScreenEvent.UpdateSearchText(it))
                    },
                    onCloseClicked = {
                        favoriteViewModel.obtainEvent(
                            FavoriteScreenEvent.UpdateAppBarState(
                                SearchWidgetState.CLOSED))
                        favoriteViewModel.obtainEvent(FavoriteScreenEvent.GetFavoriteArticles)
                    },
                    onSearchClicked = {
                        favoriteViewModel.obtainEvent(FavoriteScreenEvent.SearchArticles(it))
                    },
                    onSearchTriggered = {
                        favoriteViewModel.obtainEvent(
                            FavoriteScreenEvent.UpdateAppBarState(
                                SearchWidgetState.OPENED))
                    }
                )
            }
        ){
            if(state.value is FavoriteScreenState.Success){
                //Navigator()
                ListView(modifier = Modifier.fillMaxSize(), (state.value as FavoriteScreenState.Success).articles){
                    navigator?.push(DetailArticleScreen(it))
                }
            }
        }

    }

}