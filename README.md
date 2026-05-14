# 🍽️ RecipeNest – Premium Modern Android Recipe App

RecipeNest is a modern Android Recipe Application built using Kotlin and Jetpack Compose in Android Studio as part of the ApexPlanet Android App Development Internship – Task 5.

The app provides a beautiful and smooth user experience with real-time recipe data, modern UI design, onboarding experience, Firebase authentication, API integration, category filtering, persistent favorites, offline handling, settings management, notifications, dark mode support, and professional animations.

---

# ✨ Features

## 🚀 Core Features

- Splash Screen
- Modern Onboarding Screens
- Get Started Flow
- Login & Signup Authentication
- Persistent User Sessions
- Modern Jetpack Compose UI
- Bottom Navigation
- Real-Time Recipe API Integration
- Internet Recipe Images
- Search Functionality
- Recipe Detail Screen
- Favorites Screen
- Profile Screen
- Settings Screen
- Recently Viewed Recipes
- Push Notification UI
- Offline Internet Detection
- Dark Mode Support
- Responsive Layout
- Smooth Navigation Animations
- Pull-to-Refresh Support
- Interactive Favorite System
- Logout Functionality

---

## 🌐 API & Backend Features

- Retrofit API Integration
- JSON Parsing using Gson
- Real Recipe Fetching
- Dynamic Recipe Loading
- Search + Category Filtering
- Persistent Favorites
- Room Database Integration
- Firebase Authentication
- SharedPreferences Integration
- DataStore Preferences
- Real-Time Data Updates
- Offline Favorite Access
- API Error Handling
- Empty State UI
- Internet Connectivity Detection

---

## 🎨 UI/UX Features

- Premium Splash Screen
- Animated Onboarding Experience
- Smooth Page Indicators
- Modern Material 3 Design
- Featured Recipe Banner
- Category Filtering Chips
- Beautiful Recipe Cards
- Shimmer Loading Animation
- Smooth Screen Transitions
- Professional Typography & Spacing
- Responsive Compose Layouts
- Rounded Buttons & Cards
- Interactive UI Components
- Elegant Dark Mode Design
- Clean Bottom Navigation

---

## ❤️ Advanced Features

- Persistent Favorites using Room Database
- Offline Favorite Storage
- Real-Time Favorite Updates
- Animated Navigation Transitions
- Search + Category Combined Filtering
- DataStore Preferences
- Notification Support
- Recently Viewed Recipe Tracking
- Offline Internet Detection Screen
- Onboarding State Management
- User Session Persistence
- Dynamic Theme Switching

---

# 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Kotlin | Programming Language |
| Jetpack Compose | Modern Android UI |
| Retrofit | API Integration |
| Gson Converter | JSON Parsing |
| Coil | Image Loading |
| Room Database | Local Storage |
| Firebase Authentication | User Authentication |
| DataStore | Preferences Storage |
| SharedPreferences | Onboarding State |
| Material 3 | UI Components |
| Coroutines | Asynchronous Programming |
| Navigation Compose | Screen Navigation |

---

# 🌐 API Used

## TheMealDB API

https://www.themealdb.com/api.php

### Used for:

- Fetching recipes
- Recipe images
- Recipe categories
- Recipe instructions
- Search functionality
- Dynamic recipe loading

---

# 📱 App Screenshots

## 🚀 Splash Screen

![Splash Screen](screenshots/splash_screen.png)

---

## 👋 Onboarding Screens

### 🍕 Discover Recipes

![Onboarding 1](screenshots/onboarding_1.png)

### ❤️ Save Favorites

![Onboarding 2](screenshots/onboarding_2.png)

### 👨‍🍳 Cook Smarter

![Onboarding 3](screenshots/onboarding_3.png)

---

## 🔐 Login Screen

![Login Screen](screenshots/login_screen.png)

---

## 📝 Signup Screen

![Signup Screen](screenshots/signup_screen.png)

---

## 🏠 Home Screen

![Home Screen](screenshots/home_screen.png)

![Home Screen 2](screenshots/home_screen_2.png)

---

## 🍱 Online Recipes

![Online Recipes](screenshots/online_recipes.png)

---

## 🧩 Category Filtering

![Category Filtering](screenshots/category_filtering.png)

---

## 🔍 Search Functionality

![Search Functionality](screenshots/search_screen.png)

---

## 📖 Recipe Detail Screen

![Recipe Detail](screenshots/recipe_detail.png)

![Recipe Detail 2](screenshots/recipe_detail_2.png)

---

## ❤️ Favorites Screen

![Favorites Screen](screenshots/favorites_screen.png)

![Favorites Screen 2](screenshots/favorites_screen_2.png)

---

## 🌙 Dark Mode

![Dark Mode](screenshots/dark_mode.png)

---

## 👤 Profile Screen

![Profile Screen](screenshots/profile_screen.png)

![Profile Screen 2](screenshots/profile_screen_2.png)

---

## ⚙️ Settings Screen

![Settings Screen](screenshots/settings_screen.png)

---

## 🕘 Recently Viewed Recipes

![Recently Viewed](screenshots/recently_viewed.png)

---

## 🔔 Notification UI

![Notification UI](screenshots/notification_ui.png)

---

## 📴 Offline Internet Detection

![Offline Screen](screenshots/offline_screen.png)

---

## ⚠️ Empty State UI

![Empty State UI](screenshots/empty_state.png)

---

# 📂 Project Structure

```bash
com.example.recipenest
│
├── api
│   ├── RecipeApiService.kt
│   ├── FavoriteRecipeDao.kt
│   ├── RecipeDatabase.kt
│   └── RetrofitInstance.kt
│
├── auth
│   ├── LoginScreen.kt
│   ├── SignupScreen.kt
│   ├── AuthViewModel.kt
│   └── FirebaseAuthManager.kt
│
├── onboarding
│   ├── OnboardingScreen.kt
│   ├── OnboardingItem.kt
│   └── OnboardingManager.kt
│
├── components
│   ├── CategoryChip.kt
│   ├── FeaturedBanner.kt
│   ├── OnlineRecipeCard.kt
│   ├── RecentRecipeCard.kt
│   ├── ShimmerRecipeCard.kt
│   ├── BottomNavigationBar.kt
│   ├── ThemeManager.kt
│   └── SettingsManager.kt
│
├── model
│   ├── OnlineRecipe.kt
│   ├── FavoriteRecipeEntity.kt
│   ├── RecentRecipe.kt
│   └── UserData.kt
│
├── screens
│   ├── SplashScreen.kt
│   ├── HomeScreen.kt
│   ├── FavoriteScreen.kt
│   ├── ProfileScreen.kt
│   ├── SettingsScreen.kt
│   ├── RecipeDetailScreen.kt
│   └── OfflineScreen.kt
│
├── navigation
│   ├── AppNavigation.kt
│   └── ScreenRoutes.kt
│
├── utils
│   ├── NetworkUtils.kt
│   ├── NotificationHelper.kt
│   ├── RecentRecipeManager.kt
│   ├── SettingsDataStore.kt
│   └── Constants.kt
│
└── MainActivity.kt