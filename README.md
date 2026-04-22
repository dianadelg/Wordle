# Wordle (Java CLI)

A command-line implementation of the Wordle game built in Java, featuring persistent player statistics, dictionary-based validation, and a clean object-oriented design.

Developed collaboratively with **Jacob Melancon**.

---

## Overview

This project recreates Wordle in a terminal environment with a focus on:

- Separation of concerns across classes  
- Efficient data structures for performance  
- File-based persistence for player data  

---

## Features

- CLI-based gameplay  
- Player tracking with persistent stats  
- Win/loss tracking by guess count (1–5 attempts)  
- Detection of returning vs. new players  
- Dictionary-based word validation (2,000+ words)  
- Optimized lookup using `HashSet`  
- Random word selection per game  

---

## Tech Stack

- **Language:** Java  
- **Core Concepts:**
  - Object-Oriented Design  
  - File I/O (Scanner, InputStream)  
  - Data Structures (`ArrayList`, `HashSet`)  
  - Exception Handling  
- **Project Structure:** Maven  

---

src/main/java/com/wordle
- Game.java // Game flow and input handling
- Player.java // Player stats and analytics
- WordBank.java // Dictionary loading and validation
- Colors.java // Optional CLI color helper

src/main/resources
- Words.txt // Dictionary of valid words
- Players.txt // Persistent player data

---

## Architecture & Design Decisions

- **Game**
  - Manages game state (secret word, guesses, player session)  
  - Handles input validation (length, duplicate guesses)  

- **WordBank**
  - Loads and stores dictionary words  
  - Provides random word selection  
  - Validates whether a word exists in the dictionary  

- **Player**
  - Tracks wins, losses, and streaks  
  - Supports persistence via file storage  

---

## Data Structure Choices

- **ArrayList**
  - Used for storing words to enable efficient random selection  

- **HashSet**
  - Used for O(1) lookup when validating guesses against the dictionary  

---

## How to Run

Run Game.java directly in your IDE or
```bash
javac -d bin src/main/java/com/wordle/*.java
java -cp bin com.wordle.Gamecture


