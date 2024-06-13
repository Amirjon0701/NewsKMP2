package com.example.newskmp.presentatation.store

import com.example.newskmp.presentatation.ui.component.state.SearchWidgetState

sealed class ArticlesScreenEvent {
    data object GetArticles: ArticlesScreenEvent()
    data class UpdateAppBarState(val searchWidgetState: SearchWidgetState): ArticlesScreenEvent()

    data class UpdateSearchText(val text: String): ArticlesScreenEvent()
    data class SearchArticle(val searchText: String): ArticlesScreenEvent()
}