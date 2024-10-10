package com.isil.pizza_point

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.isil.pizza_point.ui.theme.Poppins
import com.isil.pizza_point.ui.theme.Salmon

@Composable
fun PizzaPointLoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Salmon)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "BIENVENIDOS",
                fontSize = 42.sp,
                fontFamily = Poppins,
                color = Color.Black,
                modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.logo), // Replace with your pizza icon
                contentDescription = "Pizza Icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight(0.3f)
                    .clip(RoundedCornerShape(16.dp))
                    .padding(bottom = 16.dp, top = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(1.dp, Color.White, RoundedCornerShape(16.dp))
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(1.dp, Color.White, RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Handle login */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(bottom = 4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("INGRESAR", color = Color.White)
            }

            Button(
                onClick = { /* Handle registration */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(top = 4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("REGISTRARSE", color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.pizza), // Replace with your pizza image
            contentDescription = "Pizza Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(220.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PizzaPointLoginScreenPreview() {
    PizzaPointLoginScreen()
}
