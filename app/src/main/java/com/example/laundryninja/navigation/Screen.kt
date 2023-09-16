package com.example.laundryninja.navigation

sealed class Screen(val route:String){

//    object Front:Screen(route = "Front")
    object Home: Screen(route = "Home")
    object Order: Screen(route = "Orders")
    object Cart: Screen(route = "Cart")
    object Profile: Screen(route = "Profile")
    object Wash:Screen(route = "Wash")
    object Iron:Screen(route = "Iron")
    object DryClean:Screen(route = "DryClean")
    object Cloth:Screen(route = "Cloth")
    object Service:Screen(route = "Service")
}
