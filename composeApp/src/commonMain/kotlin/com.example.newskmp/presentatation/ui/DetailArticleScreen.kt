package com.example.newskmp.presentatation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.example.newskmp.data.model.Article
import com.example.newskmp.presentatation.store.DetailScreenEvent
import com.example.newskmp.presentatation.ui.component.getPainterResource
import com.example.newskmp.presentatation.vm.DetailViewModel
import io.kamel.image.KamelImage
import org.koin.compose.koinInject

class DetailArticleScreen(val article: Article): Screen{
    @Composable
    override fun Content() {
        val detailViewModel: DetailViewModel = koinInject()
        Box(modifier = Modifier
        .navigationBarsPadding().fillMaxSize()){
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

            Box(modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp)){
                FloatingActionButton(onClick = {
                    detailViewModel.obtainEvent(DetailScreenEvent.AddArticleToFavorite(article))
                }){
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Добавить в избранное")
                }
            }
        }
    }

}

//@Composable
//fun DetailArticleScreen(article: Article){
//    Column {
//        KamelImage(
//            resource = getPainterResource(article.urlToImage ?: "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwhey.kz%2Fplaceholder-png%2F&psig=AOvVaw3lQpBKHAHk48OcT0RaUWs6&ust=1717592027157000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCNjxjYf_wYYDFQAAAAAdAAAAABAE"),
//            contentDescription = null,
//            modifier = Modifier.fillMaxWidth().height(200.dp)
//        )
//
//        Text(modifier = Modifier.fillMaxWidth(), text = article.title)
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(modifier = Modifier.fillMaxWidth(), text = article.description)
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(modifier = Modifier.fillMaxWidth(), text = article.source.name)
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(modifier = Modifier.fillMaxWidth(), text = article.author ?: "Unknown author")
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(modifier = Modifier.fillMaxWidth(), text = article.publishedAt)
//    }
//}