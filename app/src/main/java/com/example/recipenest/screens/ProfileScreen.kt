package com.example.recipenest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipenest.components.ThemeManager

@Composable
fun ProfileScreen(
    onLogout: () -> Unit
) {

    val isDarkMode =
        ThemeManager.isDarkMode.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
            .padding(20.dp)
    ) {

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Text(
            text = "👨‍🍳",
            fontSize = 90.sp
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "Aryan Goud",

            fontSize = 30.sp,

            fontWeight = FontWeight.Bold,

            color =
                MaterialTheme.colorScheme.onBackground
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Android Developer",

            fontSize = 18.sp,

            color =
                MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(20.dp),

            colors = CardDefaults.cardColors(

                containerColor =
                    MaterialTheme.colorScheme.surfaceVariant
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "⚙️ App Settings",

                    fontSize = 20.sp,

                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),

                    horizontalArrangement =
                        Arrangement.SpaceBetween,

                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Text(
                        text = "Dark Mode",

                        fontSize = 18.sp
                    )

                    Switch(

                        checked = isDarkMode,

                        onCheckedChange = {

                            ThemeManager.isDarkMode.value = it
                        }
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(20.dp),

            colors = CardDefaults.cardColors(

                containerColor =
                    MaterialTheme.colorScheme.surfaceVariant
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "👨‍💻 About Developer",

                    fontSize = 20.sp,

                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Text(
                    text = "Name: Aryan Goud",

                    fontSize = 17.sp
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = "Role: Android Developer",

                    fontSize = 17.sp
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text =
                        "Skills: Kotlin, Jetpack Compose, Flutter, Firebase",

                    fontSize = 17.sp
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text =
                        "GitHub: github.com/aryangoud8978",

                    fontSize = 17.sp
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text =
                        "LinkedIn: Aryan Goud",

                    fontSize = 17.sp
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = "Version: RecipeNest v5.0",

                    fontSize = 17.sp
                )
            }
        }

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Button(

            onClick = {

                onLogout()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),

            colors = ButtonDefaults.buttonColors(

                containerColor =
                    Color(0xFFFF6B00)
            )
        ) {

            Text(
                text = "Logout",

                fontSize = 18.sp
            )
        }
    }
}