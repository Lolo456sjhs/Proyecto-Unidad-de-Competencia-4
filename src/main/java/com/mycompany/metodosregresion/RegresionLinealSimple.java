package com.mycompany.metodosregresion;

import javax.swing.table.DefaultTableModel;

/**
 * Clase para realizar regresión lineal simple (una variable independiente)
 */
public class RegresionLinealSimple {

    /**
     * Calcula la regresión lineal simple y genera el procedimiento paso a paso.
     *
     * @param x vector de valores de la variable independiente
     * @param y vector de valores de la variable dependiente
     * @param modeloTabla JTable para mostrar la tabla de datos
     * @return String con el procedimiento y ecuación final
     */
    public static String calcular(double[] x, double[] y, DefaultTableModel modeloTabla) {
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        // Validación de tamaños
        if (y.length != n) throw new IllegalArgumentException("Los vectores x e y deben tener la misma longitud.");

        // Calcular sumatorias
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        // Pendiente e intercepto
        double denominador = n * sumX2 - sumX * sumX;
        if (denominador == 0) throw new RuntimeException("Denominador cero: pendiente indefinida.");
        double m = (n * sumXY - sumX * sumY) / denominador;
        double b = (sumY - m * sumX) / n;

        // Llenar JTable
        modeloTabla.setRowCount(0);
        modeloTabla.setColumnCount(4);
        modeloTabla.setColumnIdentifiers(new Object[]{"i", "x", "y", "x*y"});
        for (int i = 0; i < n; i++) {
            modeloTabla.addRow(new Object[]{i + 1, x[i], y[i], x[i] * y[i]});
        }

        // Construir texto del procedimiento
        StringBuilder sb = new StringBuilder();
        sb.append("=== REGRESIÓN LINEAL SIMPLE ===\n");
        sb.append("PROCESO:\n");
        sb.append(String.format("n = %d\n", n));
        sb.append(String.format("Σx = %.6f\n", sumX));
        sb.append(String.format("Σy = %.6f\n", sumY));
        sb.append(String.format("Σxy = %.6f\n", sumXY));
        sb.append(String.format("Σx^2 = %.6f\n", sumX2));
        sb.append(String.format("Denominador (n*Σx^2 - (Σx)^2) = %.6f\n", denominador));
        sb.append(String.format("Pendiente (m) = %.6f\n", m));
        sb.append(String.format("Intercepto (b) = %.6f\n", b));

        sb.append("\n=== ECUACIÓN ===\n");
        sb.append(String.format("y = %.6f x + %.6f\n", m, b));

        return sb.toString();
    }
}
