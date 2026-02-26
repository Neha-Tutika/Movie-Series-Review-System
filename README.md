# 🎬 Movie & Series Review System

A console-based Java application that allows users to browse trending movies and series, filter by various criteria, manage a personal watchlist, and write reviews — all powered by OOP principles like **Inheritance**, **Composition**, **Interfaces**, and **Abstraction**.

---

## ✨ Features

- 🔥 **Trending Media** — View top-rated movies and series sorted by IMDb rating
- 🌍 **Filter by Country** — Find content from a specific country
- 🗣️ **Filter by Language** — Browse media in your preferred language
- 🎬 **Search by Director** — Discover all works by a director
- 🎭 **Filter by Genre** — Explore content by genre (Action, Drama, Sci-Fi, etc.)
- 📋 **Watchlist** — Add movies/series to your personal watchlist
- ⭐ **Reviews** — Rate media (1–5) and leave comments
- 👥 **Multi-user Support** — Switch between users in the same session
- ✅ **Input Validation** — Email format check, rating bounds, empty input guards

---

## 🏗️ OOP Concepts Used

| Concept | Where Used |
|---------|-----------|
| **Abstraction** | `Media` is an abstract class with `displayDetails()` |
| **Inheritance** | `Movie` and `Series` extend `Media` |
| **Composition** | `Movie` and `Series` contain a `Platform` object |
| **Interface** | `RatingSystem` implemented by `Movie`, `Series`, `IMDbRating` |
| **Polymorphism** | `displayDetails()` overridden in both `Movie` and `Series` |
| **Encapsulation** | All fields are `private`/`protected` with getters |

---

## 🚀 Getting Started

### Prerequisites

- Java JDK 8 or higher
- Any Java IDE (Eclipse, IntelliJ IDEA, VS Code) or terminal

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/movie-review-system.git
cd movie-review-system
```

### 2. Compile the Project

```bash
javac -d out src/media/*.java src/review/*.java src/system/*.java
```

### 3. Run the Application

```bash
java -cp out system.Main
```

---

## 📦 Package Structure

```
src/
│
├── media/
│   ├── Media.java
│   ├── Movie.java
│   ├── Series.java
│   └── Platform.java
│
├── review/
│   ├── RatingSystem.java
│   ├── IMDbRating.java
│   └── Review.java
│
└── system/
    ├── User.java
    ├── MediaManager.java
    └── Main.java
```


## ⚠️ Validations

| Input | Rule |
|-------|------|
| Email | Must follow valid format (e.g., `user@example.com`) |
| Rating | Must be between **1 and 5** |
| Review Comment | Cannot be empty |
| Duplicate Review | A user cannot review the same media twice |
| Duplicate Watchlist | Same media cannot be added to watchlist twice |
| Country / Language / Director / Genre | Cannot be empty or numeric |

---

