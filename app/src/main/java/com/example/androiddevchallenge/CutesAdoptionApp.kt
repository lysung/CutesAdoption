package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Animal

@Composable
fun CutesAdoptionApp() {
    val list = ArrayList<Animal>()
    for (i in 1..20) {
        list.add(Animal("Cat$i", R.mipmap.ic_launcher))
    }
    Animals(
        list
    , onAdopted = { /*TODO*/ })

}

@Composable
fun Animals(list: List<Animal>, onAdopted: (Animal) -> Unit) {
    Surface(Modifier.fillMaxSize()) {
        LazyColumn(content = {
            items(list.size, itemContent = { item ->
                AnimalItem(list[item])
            })
        })
    }
}

@Composable
fun AnimalItem(item: Animal) {
    Row(
        Modifier
            .padding(16.dp)
            .height(80.dp)
            .fillMaxWidth()
    ) {
        Image(painter = painterResource(id = item.typeIcon), contentDescription = item.name)
        Text(text = item.name)
    }
}