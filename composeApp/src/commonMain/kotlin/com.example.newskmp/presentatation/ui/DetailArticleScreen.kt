package com.example.newskmp.presentatation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newskmp.data.model.Article
import com.example.newskmp.presentatation.ui.component.getPainterResource
import io.kamel.image.KamelImage

@Composable
fun DetailArticleScreen(article: Article){
    Column {
        KamelImage(
            resource = getPainterResource(article.urlToImage ?: "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwhey.kz%2Fplaceholder-png%2F&psig=AOvVaw3lQpBKHAHk48OcT0RaUWs6&ust=1717592027157000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCNjxjYf_wYYDFQAAAAAdAAAAABAE"),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(200.dp)
        )

        Text(modifier = Modifier.fillMaxWidth(), text = article.title)
        Spacer(modifier = Modifier.height(8.dp))
        Text(modifier = Modifier.fillMaxWidth(), text = article.description)
        Spacer(modifier = Modifier.height(8.dp))
        Text(modifier = Modifier.fillMaxWidth(), text = article.source.name)
        Spacer(modifier = Modifier.height(8.dp))
        Text(modifier = Modifier.fillMaxWidth(), text = article.author ?: "Unknown author")
        Spacer(modifier = Modifier.height(8.dp))
        Text(modifier = Modifier.fillMaxWidth(), text = article.publishedAt)
    }
}