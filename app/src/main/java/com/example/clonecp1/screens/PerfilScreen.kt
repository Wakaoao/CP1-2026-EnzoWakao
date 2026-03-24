package com.example.clonecp1.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
// Adição dos novos parâmetros obrigatórios "nome" e "id"
fun PerfilScreen(modifier: Modifier = Modifier, navController: NavController, nome: String, id: Int) {

    Box (
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF329F6B))
            .padding(32.dp)
    ) {
        Text(
            // Adicionando o nome do usuário e seu id no texto principal
            text = "PERFIL - $nome - ID do Usuário: $id",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Button(
            onClick = { navController.navigate("menu") },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                text = "Voltar",
                fontSize = 20.sp,
                color = Color.Blue
            )
        }
    }

}