package com.example.laundryninja.AppUi

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DryCleaning
import androidx.compose.material.icons.filled.Iron
import androidx.compose.material.icons.filled.Wash
import androidx.compose.material.icons.outlined.DryCleaning
import androidx.compose.material.icons.outlined.Iron
import androidx.compose.material.icons.outlined.Wash
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.laundryninja.AppUi.ViewModels.DryCleanViewModel
import com.example.laundryninja.AppUi.ViewModels.IronViewModel
import com.example.laundryninja.AppUi.ViewModels.WashViewModel
import com.example.laundryninja.R
import com.example.laundryninja.dataclass.ItemCloth


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("MutableCollectionMutableState", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Service_Cloth(navController: NavController){

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



   Scaffold(

      bottomBar = {
         Column() {

            Button(onClick = {


                             },
               Modifier
                  .fillMaxWidth()
                  .padding(bottom = 10.dp, top = 5.dp, start = 5.dp, end = 5.dp),
             //  enabled =  totalCloth > 0,
               shape = RectangleShape
            ) {
               Text(text = "Add to Cart")
            }
            BottomAppBar(navController)
         }
      }
   ) {

      ServicesPage(washViewModel,ironViewModel,dryCleanViewModel)
   }

}



@OptIn(ExperimentalFoundationApi::class)

@Composable
fun ServicesPage(
   washViewModel: WashViewModel,
   ironViewModel: IronViewModel,
   dryCleanViewModel: DryCleanViewModel,

){
   var selectedTabIndex by remember { mutableIntStateOf(0) }
   val pagerState = rememberPagerState { tabItems.size }

   LaunchedEffect(selectedTabIndex) {
      pagerState.animateScrollToPage(selectedTabIndex)
   }

   LaunchedEffect(pagerState.currentPage) {
      selectedTabIndex = pagerState.currentPage

   }


   Column(Modifier.fillMaxSize()) {
      TabRow(selectedTabIndex = selectedTabIndex) {
         tabItems.forEachIndexed { index, item ->
            Tab(
               selected = index == selectedTabIndex,
               onClick = { selectedTabIndex = index; },
               text = { Text(text = item.title) },
               icon = {
                  Icon(
                     imageVector = if (index == selectedTabIndex) item.selected else item.unselected,
                     contentDescription = item.title
                  )
               }
            )
         }
      }

      HorizontalPager(
         state = pagerState,
         modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
      ) { index ->

         when (index) {
             0 -> Wash(washViewModel)
             1 -> Iron(ironViewModel)
             2 -> DryClean(dryCleanViewModel)
         }
      }
   }
}

val tabItems = listOf(
   TabItem(
      title = "Wash & Iron",
      unselected = Icons.Outlined.Wash,
      selected = Icons.Filled.Wash
   ),
   TabItem(
      title = "Iron",
      unselected = Icons.Outlined.Iron,
      selected = Icons.Filled.Iron
   ),
   TabItem(
      title = "DryWash",
      unselected = Icons.Outlined.DryCleaning,
      selected = Icons.Filled.DryCleaning
   )
)

data class TabItem(
   val title: String,
   val unselected: ImageVector,
   val selected: ImageVector
)



@Composable
fun ClothButton(item: ItemCloth, add:()->Unit, sub:()->Unit){

    var selected by remember{
        mutableStateOf(item.qty)
    }

    Card(
        Modifier
            .padding(10.dp)
            .size(width = 120.dp, height = 150.dp)) {

        val imagePainter: Painter = rememberAsyncImagePainter(model = item.id)

        Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = item.name)

            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .size(width = 120.dp, height = 90.dp)
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Fit
            )

            Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly) {
                    Button(onClick = { if(selected>0){
                        selected--;
                        sub()
                    } },
                        Modifier.weight(1f),
                        enabled = selected > 0,
                    shape = RectangleShape) {
                        Text(text = "-")
                    }
                    Text(text = "$selected",Modifier.weight(1f), textAlign = TextAlign.Center)

                    Button(onClick = {selected++
                                    add()
                                     }
                        ,
                        Modifier.weight(1f),
                        shape = RectangleShape
                    ) {
                        Text(text = "+")
                    }
            }


        }
    }

}




fun ClothRepository():List<ItemCloth>{
   return listOf(
      ItemCloth(R.drawable.bedsheet,"Bedsheet",0,150.0),
      ItemCloth(R.drawable.full_pant, "Full Pant",0,150.0),
      ItemCloth(R.drawable.full_shirt, "Full Shirt",0,150.0),
      ItemCloth(R.drawable.half_pants, "Half Pant",0,150.0),
      ItemCloth(R.drawable.huddies, "Hoodies",0,150.0),
      ItemCloth(R.drawable.jacket, "Jacket",0,150.0),
      ItemCloth(R.drawable.shirt, "Shirt",0,150.0),
      ItemCloth(R.drawable.top, "Top",0,150.0),
      ItemCloth(R.drawable.under_garments, "Under Garments",0,150.0),
      ItemCloth(R.drawable.skirt, "Skirt",0,150.0),
   )
}







