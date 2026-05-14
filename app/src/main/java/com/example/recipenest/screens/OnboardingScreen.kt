package com.example.recipenest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipenest.model.OnboardingPage
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    onFinish: () -> Unit
) {

    val pages = listOf(

        OnboardingPage(
            title = "Discover Recipes",
            description =
                "Explore thousands of delicious recipes from around the world.",
            emoji = "🍕"
        ),

        OnboardingPage(
            title = "Save Your Favorites",
            description =
                "Bookmark your favorite recipes and access them anytime.",
            emoji = "❤️"
        ),

        OnboardingPage(
            title = "Cook Smarter",
            description =
                "Search recipes, explore categories, and enjoy a modern cooking experience.",
            emoji = "👨‍🍳"
        )
    )

    val pagerState = rememberPagerState(
        pageCount = {
            pages.size
        }
    )

    val coroutineScope =
        rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
            .padding(24.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.End
        ) {

            if (pagerState.currentPage != pages.lastIndex) {

                TextButton(

                    onClick = {

                        coroutineScope.launch {

                            pagerState.animateScrollToPage(
                                pages.lastIndex
                            )
                        }
                    }
                ) {

                    Text(
                        text = "Skip",
                        color = Color(0xFFFF6B00)
                    )
                }
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->

            val onboardingPage =
                pages[page]

            Box(
                modifier = Modifier.fillMaxSize(),

                contentAlignment = Alignment.Center
            ) {

                Column(

                    horizontalAlignment =
                        Alignment.CenterHorizontally,

                    verticalArrangement =
                        Arrangement.Center
                ) {

                    Text(
                        text = onboardingPage.emoji,
                        fontSize = 120.sp
                    )

                    Spacer(
                        modifier = Modifier.height(32.dp)
                    )

                    Text(
                        text = onboardingPage.title,

                        fontSize = 32.sp,

                        fontWeight = FontWeight.Bold,

                        color =
                            MaterialTheme.colorScheme.onBackground
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    Text(
                        text = onboardingPage.description,

                        fontSize = 18.sp,

                        color =
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.Center
        ) {

            repeat(pages.size) { index ->

                val color =

                    if (pagerState.currentPage == index)
                        Color(0xFFFF6B00)
                    else
                        Color.LightGray

                Spacer(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(12.dp)
                        .background(
                            color,
                            shape =
                                MaterialTheme.shapes.small
                        )
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        if (pagerState.currentPage == pages.lastIndex) {

            Button(

                onClick = {

                    onFinish()
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),

                colors =
                    ButtonDefaults.buttonColors(
                        containerColor =
                            Color(0xFFFF6B00)
                    )
            ) {

                Text(

                    text = "Get Started",

                    fontSize = 18.sp
                )
            }

        } else {

            Button(

                onClick = {

                    coroutineScope.launch {

                        pagerState.animateScrollToPage(
                            pagerState.currentPage + 1
                        )
                    }
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),

                colors =
                    ButtonDefaults.buttonColors(
                        containerColor =
                            Color(0xFFFF6B00)
                    )
            ) {

                Text(

                    text = "Next",

                    fontSize = 18.sp
                )
            }
        }
    }
}