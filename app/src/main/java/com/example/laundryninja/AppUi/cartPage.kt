package com.example.laundryninja.AppUi

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.laundryninja.AppUi.ViewModels.CartViewModel
import com.example.laundryninja.AppUi.ViewModels.DryCleanViewModel
import com.example.laundryninja.AppUi.ViewModels.IronViewModel
import com.example.laundryninja.AppUi.ViewModels.WashViewModel
import com.example.laundryninja.dataclass.ItemCloth

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartPage(navController: NavController){

    val cartViewModel = viewModel<CartViewModel>(
        factory = object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return  CartViewModel() as T
            }
        }
    )



    Scaffold(
        bottomBar = { BottomAppBar(navController) }
    ) {
        Text(text = "Cart Page")
    }

}

@Composable
fun getCart(): List<ItemCloth> {

    val washViewModel = viewModel<WashViewModel>(
        factory = object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return  WashViewModel() as T
            }
        }
    )

    val ironViewModel = viewModel<IronViewModel>(
        factory = object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return  IronViewModel() as T
            }
        }
    )

    val dryCleanViewModel = viewModel<DryCleanViewModel>(
        factory = object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return  DryCleanViewModel() as T
            }
        }
    )

    var addCloth by remember {
        mutableStateOf(emptyList<ItemCloth>())
    }

    val list = dryCleanViewModel.dryCleanInfo() + ironViewModel.ironInfo() + washViewModel.washInfo()
    list.forEach {
        if(it.qty>0)
            addCloth += it
    }
    return addCloth
}