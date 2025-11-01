# Proyecto Unidad de Competencia 4

Este proyecto es una **herramienta en Java para realizar regresiones estadísticas**.  
Permite calcular:

- **Regresión Lineal Simple** (una variable independiente)  
- **Regresión Lineal Múltiple** (varias variables independientes)  
- **Regresión Polinomial** (de cualquier grado)

Los resultados incluyen el **proceso paso a paso** y la **ecuación final**, y se muestran en un **JTable**.


## Cómo ejecutar el proyecto

1. Clonar o descargar el repositorio.  
2. Abrir el proyecto en NetBeans o cualquier IDE compatible con Maven.  
3. Ejecutar el proyecto (`Run` o `java -jar MetodosRegresion-1.0-SNAPSHOT-jar-with-dependencies.jar`).  
4. Ingresar los datos en el cuadro de texto `txtDatos`.  
5. Seleccionar el **método de regresión** usando los **radio buttons**.  
6. Presionar el botón **Calcular**.  
7. Observar el procedimiento y la ecuación final en `txtResultado`.  

## Cómo ingresar los datos

En el proyecto, los datos se ingresan en el cuadro de texto `txtDatos`.  
Debes escribirlos en **formato CSV**, separados por comas, y cada fila representa un registro.  

Ejemplode Cada metodo:
```csv
### 1️⃣ Regresión Lineal Simple
x,y
1,2
2,3
3,5
4,7
5,11
6,13
2️⃣ Regresión Lineal Múltiple
x1,x2,y
1,2,5
2,1,6
3,4,10
4,3,12
5,5,15
6,2,13
3️⃣ Regresión Polinomial (grado 2)
x,y
1,5
2,6
3,10
4,12
5,15
6,13
Cada línea debe terminar con un salto de línea y no debe dejar espacios vacíos entre los valores.
