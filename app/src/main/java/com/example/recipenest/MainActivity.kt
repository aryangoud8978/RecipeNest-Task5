package com.example.recipenest

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import kotlinx.coroutines.launch
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recipenest.auth.LoginScreen
import com.example.recipenest.auth.SignupScreen
import com.example.recipenest.components.ThemeManager
import com.example.recipenest.screens.FavoriteScreen
import com.example.recipenest.screens.HomeScreen
import com.example.recipenest.screens.OnboardingScreen
import com.example.recipenest.screens.ProfileScreen
import com.example.recipenest.utils.OnboardingPreferences
import com.example.recipenest.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            val darkMode =
                ThemeManager.isDarkMode.value

            MaterialTheme(

                colorScheme =

                    if (darkMode)
                        darkColorScheme()
                    else
                        lightColorScheme()

            ) {

                AppScreen()
            }
        }
    }
}

@Composable
fun AppScreen() {

    val context = LocalContext.current

    val onboardingPreferences =
        remember {
            OnboardingPreferences(context)
        }

    val coroutineScope =
        rememberCoroutineScope()

    val hasSeenOnboarding by
    onboardingPreferences
        .hasSeenOnboarding
        .collectAsState(initial = false)

    val authViewModel: AuthViewModel =
        viewModel()

    var showSplash by remember {
        mutableStateOf(true)
    }

    var showSignup by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {

        Handler(
            Looper.getMainLooper()
        ).postDelayed({

            showSplash = false

        }, 2500)
    }

    when {

        showSplash -> {

            SplashScreen()
        }

        !hasSeenOnboarding -> {

            OnboardingScreen(

                onFinish = {

                    coroutineScope.launch {

                        onboardingPreferences
                            .saveOnboardingState()
                    }
                }
            )
        }

        authViewModel.isUserLoggedIn.value -> {

            MainScreen(

                onLogout = {

                    authViewModel.logoutUser()
                }
            )
        }

        else -> {

            if (showSignup) {

                SignupScreen(

                    onSignupClick = { email, password ->

                        authViewModel.signupUser(
                            email,
                            password
                        )
                    },

                    onNavigateToLogin = {

                        showSignup = false
                    },

                    errorMessage =
                        authViewModel.authError.value,

                    isLoading =
                        authViewModel.isLoading.value
                )

            } else {

                LoginScreen(

                    onLoginClick = { email, password ->

                        authViewModel.loginUser(
                            email,
                            password
                        )
                    },

                    onNavigateToSignup = {

                        showSignup = true
                    },

                    errorMessage =
                        authViewModel.authError.value,

                    isLoading =
                        authViewModel.isLoading.value
                )
            }
        }
    }
}

@Composable
fun MainScreen(
    onLogout: () -> Unit
) {

    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    Scaffold(

        bottomBar = {

            NavigationBar {

                NavigationBarItem(

                    selected = selectedItem == 0,

                    onClick = {
                        selectedItem = 0
                    },

                    icon = {
                        Text("🏠")
                    },

                    label = {
                        Text("Home")
                    }
                )

                NavigationBarItem(

                    selected = selectedItem == 1,

                    onClick = {
                        selectedItem = 1
                    },

                    icon = {
                        Text("❤️")
                    },

                    label = {
                        Text("Favorites")
                    }
                )

                NavigationBarItem(

                    selected = selectedItem == 2,

                    onClick = {
                        selectedItem = 2
                    },

                    icon = {
                        Text("👤")
                    },

                    label = {
                        Text("Profile")
                    }
                )
            }
        }

    ) { paddingValues ->

        Box(
            modifier = Modifier.padding(
                paddingValues
            )
        ) {

            when (selectedItem) {

                0 -> {

                    HomeScreen(
                        onRecipeClick = {}
                    )
                }

                1 -> {

                    FavoriteScreen()
                }

                2 -> {

                    ProfileScreen(
                        onLogout = onLogout
                    )
                }
            }
        }
    }
}

@Composable
fun SplashScreen() {

    val scale = remember {
        Animatable(0.6f)
    }

    LaunchedEffect(true) {

        scale.animateTo(

            targetValue = 1f,

            animationSpec = tween(

                durationMillis = 1200,

                easing = FastOutSlowInEasing
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(

                    colors = listOf(

                        Color(0xFFFF8C42),
                        Color(0xFFFF6B00)
                    )
                )
            ),

        contentAlignment = Alignment.Center
    ) {

        Column(

            horizontalAlignment =
                Alignment.CenterHorizontally,

            verticalArrangement =
                Arrangement.Center
        ) {

            Text(

                text = "🍽️",

                fontSize =
                    (120 * scale.value).sp
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Text(

                text = "RecipeNest",

                fontSize =
                    (38 * scale.value).sp,

                fontWeight = FontWeight.Bold,

                color = Color.White
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(

                text = "Cook • Explore • Enjoy",

                fontSize = 18.sp,

                color = Color.White.copy(
                    alpha = 0.9f
                )
            )
        }
    }
}