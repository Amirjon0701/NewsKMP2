import com.example.newskmp.data.model.Article
import com.example.newskmp.di.allModules

fun initKoin(){
    org.koin.core.context.startKoin{
        modules(allModules)
    }
}