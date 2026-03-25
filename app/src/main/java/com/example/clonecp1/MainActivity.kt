package com.example.clonecp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.clonecp1.ui.theme.CloneCP1Theme
import com.example.clonecp1.screens.LoginScreen
import com.example.clonecp1.screens.MenuScreen
import com.example.clonecp1.screens.PedidosScreen
import com.example.clonecp1.screens.PerfilScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CloneCP1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                    ) {
                        composable(route = "login") {
                            LoginScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "menu") {
                            MenuScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(
                            // Adição do parãmetro opcional "cliente" na rota da tela de pedidos
                            route = "pedidos?cliente={cliente}",
                            // Busca pelo valor do parâmetro, caso não haja, valor padrão será "Cliente padrão"
                            arguments = listOf(navArgument("cliente"){
                                defaultValue = "Cliente Padrão"
                            })
                        ) {
                            // Novo parãmetro "cliente" implementado
                            PedidosScreen(modifier = Modifier.padding(innerPadding),
                                navController,
                                it.arguments?.getString("cliente"))
                        }
                        // Adicão dos parâmetro obrigatórios "nome" e "id" na rota da tela de perfil
                        composable(
                            route = "perfil/{nome}/{id}",
                            arguments = listOf(
                                navArgument("nome") {type = NavType.StringType},
                                navArgument("id") {type = NavType.IntType}
                            )
                        ) {

                            // Atribuindo valor recebido ao parâmetro, usando como padrão "Usuário Padrão"
                            val nome: String? = it.arguments?.getString("nome", "Usuário Padrão")
                            // Atribuindo valor recebido ao parâmetro, usando 0 como padrão
                            val id: Int? = it.arguments?.getInt("id", 0)
                            // Novos parâmetros "nome" e "id" implementados
                            PerfilScreen(modifier = Modifier.padding(innerPadding), navController, nome!!, id!!)
                        }
                    }
                }
            }
        }
    }
}