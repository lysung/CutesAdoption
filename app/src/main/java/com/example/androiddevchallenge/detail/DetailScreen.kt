package com.example.androiddevchallenge.detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.Screen
import com.example.androiddevchallenge.data.AnimalRepository
import com.example.androiddevchallenge.model.Animal

@Composable
fun DetailScreen(
    cuteId: String,
    repository: AnimalRepository,
    onBack: () -> Unit
) {
    val animal: Animal? = repository.findAnimalByCuteId(cuteId)

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = stringResource(R.string.cute_detail),
                    style = MaterialTheme.typography.subtitle2,
                    color = LocalContentColor.current
                )
            }, navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            })
        },
        content = { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
            if (animal == null) {
                ErrorContent()
            } else {
                DetailContent(animal = animal, modifier)
            }
        },
    )
}

@Composable
fun DetailContent(animal: Animal, modifier: Modifier = Modifier) {
    Surface(modifier) {
        LazyColumn(content = {
            item {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    painter = painterResource(animal.image), contentDescription = animal.title,
                    contentScale = ContentScale.FillWidth
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = animal.title!!, style = MaterialTheme.typography.h6)
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = (animal.detail ?: "").repeat(20),
                    style = MaterialTheme.typography.body2
                )
            }
        })
    }
}

@Preview
@Composable
fun previewDetailContent() {
    DetailContent(
        animal = Animal(
            "12",
            "Cute",
            image = R.drawable.samo,
            typeIcon = R.drawable.samo,
            title = "This is a very cute Cat"
        ), Modifier
    )
}

@Composable
fun ErrorContent() {
    Surface(Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp),
                painter = painterResource(id = R.drawable.ic_baseline_error_24),
                contentDescription = "Error"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Sorry, Information lost!", fontSize = 16.sp)
        }
    }
}

@Preview
@Composable
fun preError() {
    ErrorContent()
}