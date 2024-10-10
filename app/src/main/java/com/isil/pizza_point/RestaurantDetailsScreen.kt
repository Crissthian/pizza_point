package com.isil.pizza_point

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun RestaurantDetailsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFA07A))
    ) {
        // Top image with back button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.laromana),
                contentDescription = "Pizza",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = { /* Handle back navigation */ },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }

        // Restaurant details
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "La Romana",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    tint = Color.Red
                )
            }
            Text(
                text = "Pizzeria",
                fontSize = 18.sp,
                color = Color(0xFF006400)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.mipmap.star),
                    contentDescription = "Star",
                    tint = Color(0xFFFFD700),
                    modifier = Modifier.size(24.dp)
                )
                Icon(
                    painter = painterResource(id = R.mipmap.star),
                    contentDescription = "Star",
                    tint = Color(0xFFFFD700),
                    modifier = Modifier.size(24.dp)
                )
                Icon(
                    painter = painterResource(id = R.mipmap.star),
                    contentDescription = "Star",
                    tint = Color(0xFFFFD700),
                    modifier = Modifier.size(24.dp)
                )
                Icon(
                    painter = painterResource(id = R.mipmap.star),
                    contentDescription = "Star",
                    tint = Color(0xFFFFD700),
                    modifier = Modifier.size(24.dp)
                )
                Icon(
                    painter = painterResource(id = R.mipmap.star),
                    contentDescription = "Star",
                    tint = Color(0xFFFFD700),
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Pizzeria La Romana es un lugar acogedor donde puedes disfrutar de deliciosas pizzas y pastas con la tradición de siempre. Tienen una amplia variedad de pizzas en su carta, para todos los gustos.",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        // Menu buttons
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(
                onClick = { /* Handle menu click */ },
                modifier = Modifier
                    .width(200.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4500))
            ) {
                Text("Menu")
            }

            InfoButton(text = "Horario de atención: 12pm - 11pm")
            InfoButton(text = "Teléfono: 460 6573")
            InfoButton(text = "Dirección: Calle Bartolome Figaro #193")
            InfoButton(text = "Pagina Web: laromana.com.pe")
        }

        // Social media icons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                painter = painterResource(id = R.mipmap.facebook),
                contentDescription = "Facebook",
                tint = Color.Blue,
                modifier = Modifier.size(48.dp)
            )
            Icon(
                painter = painterResource(id = R.mipmap.instagram),
                contentDescription = "Instagram",
                tint = Color(0xFFE1306C),
                modifier = Modifier.size(48.dp)

            )
            Icon(
                painter = painterResource(id = R.mipmap.whatsapp),
                contentDescription = "WhatsApp",
                tint = Color(0xFF25D366),
                modifier = Modifier.size(48.dp)

            )
        }
    }
}

@Composable
fun InfoButton(text: String) {
    Button(
        onClick = { /* Handle info click */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6347)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text, color = Color.White)
    }
}