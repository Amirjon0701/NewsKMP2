package com.example.newskmp.presentatation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.newskmp.presentatation.store.ArticlesScreenState
import com.example.newskmp.presentatation.ui.component.ListView

@Composable
fun ArticlesScreen(state: ArticlesScreenState.Success){
    ListView(modifier = Modifier.fillMaxSize(), state.articles)
}

