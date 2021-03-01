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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Animal

class AnimalRepository {

    val animals: ArrayList<Animal> = arrayListOf(
        Animal(
            "1",
            "wof",
            R.drawable.dog,
            R.drawable.dog,
            "A friendly dog from Wolf's farm",
            "He is my best friend. When I'm sad, he always stay with me."
        ),
        Animal(
            "2",
            "mikky",
            R.drawable.mao,
            R.drawable.mao,
            "A friendly cat from Wolf's farm",
            "He is my best friend. When I'm sad, he always stay with me."
        ),
        Animal(
            "3",
            "piggy",
            R.drawable.pig,
            R.drawable.pig,
            "A friendly pig from Wolf's farm",
            "He is my best friend. When I'm sad, he always stay with me."
        ),
        Animal(
            "4",
            "qikky",
            R.drawable.qie,
            R.drawable.qie,
            "A friendly penguin from Wolf's farm",
            "He is my best friend. When I'm sad, he always stay with me."
        ),
        Animal(
            "5",
            "wukky",
            R.drawable.yingwu,
            R.drawable.yingwu,
            "A friendly parrot from Wolf's farm",
            "He is my best friend. When I'm sad, he always stay with me."
        ),
        Animal(
            "6",
            "zkky",
            R.drawable.zcool,
            R.drawable.zcool,
            "A friendly giraffe Wolf's farm",
            "He is my best friend. When I'm sad, he always stay with me."
        )
    )

    fun findAnimalByCuteId(cuteId: String): Animal? {
        return animals.find { it.cuteId == cuteId }
    }
}
