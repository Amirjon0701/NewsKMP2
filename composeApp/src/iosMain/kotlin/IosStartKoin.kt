import com.example.newskmp.di.allModules

fun startKoin(){
    org.koin.core.context.startKoin{
        modules(allModules)
    }
}