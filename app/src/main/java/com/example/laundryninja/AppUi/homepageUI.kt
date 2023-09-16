package com.example.laundryninja.AppUi

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalLaundryService
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocalLaundryService
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingBasket
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.laundryninja.R
import com.example.laundryninja.navigation.Screen
import com.example.laundryninja.navigation.getCurrentRoute


//
//@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable
//fun check(navController: NavController){
//
//    var selectedTabIndex by remember { mutableIntStateOf(0) }
//    val pagerState = rememberPagerState { bottomTabItems.size }
//
//    LaunchedEffect(selectedTabIndex) {
//        pagerState.animateScrollToPage(selectedTabIndex)
//    }
//
//    LaunchedEffect(pagerState.currentPage) {
//        selectedTabIndex = pagerState.currentPage
//
//    }
//
//    Column() {
//
//
//
//
//        TabRow(selectedTabIndex = selectedTabIndex) {
//            bottomTabItems.forEachIndexed { index, item ->
//                Tab(
//                    selected = index == selectedTabIndex,
//                    onClick = {
//                        selectedTabIndex = index;
//                        // navController.navigate(item.title)
//                    },
//                    text = { Text(text = item.title) },
//                    icon = {
//                        Icon(
//                            imageVector = if (index == selectedTabIndex) item.selected else item.unselected,
//                            contentDescription = item.title
//                        )
//                    }
//                )
//            }
//        }
//
//
//
//        HorizontalPager(
//            state = pagerState,
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(1f)
//        ) { index ->
//
//            when (index) {
//                0 -> HomePage(navController = navController)
//                1 -> OrderPage(navController = navController)
//                2 -> CartPage(navController = navController)
//                3 -> ProfilePage(navController = navController)
//            }
//        }
//    }
//}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomePage(navController: NavController) {

    Scaffold(
        topBar = { TopAppBar() },
        bottomBar = { BottomAppBar(navController) } // BottomBar(navController);
    ) {
        Column(Modifier.fillMaxSize()) {
            SearchBar()
            TopCard()
            HomeBody(navController)
        }
    }

}




@Composable
fun TopAppBar(){

    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically) {

        Image(painter = painterResource(id = R.drawable.person), contentDescription =null,
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp)
        )

        Spacer(Modifier.width(180.dp))

        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Notifications, contentDescription =null )

        }
    }
}



val bottomTabItems = listOf(
    TabItem(
        title = "Home",
        unselected = Icons.Outlined.Home,
        selected = Icons.Filled.Home
    ),
    TabItem(
        title = "Orders",
        unselected = Icons.Outlined.LocalLaundryService,
        selected = Icons.Filled.LocalLaundryService
    ),
    TabItem(
        title = "Cart",
        unselected = Icons.Outlined.ShoppingBasket,
        selected = Icons.Filled.ShoppingBasket
    ),
    TabItem(
        title = "Profile",
        unselected = Icons.Outlined.Person,
        selected = Icons.Filled.Person
    )
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomBar(navController: NavController){
//    var selectedTabIndex by remember { mutableIntStateOf(0) }
//    val pagerState = rememberPagerState { bottomTabItems.size }
//
//    LaunchedEffect(selectedTabIndex) {
//        pagerState.animateScrollToPage(selectedTabIndex)
//    }
//
//    LaunchedEffect(pagerState.currentPage) {
//        selectedTabIndex = pagerState.currentPage
//
//    }
//
//    Column() {
//
//
//        TabRow(selectedTabIndex = selectedTabIndex) {
//            bottomTabItems.forEachIndexed { index, item ->
//                Tab(
//                    selected = index == selectedTabIndex,
//                    onClick = {
//                        selectedTabIndex = index;
//                       // navController.navigate(item.title)
//                    },
//                    text = { Text(text = item.title) },
//                    icon = {
//                        Icon(
//                            imageVector = if (index == selectedTabIndex) item.selected else item.unselected,
//                            contentDescription = item.title
//                        )
//                    }
//                )
//            }
//        }
//
//
//
//        HorizontalPager(
//            state = pagerState,
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(1f)
//        ) { index ->
//
//            when (index) {
//                0 -> HomePage(navController = navController)
//                1 -> OrderPage(navController = navController)
//                2 -> CartPage(navController = navController)
//                3 -> ProfilePage(navController = navController)
//            }
//        }
//    }
}
@SuppressLint("UnrememberedMutableState")
@Composable
fun BottomAppBar(navController: NavController){

    var selectedTabItem by mutableIntStateOf(0)


    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically) {

        IconButton(onClick = {
            selectedTabItem =0
            navController.navigate(route = Screen.Home.route) },
            modifier = Modifier
                .weight(1f)
               // .padding(vertical = 10.dp)
            ,
        enabled = getCurrentRoute(navController) != Screen.Home.route
        ) {

            Column(verticalArrangement = Arrangement.SpaceEvenly
                , horizontalAlignment = Alignment.CenterHorizontally) {

                Icon(imageVector = Icons.Default.Home, contentDescription = null)

                Text(text = "Home", fontSize = 15.sp, fontWeight = FontWeight.Normal)
            }

        }

        IconButton(onClick = {
            selectedTabItem =1
            navController.navigate(route = Screen.Order.route) },
            modifier = Modifier.weight(1f),
            enabled = getCurrentRoute(navController) != Screen.Order.route) {

            Column(verticalArrangement = Arrangement.SpaceEvenly
                , horizontalAlignment = Alignment.CenterHorizontally) {

                Icon(imageVector = Icons.Default.LocalLaundryService, contentDescription = null)

                Text(text = "Orders", fontSize = 15.sp, fontWeight = FontWeight.Normal)
            }

        }

        IconButton(onClick = {
            selectedTabItem =2
            navController.navigate(route = Screen.Cart.route) },
            modifier = Modifier.weight(1f),
            enabled = getCurrentRoute(navController) != Screen.Cart.route) {

            Column(verticalArrangement = Arrangement.SpaceEvenly
                , horizontalAlignment = Alignment.CenterHorizontally) {

                Icon(imageVector = Icons.Default.ShoppingBasket, contentDescription = null)

                Text(text = "Cart", fontSize = 15.sp, fontWeight = FontWeight.Normal)
            }

        }

        IconButton(onClick = {
            selectedTabItem =3
            navController.navigate(route = Screen.Profile.route) },
            modifier = Modifier.weight(1f),
            enabled = getCurrentRoute(navController) != Screen.Profile.route) {

            Column(verticalArrangement = Arrangement.SpaceEvenly
                , horizontalAlignment = Alignment.CenterHorizontally) {

                Icon(imageVector = Icons.Default.Person, contentDescription = null)

                Text(text = "Profile", fontSize = 15.sp, fontWeight = FontWeight.Normal)
            }

        }


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var search by remember { mutableStateOf("") }

    TextField(
        value = search,
        onValueChange = { search = it },
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 55.dp, start = 10.dp, end = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .size(height = 45.dp, width = 400.dp),

    )
}




@Composable
fun TopCard() {

    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .padding(vertical = 20.dp, horizontal = 10.dp)
            .size(width = 400.dp, height = 150.dp),
    ) {

        Row(Modifier.padding(all= 10.dp)) {
            Column(Modifier.padding(all= 30.dp)) {

                Text("Get 30% discount" , fontSize = 24.sp)
                Text(text = "on today's order", fontSize = 24.sp)
            }

            Image(painter = painterResource(id = R.drawable.laundry_img),
                contentDescription = null,
                Modifier.size(height = 130.dp, width = 200.dp)
        )

        }
    }
}



@Composable

fun HomeBody(navController: NavController) {
    Column(Modifier.fillMaxSize()) {

        val list2 = LaundryRespository()

        SectionTitle("Order")
        Card(
            Modifier
                .height(150.dp)
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
                .clickable { navController.navigate(route = Screen.Service.route) }) {

            Text("Take Service", textAlign = TextAlign.Center)

        }


        SectionTitle("Nearby Laundry")
        LaundryList(list2)
    }
}


@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(vertical = 5.dp, horizontal = 15.dp),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}







@Composable
fun LaundryList(items: List<ItemData>) {
    LazyRow(Modifier.padding(vertical = 5.dp, horizontal = 10.dp)) {
        items(items) {
            LaundryCard(it.name,it.id)
        }
    }
}

@Composable
fun LaundryCard(text: String, id: Int) {
    Card(
        Modifier
            .size(120.dp, 150.dp)
            .padding(horizontal = 5.dp)
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val imagePainter: Painter = rememberAsyncImagePainter(model = id)


            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop
            )



            Spacer(modifier = Modifier.height(8.dp))
            Text(text = text, fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
        }
    }
}








fun LaundryRespository():List<ItemData>{
    return listOf(
        ItemData(R.drawable.l1, "Super Laundry"),
        ItemData(R.drawable.l2, "EZFY Smart Laundry"),
        ItemData(R.drawable.l3, "The Laundry Store"),
        ItemData(R.drawable.l4, "Laundry Solutions"),

    )
}



data class ItemData(val id: Int, val name: String)
