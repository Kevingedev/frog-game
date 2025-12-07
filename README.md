FrogGame
=========

Descripción
-----------
FrogGame es mi primer juego Android (orientación horizontal) donde el jugador interactúa con ranas y elementos en pantalla intentando cambiar a las ranas de su posicion. El proyecto está implementado como una aplicación Android con Activities principales `InicioActivity` (pantalla de inicio con video de fondo) y `MainActivity` (lógica principal del juego). Incluye imágenes y audio en `app/src/main/res`.

Características principales
-------------------------
- Pantalla de inicio con video de fondo (`res/raw/fondofrog.mp4`, `fondoinicio.mp4`).
- Juego basado en ImageViews con lógica de interacción en `MainActivity.java`.
- Soporta sonidos (`res/raw/audiofrogs.mp3`, `frogaudio.mp3`).
- Orientación forzada a `landscape` (horizontal).

Estructura relevante
--------------------
- Código de la app: `app/src/main/java/com/example/froggame/` (contiene `InicioActivity.java`, `MainActivity.java`).
- Recursos gráficos: `app/src/main/res/drawable/` (por ejemplo `ranaverde.png`, `ranaroja.png`, `startgame.png`, `restartgame.png`).
- Iconos: `app/src/main/res/mipmap-*dpi/ic_launcher*.webp`.
- Multimedia: `app/src/main/res/raw/` (audio y videos usados en la app).
- Configuración Android/Gradle: `app/build.gradle.kts` y `build.gradle.kts` en la raíz.

Requisitos
---------
- JDK 11+ (Gradle wrapper usa la JDK disponible; el proyecto usa compatibilidad Java 1.8 en `compileOptions`).
- Android Studio (recomendado) o `sdk` + `adb` para instalar en dispositivos.
- SDK Android: `compileSdk` = 34, `targetSdk` = 34, `minSdk` = 24 (ver `app/build.gradle.kts`).
- Dispositivo o emulador Android para ejecutar la app.

Instalación y ejecución (local)
-------------------------------
Usa el Gradle wrapper incluido para construir e instalar:

```bash
# Descargar dependencias y compilar debug
./gradlew assembleDebug

# Instalar en dispositivo/emulador conectado (requiere adb y dispositivo listo)
./gradlew installDebug

# Ejecutar pruebas unitarias
./gradlew test

# Ejecutar pruebas instrumentadas (requiere dispositivo/emulador conectado)
./gradlew connectedAndroidTest
```

También puedes abrir el proyecto en Android Studio: `File -> Open` y seleccionar la carpeta del proyecto. Luego ejecuta la app en un emulador o dispositivo físico.

Comandos útiles de Git
----------------------
- Clonar: `git clone https://github.com/Kevingedev/frog-game.git`
- Hacer build con wrapper: `./gradlew assembleDebug`

Detalles técnicos
-----------------
- Package: `com.example.froggame` (definido en `app/build.gradle.kts` y en `AndroidManifest.xml`).
- Actividades principales:
  - `InicioActivity` — pantalla de inicio con `VideoView` y botón para iniciar el juego.
  - `MainActivity` — lógica del juego, manejo de `ImageView`, sonidos y botones de reinicio/salir.
- Orientación: ambas Activities usan `android:screenOrientation="landscape"`.

Recursos destacados
-------------------
- Imágenes en `app/src/main/res/drawable/`: `ranaverde.png`, `ranaroja.png`, `startgame.png`, `restartgame.png`, `piedra.jpg`, entre otras.
- Videos en `app/src/main/res/raw/`: `fondofrog.mp4`, `fondoinicio.mp4`, `fondoinicio1440.mp4`.
- Audios: `audiofrogs.mp3`, `frogaudio.mp3`.

Cómo contribuir
---------------
- Si quieres contribuir, crea un fork y abre un Pull Request con una descripción clara de los cambios.
- Antes de enviar PRs, asegúrate de que la aplicación compile con `./gradlew assembleDebug`.
- Para cambios en assets (imágenes / audio), por favor incluye archivos optimizados y respeta nombres existentes si reemplazas recursos.

Posibles próximos pasos / mejoras
-------------------------------
- Añadir un archivo `LICENSE` con la licencia deseada (MIT, Apache-2.0, etc.).
- Añadir un `CHANGELOG.md` para seguir la evolución del proyecto.
- Preparar una configuración CI (por ejemplo GitHub Actions) para validar compilación en cada PR.
- Publicar en Google Play (si se desea distribución pública) — requiere firma y configuración de `signingConfigs`.

Contacto
--------
Si necesitas ayuda con compilación o publicación, abre un issue en este repositorio o contacta al autor del proyecto.

------
