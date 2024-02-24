package com.example.funfacts.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.funfacts.ui.UserInputViewModel

@Composable
fun FunFactsNavigationGraph(userInputViewModel: UserInputViewModel = viewModel()){
    val navController = rememberNavController() // to remember the last state of navHost i.e which screen
    // was opened last time
    NavHost(navController = navController, startDestination = Routes.USER_INPUT_SCREEN ){
        composable(Routes.USER_INPUT_SCREEN){
            UserInputScreen(userInputViewModel, showWelcomeScreen = {
                println("coming inside welcome screen")
                println(it.first)
                println(it.second)
                navController.navigate("${Routes.WELCOME_SCREEN}/${it.first}/${it.second}")
            })
        }
        composable("${Routes.WELCOME_SCREEN}/{${Routes.USER_NAME}}/{${Routes.ANIMAL_SELECTED}}",
            arguments = listOf(
                navArgument(name = Routes.USER_NAME){type = NavType.StringType},
                navArgument(name = Routes.ANIMAL_SELECTED){type = NavType.StringType}
            )
        ){
            val username = it?.arguments?.getString(Routes.USER_NAME)
            val animalSelected = it?.arguments?.getString(Routes.ANIMAL_SELECTED)
            WelcomeScreen(username,animalSelected)
        }
    }
}