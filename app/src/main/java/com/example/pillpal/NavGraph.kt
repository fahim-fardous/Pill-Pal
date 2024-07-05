package com.example.pillpal

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.pillpal.screens.reminder.add.ReminderAddScreen
import com.example.pillpal.screens.reminder.add.ReminderAddViewModel
import com.example.pillpal.screens.reminder.list.ReminderListScreen
import com.example.pillpal.screens.reminder.list.ReminderListViewModel
import com.example.pillpal.screens.splash.SplashScreen

sealed class Screen(
    val route: String,
) {
    data object Splash : Screen("splash")

    data object Auth : Screen("auth")

    data object Home : Screen("home")

    data object Reminder : Screen("reminder")
}

sealed class SplashScreen(
    val route: String,
) {
    data object Splash : SplashScreen("splash/index")
}

sealed class AuthScreen(
    val route: String,
) {
    data object Login : AuthScreen("auth/login")

    data object Signup : AuthScreen("auth/signup")
}

sealed class HomeScreen(
    val route: String,
) {
    data object HomeIndex : HomeScreen("home/index")
}

sealed class ReminderScreen(
    val route: String,
) {
    data object ReminderList : ReminderScreen("reminder/list")

    data object ReminderAdd : ReminderScreen("reminder/add")

    data object ReminderEdit : ReminderScreen("reminder/{reminderId}/edit")
}

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        addSplashScreen(navController)
        addAuthScreen(navController)
        addHomeScreen(navController)
        addReminderScreen(navController)
    }
}

private fun NavGraphBuilder.addSplashScreen(navController: NavHostController) {
    navigation(route = Screen.Splash.route, startDestination = SplashScreen.Splash.route) {
        composable(SplashScreen.Splash.route) {
            SplashScreen(
                gotoListScreen = {
                    navController.navigate(
                        ReminderScreen.ReminderList.route,
                    ){
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                },
            )
        }
    }
}

private fun NavGraphBuilder.addAuthScreen(navController: NavHostController) {
    navigation(route = Screen.Auth.route, startDestination = AuthScreen.Login.route) {
        composable(AuthScreen.Login.route) {
        }
        composable(AuthScreen.Signup.route) {
        }
    }
}

private fun NavGraphBuilder.addHomeScreen(navController: NavHostController) {
    navigation(route = Screen.Home.route, startDestination = HomeScreen.HomeIndex.route) {
        composable(HomeScreen.HomeIndex.route) {
        }
    }
}

private fun NavGraphBuilder.addReminderScreen(navController: NavHostController) {
    navigation(
        route = Screen.Reminder.route,
        startDestination = ReminderScreen.ReminderList.route,
    ) {
        composable(ReminderScreen.ReminderList.route) {
            val viewModel: ReminderListViewModel = hiltViewModel()
            ReminderListScreen(
                viewModel = viewModel,
                gotoAddReminder = {
                    navController.navigate(ReminderScreen.ReminderAdd.route)
                },
            )
        }
        composable(ReminderScreen.ReminderAdd.route) {
            val viewModel: ReminderAddViewModel = hiltViewModel()
            ReminderAddScreen(viewModel = viewModel, goBack = { navController.popBackStack() })
        }
        composable(ReminderScreen.ReminderEdit.route) {
        }
    }
}
