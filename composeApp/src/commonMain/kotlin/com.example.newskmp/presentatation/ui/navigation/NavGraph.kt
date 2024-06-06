package com.example.newskmp.presentatation.ui.navigation

import AppScreen
import com.example.newskmp.data.model.Article
import com.example.newskmp.presentatation.store.ArticlesScreenState
import com.example.newskmp.presentatation.ui.ArticlesScreen
import com.example.newskmp.presentatation.ui.DetailArticleScreen
import com.example.newskmp.presentatation.vm.ArticlesViewModel
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.navigationGraph() {
    screen("app_screen"){
        AppScreen(it as ArticlesViewModel)
    }
    screen("articles"){
        ArticlesScreen(it as ArticlesScreenState.Success)
    }
    screen("detail"){
        DetailArticleScreen(it as Article)
    }
}