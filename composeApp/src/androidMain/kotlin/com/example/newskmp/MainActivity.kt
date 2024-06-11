package com.example.newskmp

import AppScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.newskmp.core.HttpKtorClient
import com.example.newskmp.core.getHttpClientEngine
import com.example.newskmp.data.repository.impl.ArticleRepositoryImpl
import com.example.newskmp.data.service.impl.ArticleServiceImpl
import com.example.newskmp.presentatation.vm.ArticlesViewModel
import io.ktor.client.HttpClient
import org.koin.java.KoinJavaComponent.inject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val viewModel: ArticlesViewModel by inject(ArticlesViewModel::class.java)
        setContent {
//            val configuration = OdysseyConfiguration(canvas = this)
//
//            setNavigationContent(configuration) {
//                navigationGraph()
//            }
//            App(ArticlesViewModel(
//                    ArticleRepositoryImpl(ArticleServiceImpl(getKtorClient().provideKtorClient()))))

            AppScreen()
            //val rootController = LocalRootController.current
            //rootController.push(screen = "app_screen", params = viewModel)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
//    AppScreen(
//        ArticlesViewModel(
//            ArticleRepositoryImpl(ArticleServiceImpl(HttpKtorClient().provideKtorClient(
//                getHttpClientEngine()
//            ))))
//    )
}