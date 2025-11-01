# Proyecto: Métodos de Regresión

Este proyecto es una aplicación en Java para calcular diferentes métodos de regresión:  
- **Regresión Lineal Simple**  
- **Regresión Lineal Múltiple**  
- **Regresión Polinomial**  

La aplicación permite ingresar los datos manualmente en un cuadro de texto (`txtDatos`) y obtener el **procedimiento paso a paso** y la **ecuación resultante** en otro cuadro de texto (`txtResultado`).  

## Cómo usar la aplicación

1. Ejecuta el proyecto (`MetodosRegresion-1.0-SNAPSHOT-jar-with-dependencies.jar` el .jar esta en la carpeta tarjet o desde NetBeans).  
2. Selecciona el método de regresión que deseas calcular mediante los **radio buttons**:  
   - Regresión Simple  
   - Regresión Múltiple  
   - Regresión Polinomial  

3. Ingresa los datos en el cuadro `txtDatos` siguiendo las instrucciones según el método seleccionado.  
4. Ingresa el número de variables en `txtNumVariables`:
   - Para **Regresión Simple**: 1  
   - Para **Regresión Múltiple**: número de predictores (x1, x2, ...)  
   - Para **Regresión Polinomial**: grado del polinomio  

5. Presiona el botón **Calcular** para obtener el procedimiento y la ecuación.

## Cómo ingresar los datos

En el proyecto, los datos se ingresan en el cuadro de texto `txtDatos`.  
Debes escribirlos en **formato CSV**, separados por comas, y cada fila representa un registro.  
El formato depende del método de regresión que vayas a usar:

### 1️⃣ Regresión Lineal Simple
- Solo se necesita una variable `x` y la variable `y`.
- Ejemplo:

```csv
x,y
1,2
2,3
3,5
4,7
5,11
6,13
2️⃣ Regresión Lineal Múltiple
Se necesitan dos o más variables independientes (x1, x2, …) y la variable y.

Ejemplo:

csv
Copiar código
x1,x2,y
1,2,5
2,1,6
3,4,10
4,3,12
5,5,15
6,2,13
3️⃣ Regresión Polinomial
Se necesita una variable x y la variable y. El grado del polinomio se define en el campo txtNumVariables.

Ejemplo para un polinomio de grado 2:

csv
Copiar código
x,y
1,5
2,6
3,10
4,12
5,15
6,13

## Salida esperada
Dependiendo del método, la aplicación mostrará:

- **PROCESO:** sumatorias y cálculos intermedios.  
- **ECUACIÓN FINAL:** la ecuación de regresión resultante.

## Dependencias
- Apache Commons Math 3.6.1 (`commons-math3`)


## Autor
- Lolo456sjhs
