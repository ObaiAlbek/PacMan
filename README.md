# 🟡 PacMan – Java Game

Ein klassisches **Pac-Man-Spiel**, vollständig in **Java (Swing/AWT)** programmiert.  
Dieses Projekt dient als Übung zur **grafischen Programmierung**, **Ereignissteuerung**, **Spiellogik** und **Objektorientierung (OOP)**.

---

## 🗂️ Projektstruktur

```

PacMan/
├── GameContainer.java     # Einstiegspunkt – erstellt Fenster und initialisiert das Spiel
├── GameFenster.java       # Hauptfenster (JFrame) für das Spiel
├── Gameplay.java          # Hauptlogik des Spiels (Spielablauf, Bewegung, Punkte)
├── Geist.java             # Klasse für die Geister-Logik und Bewegung
├── PacMan.java            # Klasse für den Pac-Man (Spieler)
├── SpielKarte.java        # Spielfeld / Karte mit Punkten und Wänden
├── test.java              # Testklasse oder Einstiegspunkt für Unit-Tests
└── README.md              # Projektdokumentation

````

---

## 🎮 Spielbeschreibung

Der Spieler steuert **Pac-Man**, um alle **Punkte auf dem Spielfeld** zu sammeln, während er den **Geistern ausweicht**.  
Wenn ein Geist Pac-Man berührt, verliert der Spieler eine Runde.  
Ziel ist es, **alle Punkte zu essen**, ohne von einem Geist gefangen zu werden.

---

## ⚙️ Features

✅ Bewegung des Pac-Man per Tastatur  
✅ Dynamische Karte mit Hindernissen  
✅ Gegner (Geister) mit eigener KI / Bewegung  
✅ Punktesystem und Level-Fortschritt  
✅ Game Loop mit Timer-Steuerung  
✅ Modulare Klassenstruktur (OOP)

---

## 🧠 Lernziele

- Objektorientierte Programmierung in Java  
- 2D-Grafik mit `javax.swing` und `java.awt`  
- Tastatureingaben mit `KeyListener`  
- Game Loop und Frame-Updates mit `javax.swing.Timer`  
- Kollisionserkennung und Spiellogik  

---

## ▶️ Ausführung

Kompiliere und starte das Spiel über die Konsole:

```bash
javac *.java
java GameContainer
````

Oder öffne das Projekt in deiner IDE (z. B. IntelliJ IDEA, Eclipse, VS Code) und starte die Klasse `GameContainer`.

---

## 🎯 Steuerung

| Taste           | Aktion               |
| --------------- | -------------------- |
| ⬆️ Pfeil hoch   | Bewegung nach oben   |
| ⬇️ Pfeil runter | Bewegung nach unten  |
| ⬅️ Pfeil links  | Bewegung nach links  |
| ➡️ Pfeil rechts | Bewegung nach rechts |

---

## 💡 Erweiterungsideen

* 🔵 Power-Ups hinzufügen (Pac-Man kann Geister fressen)
* 🧱 Neue Karten / Level hinzufügen
* 🔊 Soundeffekte und Hintergrundmusik
* 📊 Highscore-System mit Datei-Speicherung
* 🧠 Verbesserte Gegner-KI

---

## 🧑‍💻 Autor

**Obai Albek**
Student der Informatik – TH Mannheim
GitHub: [ObaiAlbek](https://github.com/ObaiAlbek)

