# 🚗 Car Race Simulation

A Java Swing application that simulates a car race with:
- Cars moving forward at random speeds
- Start semaphore with **Gray → Yellow → Green**
- Background sound during the race
- **Game Over** dialog showing the winner and replay option

---

## 🛠️ Technologies Used
- **Java 8+**
- **Swing** for graphical interface
- **Threads** to simulate each car independently
- **javax.sound.sampled** for playing `.wav` sounds

---

## 📂 Project Structure
- `Car.java` – Class representing each car (thread).
- `CarPanel.java` – Draws cars and the finish line.
- `CarRace.java` – Main class, starts the game and manages logic.
- `SemaphorePanel.java` – Draws the traffic semaphore.
- `SemaphoreThread.java` – Simulates the semaphore color changes.
- `GameOverDialog.java` – Window showing the winner.
- `PlaySound.java` – Plays and stops race sound.

---

## ▶️ How to Run
1. Clone or download the project.
2. Make sure you have **Java JDK 8+** installed.
3. Place the audio file `shanghai-formula-1-grand-prix.wav` inside the `resources` folder of the project (in `src/main/resources` if using Maven/Gradle).
4. Compile and run the application:

```bash
javac CarRace.java
java CarRace
```

---

## 🎮 Gameplay
1. The semaphore will show **Gray → Yellow → Green** before the race starts.
2. Cars start moving at different speeds until they cross the finish line.
3. Background sound plays during the race.
4. At the end, a **Game Over Dialog** appears with:
   - Winner’s name and time
   - Options: **Replay** or **Close**

---

## 📸 Screenshot (example)
*(You can add a screenshot of the game here)*

---

## 📜 License
This project was created for educational purposes.
