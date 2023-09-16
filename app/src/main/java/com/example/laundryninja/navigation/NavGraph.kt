package com.example.laundryninja.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.laundryninja.AppUi.CartPage
import com.example.laundryninja.AppUi.HomePage
import com.example.laundryninja.AppUi.OrderPage
import com.example.laundryninja.AppUi.ProfilePage
import com.example.laundryninja.AppUi.Service_Cloth


@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

//        composable(route = Screen.Front.route
//        ){
//            com.example.laundryninja.AppUi.check(navController = navController)
//        }

        composable(route = Screen.Home.route) {
            HomePage(navController = navController)
        }

        composable(route = Screen.Order.route) {
            OrderPage(navController = navController)
        }

        composable(route = Screen.Cart.route) {
            CartPage(navController = navController)
        }

        composable(route = Screen.Profile.route) {
            ProfilePage(navController = navController)
        }

        composable(route= Screen.Wash.route){
//            Screen.Wash(navController = navController)
        }

//        composable(route= Screen.Iron.route){
//           Iron(navController = navController)
//        }
//
//        composable(route= Screen.DryClean.route){
//            DryClean(navController = navController)
//        }

//        composable(route = Screen.Cloth.route){
//            Cloth(navController = navController)
//        }

        composable(route = Screen.Service.route){
            Service_Cloth(navController = navController)
        }
    }

}

fun getCurrentRoute(navController: NavController): String? {
    val currentBackStackEntry: NavBackStackEntry? = navController.currentBackStackEntry
    val currentDestination: NavDestination? = currentBackStackEntry?.destination
    return currentDestination?.route
}