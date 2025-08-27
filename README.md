# 🚗 Car Race Simulation

O aplicație Java cu interfață grafică (Swing) care simulează o cursă de mașini cu:
- Animație a mașinilor care avansează la viteze aleatorii
- Semafor de start (roșu → galben → verde)
- Sunet de fundal pe durata cursei
- Dialog de **Game Over** cu câștigătorul și opțiune de Replay

---

## 🛠️ Tehnologii folosite
- **Java 8+**
- **Swing** pentru interfața grafică
- **Threads** pentru a simula fiecare mașină independent
- **javax.sound.sampled** pentru redarea sunetelor `.wav`

---

## 📂 Structura proiectului
- `Car.java` – Clasa pentru fiecare mașină (thread).
- `CarPanel.java` – Desenează mașinile și linia de finish.
- `CarRace.java` – Clasa principală, pornește jocul și gestionează logica.
- `SemaphorePanel.java` – Desenează semaforul.
- `SemaphoreThread.java` – Simulează schimbarea culorilor semaforului.
- `GameOverDialog.java` – Fereastra care afișează câștigătorul.
- `PlaySound.java` – Redă și oprește sunetul cursei.

---

## ▶️ Cum rulezi aplicația
1. Clonează sau descarcă proiectul.
2. Asigură-te că ai **Java JDK 8+** instalat.
3. Pune fișierul audio `shanghai-formula-1-grand-prix.wav` în folderul `resources` al proiectului (în `src/main/resources` dacă folosești Maven/Gradle).
4. Compilează și rulează aplicația:

```bash
javac CarRace.java
java CarRace
```

---

## 🎮 Gameplay
1. Se afișează semaforul care trece prin **roșu → galben → verde**.
2. Mașinile pornesc la viteze diferite și avansează până la linia de finish.
3. Pe parcurs se aude un sunet de fundal.
4. La final apare un **Game Over Dialog** cu:
   - Câștigătorul (numele și timpul).
   - Opțiuni: **Replay** sau **Close**.


