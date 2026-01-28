# ↔️ Navegación entre Actividades
____________________________________________________________
# Respuesta a la duda planteada en el punto 3:
## 🧠 Análisis Teórico: ¿Qué pasa "bajo el capó"?

Aquí explicamos cómo Android maneja la memoria y la navegación sin tanto rodeo.

### 1. La Pila de Actividades (The Back Stack) 🥞
Android organiza las pantallas como una **pila de platos** (Modelo LIFO: Last In, First Out).
* **Al navegar (`startActivity`):** Pones un plato nuevo encima. La Activity anterior (`MainActivity`) NO se destruye, solo se queda en **Pause/Stop**. Se "congela" en la memoria RAM con sus datos intactos, esperando a que vuelvas.
* **Al volver (`Back Button`):** El sistema coge el plato de arriba (`SecondActivity`) y lo tira a la basura. Literalmente ejecuta `onDestroy()` y borra sus variables de la memoria. La Activity de abajo se "descongela" y vuelve a estar activa.

### 2. Intent vs. ClickListener 🔫
Para que no se confundan:
* **El ClickListener (`onClick`):** Es el **gatillo**. Es el evento que detecta que el usuario puso el dedo.
* **El Intent:** Es la **bala**. Es un objeto de mensajería pasivo. Por sí solo no hace nada, es simplemente una carta que dice: *"Tengo la intención de ir a esta pantalla"*. El sistema toma esa carta y ejecuta la acción.

### 3. El Contexto (`Context`) 🪪
Es la pieza clave. No es solo la pantalla actual, es como el **carné de identidad** de la app frente al sistema operativo.
* Sin el `Context`, tu código Kotlin es **ciego y sordo**: no puede acceder a la cámara, ni abrir otras pantallas, ni sacar recursos de colores o textos.
* En Compose usamos `LocalContext` para decirle a Android: *"Oiga, soy una app válida, hágame el favor y lance esta nueva actividad"*.
____________________________________________________________

Proyecto demostrativo del flujo de navegación y la gestión de la pila de actividades (Back Stack) en Android.

## 🚀 Funcionalidades
* **Navegación Explícita:** Uso de `Intents` para movernos de la `MainActivity` a la `SecondActivity`.
* **Gestión del Ciclo de Vida:** Control de la creación y finalización de actividades.
* **Finalización de App:** Botón para cerrar la aplicación y limpiar la pila.

## 🛠 Tecnologías Utilizadas
* **Lenguaje:** Kotlin
* **Navegación:** `Intent` explícitos.
* **Componentes:** Multiples `Activities`, `Button`.

---
*Ejercicio 3 de la Tarea Evaluativa 2 - PMDM*
