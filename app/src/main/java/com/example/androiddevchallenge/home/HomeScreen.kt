/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.Screen
import com.example.androiddevchallenge.data.AnimalRepository
import com.example.androiddevchallenge.model.Animal

@Composable
fun HomeScreen(navigateTo: (Screen) -> Unit, repository: AnimalRepository) {
    Column {
        TopAppBar(
            title = {
                Text(
                    text = "Cutes", textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(
                            Alignment.Center
                        )
                )
            },
        )

        Animals(repository.animals, navigateTo)
    }
}

@Composable
fun Animals(list: List<Animal>, navigateTo: (Screen) -> Unit) {
    Surface(
        Modifier
            .fillMaxSize(),
        color = colorResource(R.color.purple_200)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp, 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(
                    list.size,
                    itemContent = { item ->
                        AnimalItem(list[item], navigateTo)
                    }
                )
            }
        )
    }
}

@Composable
fun AnimalItem(item: Animal, navigateTo: (Screen) -> Unit) {
    Row(
        Modifier
            .clip(RoundedCornerShape(4.dp))
            .clickable { navigateTo(Screen.Detail(item.cuteId)) }
            .background(Color.White)
            .padding(16.dp)
            .fillMaxWidth()

    ) {

        Image(
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(4.dp)),
            painter = painterResource(id = item.typeIcon),
            contentDescription = item.name,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = item.title ?: item.name,
                style = MaterialTheme.typography.h6,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = item.name, style = MaterialTheme.typography.subtitle2)
        }
    }
}
