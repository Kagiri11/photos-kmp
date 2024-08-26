# Photos Multiplatform :camera:

This Kotlin Multiplatform project fetches photos from the Unsplash API and displays them on both desktop and Android platforms. It leverages a shared module for platform-agnostic logic, data models, and UI components

Supports;\
Android - ✅\
Desktop - ✅

## 🛠️ WIP 🛠️
> Please note that this project is still under development.
>
## Project Structure
- **shared**: Contains platform-independent code, including data models, network requests, business logic, and shared UI components. 
- **desktopApp**: Contains jvm-specific logic e.g dependency injection.
- **androidApp**: Contains Android-specific logic e.g dependency injection.

## Screenshots

|      |      |
| ---- | ---- |
| <img src="https://github.com/user-attachments/assets/8e4c27d1-d095-4d88-82a4-3c3d535e2533" alt="CI CD logo" width="250"> | <img src="https://github.com/user-attachments/assets/4a55ecb5-cba1-4e0d-b137-f078d02c8837" alt="CI CD logo" width="700"> |
| <img src="https://github.com/user-attachments/assets/98b4c01b-0c9f-492a-9d4c-3daa2992d412" alt="CI CD logo" width="250"> | <img src="https://github.com/user-attachments/assets/25f3b851-6bf1-44d2-99c9-c7e10e5546cb" alt="CI CD logo" width="700"> |

## Libraries
- [**Compose Multiplatform**](https://www.jetbrains.com/lp/compose-multiplatform/): Used for building a shared UI across Android and desktop platforms.
- [**kotlinx.serialization**](https://github.com/Kotlin/kotlinx.serialization): A Kotlin serialization library used for converting Kotlin data classes to and from JSON and other formats. It provides a type-safe and efficient way to handle serialization in your application.
- [**DataStore KMP**](https://developer.android.com/kotlin/multiplatform/datastore): A multiplatform version of DataStore, used for storing key-value pairs and typed objects in a shared preferences-like manner across platforms.
- [**Ktor**](https://ktor.io/): A framework used for making network requests. Ktor is used in this project to handle HTTP requests and responses efficiently, allowing for seamless communication with backend services.
- [**App Cash Paging**](https://github.com/cashapp/multiplatform-paging): A library that helps in loading and displaying data efficiently by supporting pagination. This is particularly useful for handling large datasets or lists that need to be loaded incrementally.
- [**Room KMP**](https://developer.android.com/kotlin/multiplatform/room): A multiplatform version of Room, used for managing local SQLite databases. In this project, it is used to save and retrieve favorite photos with ease, providing a reliable data persistence layer.