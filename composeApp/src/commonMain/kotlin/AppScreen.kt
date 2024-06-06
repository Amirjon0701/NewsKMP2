import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.example.newskmp.data.model.Article
import com.example.newskmp.presentatation.store.ArticlesScreenState
import com.example.newskmp.presentatation.ui.ArticlesScreen
import com.example.newskmp.presentatation.vm.ArticlesViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun AppScreen(articlesViewModel: ArticlesViewModel) {
    val state = articlesViewModel.state.collectAsState()
    var artSize by mutableStateOf<List<Article>>(emptyList())
    if(state.value is ArticlesScreenState.Success){
        artSize = (state.value as ArticlesScreenState.Success).articles
    }
    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            Text(text = artSize, modifier = Modifier.fillMaxWidth())
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
        if(state.value is ArticlesScreenState.Success){
            ArticlesScreen(state.value as ArticlesScreenState.Success)
        }
    }
}
