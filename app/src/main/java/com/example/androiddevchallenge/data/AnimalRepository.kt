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