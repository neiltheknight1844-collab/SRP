## Build a mod JAR (one command)

This project includes scripts that will download a local Gradle distribution (no system Gradle install required) and build the mod jar.

### Windows
Double-click `build_jar.bat` **or** run:
```
build_jar.bat
```

### macOS / Linux
```
./build_jar.sh
```

Output jar(s) will be in:
`build/libs/`

---

# Build JAR (no Gradle install)

This project includes one-click build scripts that download a local Gradle binary (8.8) into `.gradle-bin/` and run `build`.

## Windows
Double-click `build_jar.bat` or run:

```bat
build_jar.bat
```

## macOS / Linux
In a terminal:

```bash
./build_jar.sh
```

The compiled mod JAR will be in `build/libs/`.

---

# SRP Proto (Forge 1.20.1 / FML 47.4.10)

Minimal playable prototype: a single parasite mob + an infestation block + a global evolution stage saved per-world.

## Features
- **Parasite mob** (Monster): basic melee AI, scales HP/damage with evolution stage.
- **Infestation block**: random-ticks; spreads to nearby air/stone/dirt; each spread adds a bit of evolution progress.
- **Evolution system**: stored in `SavedData` (per-dimension storage name `srpproto_evolution`).
- **Server tick**: every ~60 seconds adds small evolution progress.
- **Command** (OP level 2):
  - `/srp_stage get`
  - `/srp_stage set <stage>`
  - `/srp_stage add <progress>`

## Build / Run (local)
1. Install **Java 17**.
2. Ensure you have **Gradle** installed (or generate a wrapper).
3. In this folder:
   - `gradle genIntellijRuns` (optional)
   - `gradle runClient`

If you want a wrapper:
- `gradle wrapper`
- then use `./gradlew runClient` (Linux/macOS) or `gradlew.bat runClient` (Windows)

## Next steps
From here, we can incrementally port real systems:
- richer AI goals (swarm, retreat, evolve)
- multiple parasite variants
- corruption spreading rules
- datapack-driven worldgen

## Build a JAR (no Gradle install)

This project includes one-command build scripts that will download a portable Gradle distribution into `.gradle-bin/` and compile the mod.

### Windows
Double-click `build_jar.bat` **or** run:
```
build_jar.bat
```

### macOS / Linux
Run:
```
./build_jar.sh
```

The built mod JAR will be in:
```
build/libs/
```

