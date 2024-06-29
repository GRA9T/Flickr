
# Flickr App

This is a Flickr app built with Kotlin and the Gradle build system. The application interacts with the Flickr API to fetch and display photos.

## Flickr Android Application Features

- Browse photos from Flickr.
- Search for photos by keywords.
- View photo details.
- Landscape orientation support.
- Accessibility feature support (Dynamic Text).

## Installation

### Prerequisites

- Android Studio 4.0 or later
- Kotlin 1.4 or later
- A machine with internet access

### Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/Flickr.git
   cd Flickr
   ```

2. **Open the project in Android Studio:**

   - Launch Android Studio.
   - Select `Open an existing Android Studio project`.
   - Navigate to the directory where you cloned the repository and select it.

3. **Build the project:**

   Android Studio will automatically start syncing and building the project. If it doesn't, you can manually sync the project by selecting `File > Sync Project with Gradle Files`.

4. **Run the app:**

   - Connect your Android device to your machine or start an emulator.
   - Click the `Run` button in Android Studio.

## Dependencies

The project includes the following dependencies:

- **Kotlin Standard Library**: Provides core Kotlin language features.
- **AndroidX Core**: Essential components for Android development.
- **Retrofit**: For making HTTP requests to the Flickr API.
- **Gson**: For JSON parsing.
- **Room**: For local database caching.
- **Lifecycle Components**: For managing UI-related data in a lifecycle-conscious way.

Here is the `build.gradle.kts` file with detailed dependencies:

```kotlin
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdkVersion(33)
    defaultConfig {
        applicationId = "com.app.flickr"
        minSdkVersion(21)
        targetSdkVersion(33)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.room:room-runtime:2.5.1")
    kapt("androidx.room:room-compiler:2.5.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
```

## Usage

Once the app is installed and running, you can:

- Browse through the latest photos from Flickr.
- Use the search bar to find photos by keywords.
- Tap on a photo to view its details.
- Photos will be cached for offline viewing.

## Flickr Android App DEMO

https://img.drive.google.com/file/d/12xnyrjl08L77jK6HSJkD7xfH6t1HHxlW/view?usp=drive_link

## Contributing

1. **Fork the repository.**
2. **Create a new branch:**

   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Make your changes and commit them:**

   ```bash
   git commit -m "Add some feature"
   ```

4. **Push to the branch:**

   ```bash
   git push origin feature/your-feature-name
   ```

5. **Create a pull request.**

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
