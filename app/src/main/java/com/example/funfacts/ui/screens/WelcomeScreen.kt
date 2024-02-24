package com.example.funfacts.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.funfacts.ui.FactComposable
import com.example.funfacts.ui.FactsViewModel
import com.example.funfacts.ui.TextComponent
import com.example.funfacts.ui.TopBar
import com.example.funfacts.ui.textWithShadow

@Composable
fun WelcomeScreen(username: String?, animalSelected: String?) {
    println("========Inside Welcome screen")
    println("========${username} and ${animalSelected}")
    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
        )
        {
            TopBar(value = "Welcome $username \uD83D\uDE0D")

            TextComponent(textValue = "Thank you for sharing your data", textSize = 24.sp)

            Spacer(modifier = Modifier.size(60.dp))

            val finalText = if (animalSelected == "Cat") "You are a Cat lover \uD83D\uDC31" else "Your are a Dog lover \uD83D\uDC36"

            textWithShadow(value = finalText)

            val factsViewModel: FactsViewModel = viewModel()

            FactComposable(
                value = factsViewModel.generateRandomFacts(animalSelected!!))
            // !! means cannot be null




        }

    }
}
@Preview
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen("username", "animalSelected")
}