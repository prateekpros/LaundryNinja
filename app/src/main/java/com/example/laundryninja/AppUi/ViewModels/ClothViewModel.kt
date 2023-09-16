package com.example.laundryninja.AppUi.ViewModels

import androidx.lifecycle.ViewModel
import com.example.laundryninja.AppUi.ClothRepository
import com.example.laundryninja.dataclass.ItemCloth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class WashViewModel:ViewModel() {

    private val _cloths = MutableStateFlow(ClothRepository())
    var clothsState = _cloths.asStateFlow()
    var total = 0

    fun add(item: ItemCloth){
        item.qty  +=1
        total +=1
        item.service = "Wash & Iron"

    }

    fun sub(item:ItemCloth){
        item.qty  -=1
        total -=1
    }

    fun washInfo():List<ItemCloth>{
        return clothsState.value
    }

    fun clothAdded():List<ItemCloth>{

        var list = emptyList<ItemCloth>()

        washInfo().forEach { cloth->
            if(cloth.qty>0)
                list += cloth
        }
        return  list
    }

}


class IronViewModel:ViewModel() {
    private val _cloths = MutableStateFlow(ClothRepository())
    var clothsState = _cloths.asStateFlow()
    var total = 0

    fun add(item:ItemCloth){
        item.qty  +=1
        total +=1
        item.service = "Iron"
    }

    fun sub(item:ItemCloth){
        item.qty  -=1
        total -=1
    }



    fun ironInfo():List<ItemCloth>{
        return clothsState.value
    }

    fun clothAdded():List<ItemCloth>{

        var list = emptyList<ItemCloth>()

        ironInfo().forEach { cloth->
            if(cloth.qty>0)
                list += cloth
        }
        return  list
    }


}

class DryCleanViewModel:ViewModel() {
    private val _cloths = MutableStateFlow(ClothRepository())
    var clothsState = _cloths.asStateFlow()


    var total = 0

    fun add(item:ItemCloth){
        item.qty  +=1
        total +=1
        item.service = "Dry Cleaning"
    }

    fun sub(item:ItemCloth){
        item.qty  -=1
        total -=1
    }

    fun dryCleanInfo():List<ItemCloth>{
        return clothsState.value
    }

    fun clothAdded():List<ItemCloth>{

        var list = emptyList<ItemCloth>()

        dryCleanInfo().forEach { cloth->
            if(cloth.qty>0)
                list += cloth
        }
        return  list
    }


}

class CartViewModel(washViewModel: WashViewModel,
                    ironViewModel: IronViewModel,
                    dryCleanViewModel: DryCleanViewModel,
                    ):ViewModel(){

            var washList = MutableStateFlow(washViewModel.clothAdded()).asStateFlow()
            var ironList = MutableStateFlow( ironViewModel.clothAdded()).asStateFlow()
            var dryCleanList = MutableStateFlow(dryCleanViewModel.clothAdded()).asStateFlow()


            fun info():Triple<List<ItemCloth>, List<ItemCloth>, List<ItemCloth>>{
                return Triple(washList.value,ironList.value,dryCleanList.value)
            }

}

