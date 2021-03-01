package com.example.androiddevchallenge

import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.data.AnimalRepository
import com.example.androiddevchallenge.detail.DetailScreen
import com.example.androiddevchallenge.home.HomeScreen

@Composable
fun CutesAdoptionApp(navigationViewModel: NavigationViewModel, repository: AnimalRepository) {
    
    Crossfade(navigationViewModel.currentScreen) {
        screen -> 
        Surface(color = MaterialTheme.colors.background) {
            when(screen) {
                is Screen.Home -> HomeScreen(navigationViewModel::navigateTo, repository)
                is Screen.Detail -> DetailScreen(cuteId = screen.cuteId, repository, onBack ={ navigationViewModel.onBack() })
            }
        }
    }
}