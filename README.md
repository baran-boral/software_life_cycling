# 🎮 Tic-Tac-Toe

A simple Tic-Tac-Toe game developed in Java as part of the **Software Life Cycle** course.

---

## ✨ Features

* 🎲 3x3 game board
* 👥 Alternating player turns (X and O)
* ✅ Move validation
* 🖥️ Board display after each move
* 🏆 Winner detection (horizontal, vertical, diagonal)
* 🤝 Draw detection
* 🧪 Unit tests with JUnit 5
* 🔄 Continuous Integration with GitHub Actions
* 🚀 Continuous Delivery with automatic JAR artifact and GitHub Releases

---

## 📁 Project Structure

* **Board** – game board representation
* **Player** – player information and marker
* **TicTacToe** – game logic and flow
* **Unit tests** – located in `src/test`

---

## 🔀 Development Workflow

This project follows a GitHub-based workflow:

* 🌿 Feature branches for each user story
* 🔃 Pull requests before merging into `main`
* 🔒 Protected main branch
* ⚙️ Automatic build and test execution using GitHub Actions
* 📦 Automatic packaging with Maven
* 📤 Automatic JAR artifact upload
* 🚀 Automatic GitHub release creation after merges to `main`

---

## 🛠️ Technologies

* ☕ Java 21
* 📦 Maven
* 🧪 JUnit 5
* 🐙 GitHub Actions

---

## 🔨 Build

Clone the repository and run:

```bash
mvn package
```

Run tests:

```bash
mvn test
```

The generated JAR file can be found in:

```text
target/software_life_cycling-1.0-SNAPSHOT.jar
```

---

## 🔄 CI/CD Pipeline

Every push triggers an automated build and test pipeline.

After merging into the `main` branch:

1. 🧪 Maven runs the tests
2. 📦 The project is packaged
3. ☕ A JAR file is generated
4. 📤 The artifact is uploaded
5. 🚀 A GitHub Release is automatically created

---

## 👨‍💻 Contributors

* baran-boral
* bhaveshsood02
* Durmaz-jpg

---

## 📜 License

This project was created for educational purposes as part of the **Software Life Cycle** course.
