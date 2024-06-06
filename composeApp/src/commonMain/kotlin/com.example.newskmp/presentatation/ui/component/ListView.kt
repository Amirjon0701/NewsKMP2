package com.example.newskmp.presentatation.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.newskmp.data.model.Article
import io.kamel.core.Resource
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinx.coroutines.Job

@Composable
fun getPainterResource(url: String): Resource<Painter>{
    return asyncPainterResource(url){

    }
}

@Composable
fun ListView(modifier: Modifier, articles: List<Article>){
    LazyColumn {
        items(articles){
            ListViewItem(modifier = Modifier.fillMaxWidth().wrapContentHeight(), it)
        }
    }
}

@Composable
fun ListViewItem(modifier: Modifier, article: Article){
    Card(modifier = modifier){
        Column {
            KamelImage(resource = getPainterResource(article.urlToImage ?: "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwhey.kz%2Fplaceholder-png%2F&psig=AOvVaw3lQpBKHAHk48OcT0RaUWs6&ust=1717592027157000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCNjxjYf_wYYDFQAAAAAdAAAAABAE"), contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(200.dp))
            Text(modifier = Modifier.fillMaxWidth(), text = article.title)
            Spacer(modifier.height(8.dp))
            Text(modifier = Modifier.fillMaxWidth(), text = article.publishedAt)
        }
    }
    Spacer(modifier.height(14.dp))
}