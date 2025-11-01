/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.metodosregresion;

/**
 *
 * @author humbe
 */
public class Utils {

    public static double[] textoADouble1D(String texto) {
        String[] lineas = texto.split("\\n");
        double[] arr = new double[lineas.length];
        for (int i = 0; i < lineas.length; i++) {
            arr[i] = Double.parseDouble(lineas[i].trim());
        }
        return arr;
    }

    public static double[][] textoADouble2D(String texto, int columnas) {
        String[] lineas = texto.split("\\n");
        double[][] matriz = new double[lineas.length][columnas];
        for (int i = 0; i < lineas.length; i++) {
            String[] partes = lineas[i].split(",");
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = Double.parseDouble(partes[j].trim());
            }
        }
        return matriz;
    }
}
