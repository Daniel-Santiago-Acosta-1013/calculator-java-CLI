# Calculadora CLI en Java

Una sencilla pero potente calculadora que se ejecuta en la línea de comandos. Puede manejar operaciones básicas, así como potenciación.

## Cómo ejecutar

Compila y ejecuta el archivo `Main.java`.

```bash
javac src/Main.java
java -cp src Main
```

## Uso

Al iniciar el programa, te pedirá que ingreses una operación matemática. Ejemplo:

```
Ingresa tu operación (p.ej., 3*2) o 'salir' para finalizar:
```

Introduce la operación deseada y presiona Enter para ver el resultado. Si deseas salir del programa, escribe `salir`.

## Características

- Soporta las operaciones básicas: suma (+), resta (-), multiplicación (*) y división (/).
- Capacidad de realizar potenciación (^).
- Manejo de errores para divisiones por cero y expresiones inválidas.
- Capaz de evaluar expresiones más complejas utilizando paréntesis.

## Estructura del código

- `Main.java`: Clase principal que contiene el bucle de la interfaz de usuario.
- `Calculator.java`: Clase que contiene la lógica para evaluar las expresiones matemáticas.

## Desarrollado por

[Santiago Acosta]

---

¡Espero que disfrutes utilizando esta calculadora!
