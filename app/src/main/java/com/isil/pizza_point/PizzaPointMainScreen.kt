package com.isil.pizza_point

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.isil.pizza_point.ui.theme.Salmon

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaPointMainScreen() {
    var searchText by remember { mutableStateOf("") }

    val restaurants = listOf(
        Restaurant("Rustica", R.drawable.rustica),
        Restaurant("Pizza Hut", R.drawable.pizza_hut),
        Restaurant("La Romana", R.drawable.laromana)
    )
    val cartas = listOf(
        Carta("Pizza", R.drawable.pizza),
        Carta("Pasta", R.drawable.pastas),
        Carta("Bebidas", R.drawable.bebidas)
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pizza point", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Profile",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(Color(0xFFED7014))
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Salmon)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .background(Color(0xFF4A0E4E))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.banner),
                        contentDescription = "Pizza Banner",
                        contentScale = ContentScale.FillHeight,
                        colorFilter = ColorFilter.tint(Color.Black, BlendMode.Screen),
                        modifier = Modifier.fillMaxSize(),
                    )
                }
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        "Ingrese su direccion o nombre del restaurant para ver las ofertas",
                        color = Color.Black,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .border(1.dp, Color.White, RoundedCornerShape(16.dp)),

                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White,
                            errorContainerColor = Color.Transparent,
                        ),
                        label = { Text("Direccion o nombre del restaurante") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Color.Black
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .width(160.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                    ) {
                        Text("Buscar", fontSize = 16.sp, color = Color.White)
                    }
                }
            }

            item {
                Column(Modifier.padding(horizontal = 16.dp)) {
                    Text(text = "Restaurantes Destacados", color = Color.Black, fontSize = 20.sp)
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        items(restaurants) { restaurant ->
                            RestaurantCard(restaurant.name, restaurant.imageResId)
                        }
                    }
                }
            }

            item {
                Column(
                    Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .height(300.dp)
                ) {
                    Text(text = "Cartas mas populares", color = Color.Black, fontSize = 20.sp)
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Salmon)
                            .padding(vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(cartas) { carta ->
                            CartaCard(carta.name, carta.imageResId)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RestaurantCard(name: String, imageResId: Int) {
    Card(
        modifier = Modifier
            .width(120.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Restaurant Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)),
                contentScale = ContentScale.Crop
            )
            Text(name, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun CartaCard(name: String, imageResId: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(144.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Menu Item",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Text(text = name, color = Color.Black, fontSize = 20.sp)
        }
    }
}

data class Restaurant(val name: String, val imageResId: Int)
data class Carta(val name: String, val imageResId: Int)
