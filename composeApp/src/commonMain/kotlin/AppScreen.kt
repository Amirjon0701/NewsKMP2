import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.newskmp.data.model.Article
import com.example.newskmp.presentatation.store.ArticlesScreenState
import com.example.newskmp.presentatation.ui.ArticlesScreen
import com.example.newskmp.presentatation.ui.DetailArticleScreen
import com.example.newskmp.presentatation.ui.FavoriteScreen
import com.example.newskmp.presentatation.vm.ArticlesViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun AppScreen() {
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

        TabNavigator(ArticlesScreen()){
            Scaffold(
                bottomBar = {
                    BottomNavigation {
                        TabNavigationItem(ArticlesScreen())
                        TabNavigationItem(FavoriteScreen())
                    }
                }
            ){
                CurrentTab()
            }
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab){
    val tabNavigator = LocalTabNavigator.current
    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = {tabNavigator.current = tab},
        label = {
            Text(tab.options.title)
        },
        icon = {
            //Icon(imageVector = Icons.Filled.)
        }
    )

}
