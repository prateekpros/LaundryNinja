package com.example.laundryninja.AppUi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.laundryninja.AppUi.ViewModels.IronViewModel


@Composable
fun Iron(viewModel: IronViewModel) {

    val cloth = viewModel.ironInfo()

    Column() {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            Modifier
                .height(800.dp)
                .padding(top = 0.dp, start = 0.dp, end = 0.dp, bottom = 100.dp)
        ) {

            items(cloth){ item ->
                ClothButton(item, add = {viewModel.add(item)},sub = {viewModel.sub(item)}
                )
            }

        }


    }
}




