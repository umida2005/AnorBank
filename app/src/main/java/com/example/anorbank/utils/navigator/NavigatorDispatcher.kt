package com.example.anorbank.utils.navigator

import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationDispatcher @Inject constructor() : AppNavigator, NavigationHandler {
    override val navigationStack = MutableSharedFlow<NavigationArgs>()

    private suspend fun navigate(args: NavigationArgs) {
        navigationStack.emit(args)
    }

    override suspend fun back() = navigate {
        pop()
    }

    override suspend fun backUntilRoot() = navigate {
        popUntilRoot()
    }

    override suspend fun backAll() = navigate {
        popAll()
    }

    override suspend fun navigateTo(screen: AppScreen) = navigate {
        push(screen)
    }

    override suspend fun replace(screen: AppScreen)= navigate{
        replace(screen)
    }

    override suspend fun replaceAll(screen: AppScreen) = navigate {
       replaceAll(screen)
    }

//    override suspend fun stackLog() = navigate {
//        items.forEach {
//        }
//    }

}
