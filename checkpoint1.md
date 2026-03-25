# Checkpoint 1 - Enzo Wakao

## Passagem de parâmetros obrigatórios na tela de Perfil

1. **Adição de um novo parãmetro obrigatório "nome" na PerfilScreen**
- Alteração feita na classe PerfilScreen, na function PerfilScreen
```kotlin
fun PerfilScreen(modifier: Modifier = Modifier, navController: NavController, nome: String) {}
```
2. **Adicionando o nome do usuário no texto principal da tela**
- Ainda na PerfilScreen, no Text principal
```kotlin
text = "PERFIL - $nome"
```

3. **Parâmetro "nome" implementado na rota para a tela de perfil**
- Alteração feita na classe MenuScreen, no Button responsável pela navegação para a classe PerfilScreen
```kotlin
onClick = { navController.navigate("perfil/Enzo Wakao") }
```

4. **Alterações feitas na classe MainActivity**
- Adicão do parâmetro obrigatório "nome" na rota da tela de perfil
```kotlin
composable(route = "perfil/{nome}") {}
```
- Atribuindo valor recebido ao parâmetro, usando como padrão "Usuário Padrão"
```kotlin
composable(route = "perfil/{nome}") {
    val nome: String? = it.arguments?.getString("nome", "Usuário Genérico")
}
```
- Novo parâmetro "nome" implementado
```kotlin
composable(route = "perfil/{nome}") {
    val nome: String? = it.arguments?.getString("nome", "Usuário Genérico")
    PerfilScreen(modifier = Modifier.padding(innerPadding), navController, nome!!)
}
```

## Passagen de parâmetros opcionais na tela de Pedidos

1. **Adição de um novo parãmetro opcional "cliente" na PedidosScreen**
- Alterações feitas na classe MenuScreen, na function MenuScreen
```kotlin
fun PedidosScreen(modifier: Modifier = Modifier, navController: NavController, cliente: String?) {}
```

2. **Adicionando o nome do usuário no texto principal da tela**
- Ainda na PedidosScreen, no Text principal
```kotlin
text = "PEDIDOS - $cliente"
```

3. **Alterações feitas na classe MainActivity**
- Adicão do parâmetro opcional "cliente" na rota da tela de pedidos
```kotlin
composable(route = "pedidos?cliente={cliente}") {}
```
- Busca pelo valor do parâmetro, caso não haja, valor padrão será "Cliente padrão"
```kotlin
composable(
    route = "pedidos?cliente={cliente}",
    arguments = listOf(navArgument("cliente"){
        defaultValue = "Cliente Padrão"
    })
) {}
```

- Novo parãmetro "cliente" implementado
```kotlin
composable(
    route = "pedidos?cliente={cliente}",
    arguments = listOf(navArgument("cliente"){
        defaultValue = "Cliente Padrão"
    })
) {
    PedidosScreen(modifier = Modifier.padding(innerPadding),
        navController,
        it.arguments?.getString("cliente"))
}
```

## Inserindo valor ao parâmetro opcional na tela de Pedidos

1. **Alteração feita na classe MenuScreen**
- No Button de navegação para a tela de pedidos, atribuir valor ao parãmetro opcional
```kotlin
Button(
    onClick = { navController.navigate("pedidos?cliente = Cliente XPTO") }
)
```

## Passagem de múltiplos parâmetros

1. **Adicionando mais um parãmetro obrigatório "id" na PerfilScreen**
- Alteração feita na classe PerfilScreen, na function PerfilScreen
```kotlin
fun PerfilScreen(modifier: Modifier = Modifier, navController: NavController, nome: String, id: Int) {}
```

2. **Adicionando o id do usuário no texto principal da tela**
- Ainda na PerfilScreen, no Text principal
```kotlin
text = "PERFIL - $nome - ID do Usuário: $id"
```

3. **Parâmetro "id" implementado na rota para a tela de perfil**
- Alteração feita na classe MenuScreen, no Button responsável pela navegação para a classe PerfilScreen
```kotlin
onClick = { navController.navigate("perfil/Enzo Wakao/320474") }
```

4. **Alterações feitas na classe MainActivity**
- Adicão do parâmetro obrigatório "nome" na rota da tela de perfil
```kotlin
composable(route = "perfil/{nome}/{id}") {}
```
- SADSDSADASDASDASDSADASDAS
```kotlin
composable(
    route = "perfil/{nome}/{idade}",
    arguments = listOf(
        navArgument("nome") { type = NavType.StringType },
        navArgument("idade") { type = NavType.IntType }
    )
) {}
```
- Atribuindo valor recebido ao parâmetro, usando 0 como padrão
```kotlin
composable(
    route = "perfil/{nome}/{id}",
    arguments = listOf(
        navArgument("nome") {type = NavType.StringType},
        navArgument("id") {type = NavType.IntType}
    )
) {
    val nome: String? = it.arguments?.getString("nome", "Usuário Padrão")
    val id: Int? = it.arguments?.getInt("id", 0) }
```
- Novo parâmetro "id" implementado
```kotlin
composable(
    route = "perfil/{nome}/{id}",
    arguments = listOf(
        navArgument("nome") {type = NavType.StringType},
        navArgument("id") {type = NavType.IntType}
    )
) {
    val nome: String? = it.arguments?.getString("nome", "Usuário Padrão")
    val id: Int? = it.arguments?.getInt("id", 0)
    PerfilScreen(modifier = Modifier.padding(innerPadding), navController, nome!!, id!!)
}
```
