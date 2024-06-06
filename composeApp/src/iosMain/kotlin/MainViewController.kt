import androidx.compose.ui.window.ComposeUIViewController
import com.example.newskmp.core.HttpKtorClient
import com.example.newskmp.core.getHttpClientEngine
import com.example.newskmp.data.repository.impl.ArticleRepositoryImpl
import com.example.newskmp.data.service.impl.ArticleServiceImpl
import com.example.newskmp.presentatation.vm.ArticlesViewModel

fun MainViewController() = ComposeUIViewController { AppScreen(
    ArticlesViewModel(
        ArticleRepositoryImpl(ArticleServiceImpl(HttpKtorClient().provideKtorClient(
            getHttpClientEngine()
        ))))
) }