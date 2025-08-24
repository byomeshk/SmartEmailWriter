# 🚀 Smart Email Writer - A Gemini-Powered Chrome Extension

This project is a powerful Chrome extension that uses Google's Gemini API to help you craft perfect email replies instantly. It integrates a simple frontend with a robust Spring Boot backend to deliver AI-powered responses based on the content and desired tone.



## ✨ Features

-   **AI-Powered Replies:** Leverages the Google Gemini API to generate context-aware and human-like email replies.
-   **Tone Selection:** Allows you to choose a tone for your reply (e.g., Professional, Casual, Friendly).
-   **Simple UI:** An intuitive and clean user interface built with React and Material-UI.
-   **Easy Integration:** Designed to work as a browser extension, making it readily accessible.
-   **One-Click Copy:** Easily copy the generated response to your clipboard.

***

## ⚙️ How It Works

The project is split into a backend server and a frontend Chrome extension.

#### Input
1.  The user provides the **content** of the email they want to reply to.
2.  The user selects a **tone** from a dropdown menu (e.g., Professional).

#### Process
1.  The Chrome extension sends the content and tone to the Spring Boot backend API.
2.  The backend securely calls the Google Gemini API with a carefully crafted prompt.
3.  Gemini processes the request and generates a relevant email reply.

#### Output
1.  The backend sends the generated text back to the extension.
2.  The extension displays the **AI-generated email reply** in the user interface, ready to be copied.

***

## 🛠️ Tech Stack

-   **Backend:**
    -   Java 17
    -   Spring Boot 3
    -   Google Gemini API
    -   Maven
-   **Frontend / Chrome Extension:**
    -   JavaScript
    -   React.js
    -   HTML5 & CSS3
    -   Material-UI (MUI)
    -   Axios

***

## 🏁 Getting Started

Follow these instructions to get the project up and running on your local machine.

### Prerequisites

Make sure you have the following software installed:
-   Java (JDK 17 or later)
-   Apache Maven
-   Node.js and npm
-   Google Chrome

### 1. Backend Setup (Spring Boot)

First, you need to set up and run the server that connects to the Gemini API.

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/your-username/your-repo-name.git](https://github.com/your-username/your-repo-name.git)
    cd your-repo-name/backend-folder
    ```

2.  **Configure your API Key:**
    -   Navigate to the `src/main/resources/` directory.
    -   Rename the `application.properties.example` file to `application.properties`.
    -   Open `application.properties` and add your Google Gemini API key:
        ```properties
        gemini.api.key=YOUR_GEMINI_API_KEY_HERE
        ```
    > **Note:** Remember to keep your API key secret. Do not commit the `application.properties` file with your key to a public repository.

3.  **Run the server:**
    ```bash
    mvn spring-boot:run
    ```
    The backend server will start on `http://localhost:8080`.

### 2. Frontend Setup & Loading the Extension

Next, load the frontend React application as an unpacked extension in Chrome.

1.  **Open Google Chrome** and navigate to `chrome://extensions`.

2.  **Enable Developer Mode** by clicking the toggle switch in the top-right corner.
    

3.  **Load the Extension:**
    -   Click the **"Load unpacked"** button.
    -   Navigate to the project's frontend/extension directory (e.g., `email-writer-chromeExtension`).
    -   Select the entire folder and click "Open".

4.  **Pin the Extension:** The Smart Email Writer icon will appear in your Chrome toolbar. You can click the puzzle piece icon and pin it for easy access.

You're all set! The extension is now installed and connected to your local backend.

***
