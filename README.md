# Movie App

## Overview

The Movie App is a simple Android application built with Kotlin that fetches and displays a list of movies. It allows users to view movie details, including the description (Director, Plot, Release Date, Cast, etc.), in a detailed view by tapping on a movie item. 

The app uses a local database to store movie data and presents the information in an easy-to-use interface with a dropdown arrow that reveals additional movie details.

## Features

- Displays a list of movies in a RecyclerView.
- Each movie item has a title, poster, and a dropdown arrow.
- When tapped, the dropdown reveals additional information such as:
  - Director
  - Plot
  - Release Date
  - Cast
- Stores the movie data locally using Room Database.
- Uses a simple and clean UI built with Kotlin.

## Screenshots

![main_screen](https://github.com/user-attachments/assets/28ab8297-6487-4117-8961-0e722ac04b30)
![details](https://github.com/user-attachments/assets/aa0029a5-b380-4df3-8831-169ecf2be3e0)
![detail_zoom](https://github.com/user-attachments/assets/54a5e2d1-4f2b-4b1e-a196-ea672ce9266d)


## Tech Stack

- **Kotlin**: The primary language for development.
- **Room Database**: For storing movie data locally.
- **Lazy Column**: For displaying the list of movies.
- **ViewModel**: handle UI-related data lifecycle.
- **Material Design**: For UI components like buttons and dropdown.

## Requirements

- Android Studio
- Android API 21+ (Lollipop or above)

## Setup

1. Clone the repository to your local machine.

   ```bash
   git clone https://github.com/MaddyRizvi/movie_App_Kotlin

# Movie App

## 2. Open the project in Android Studio:

1. Open Android Studio and select **Open an existing project**.
2. Navigate to the project directory and open the project folder.

## 3. Add necessary dependencies:

1. Open the `build.gradle` files (both the project-level and app-level) and ensure the following dependencies are included:
   - Room Database dependencies.
   - RecyclerView dependencies.
   - LiveData and ViewModel dependencies.

2. Sync the project with Gradle by clicking **File** > **Sync Project with Gradle Files**.

## 4. Build and Run the App:

1. Once the necessary dependencies are added and synced, build the app by clicking **Build** > **Make Project**.
2. Run the app on an emulator or a physical device by clicking the **Run** button in Android Studio.

## 5. App Usage

1. Open the app to see the list of available movies.
2. Tap any movie item to view more details such as director, plot, release date, and cast.
3. The dropdown arrow on each movie card will reveal these additional details.

## 6. Database Structure

The app uses **Room Database** to store the movie data locally. Below is the structure of the movie table:

- **Movie Table:**
  - `id`: Unique identifier for each movie.
  - `title`: The title of the movie.
  - `posterUrl`: The URL for the movie poster.
  - `releaseDate`: Release date of the movie.
  - `director`: Director of the movie.
  - `cast`: The cast of the movie.
  - `plot`: A brief plot description of the movie.

## 7. Contributing

If you'd like to contribute to the Movie App, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-name`).
3. Commit your changes (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Create a pull request with a description of the changes.

## 8. License

This project is for personal use and learning purposes. It is not licensed for commercial use.

## 9. Acknowledgements

- **Room Database**: For local data storage.
- **RecyclerView**: For efficient list management.
- **Kotlin**: For a concise and modern programming experience in Android.
- **Material Design**: For designing the user interface components.

