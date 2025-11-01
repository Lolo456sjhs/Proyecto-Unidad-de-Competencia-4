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

### 1️⃣ ```markdown
Regresión Lineal Simple
```csv
x,y
1,2
2,3
3,5
4,7
5,11
6,13

### 3️⃣ Regresión Polinomial
- Formato: `x,y` (cada línea un par de valores)
- Ejemplo (grado 2):
1,2
2,3
3,5
4,7
5,11
6,13

### 2️⃣ Regresión Lineal Múltiple
- Formato: `x1,x2,...,xn,y` (último valor es la variable dependiente)
- Ejemplo (2 predictores):
1,2,5
2,1,6
3,4,10
4,3,12
5,5,15
6,2,13

Esta es la imagen en si de como debende ir:






<img width="482" height="588" alt="image" src="https://github.com/user-attachments/assets/801bd820-e1fe-4900-9e0f-e00d024dbab1" />



## Salida esperada
Dependiendo del método, la aplicación mostrará:

- **PROCESO:** sumatorias y cálculos intermedios.  
- **ECUACIÓN FINAL:** la ecuación de regresión resultante.

## Dependencias
- Apache Commons Math 3.6.1 (`commons-math3`)


## Autor
- Lolo456sjhs
