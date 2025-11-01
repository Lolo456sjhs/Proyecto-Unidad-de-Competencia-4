package com.mycompany.metodosregresion;

import javax.swing.table.DefaultTableModel;
import org.apache.commons.math3.linear.*;

public class RegresionLinealMultiple {

    /**
     * Calcula la regresión lineal múltiple y genera texto con sumatorias y ecuación final
     *
     * @param X matriz de predictores (con columna de 1 para intercepto)
     * @param y vector de resultados
     * @param modeloTabla JTable para mostrar datos
     * @return texto con sumatorias y ecuación final
     */
    public static String calcular(double[][] X, double[] y, DefaultTableModel modeloTabla) {
        int n = y.length;
        int vars = X[0].length - 1; // número de predictores

        StringBuilder sb = new StringBuilder();
        sb.append("=== REGRESIÓN LINEAL MÚLTIPLE ===\n\n");

        // --------------------
        // Calcular sumatorias
        // --------------------
        double[] sumX = new double[vars];
        double[] sumX2 = new double[vars];
        double[][] sumXX = new double[vars][vars];
        double[] sumXY = new double[vars];
        double sumY = 0;

        for (int i = 0; i < n; i++) {
            sumY += y[i];
            for (int j = 0; j < vars; j++) {
                sumX[j] += X[i][j + 1];
                sumX2[j] += X[i][j + 1] * X[i][j + 1];
                sumXY[j] += X[i][j + 1] * y[i];
                for (int k = 0; k < vars; k++) {
                    sumXX[j][k] += X[i][j + 1] * X[i][k + 1];
                }
            }
        }

        // Mostrar sumatorias
        for (int j = 0; j < vars; j++) sb.append(String.format("Σx%d = %.4f\n", j + 1, sumX[j]));
        sb.append(String.format("Σy = %.4f\n", sumY));
        for (int j = 0; j < vars; j++) sb.append(String.format("Σx%d^2 = %.4f\n", j + 1, sumX2[j]));
        for (int j = 0; j < vars; j++)
            for (int k = j + 1; k < vars; k++)
                sb.append(String.format("Σx%d*x%d = %.4f\n", j + 1, k + 1, sumXX[j][k]));
        for (int j = 0; j < vars; j++) sb.append(String.format("Σx%d*y = %.4f\n", j + 1, sumXY[j]));

        sb.append("\n");

        // --------------------
        // Llenar JTable
        // --------------------
        String[] columnas = new String[vars + 2];
        columnas[0] = "i";
        for (int j = 1; j <= vars; j++) columnas[j] = "x" + j;
        columnas[vars + 1] = "y";

        modeloTabla.setColumnIdentifiers(columnas);
        modeloTabla.setRowCount(0);
        for (int i = 0; i < n; i++) {
            Object[] fila = new Object[vars + 2];
            fila[0] = i + 1;
            for (int j = 1; j <= vars; j++) fila[j] = X[i][j];
            fila[vars + 1] = y[i];
            modeloTabla.addRow(fila);
        }

        // --------------------
        // Calcular coeficientes β = (X'X)^-1 X'y
        // --------------------
        RealMatrix Xrm = new Array2DRowRealMatrix(X);
        RealVector yv = new ArrayRealVector(y);
        RealVector coef;

        try {
            RealMatrix XT = Xrm.transpose();
            RealMatrix XTX = XT.multiply(Xrm);
            DecompositionSolver solver = new LUDecomposition(XTX).getSolver();
            coef = solver.solve(XT.operate(yv));
        } catch (SingularMatrixException e) {
            throw new RuntimeException("La matriz X'X es singular. Revisa tus datos.", e);
        }

        // --------------------
        // Construir ecuación final
        // --------------------
        sb.append("=== ECUACIÓN ===\n");
        sb.append("y = ");
        sb.append(String.format("%.4f", coef.getEntry(0))); // intercepto
        for (int i = 1; i < coef.getDimension(); i++) {
            sb.append(" + ").append(String.format("%.4f", coef.getEntry(i))).append(" x").append(i);
        }
        sb.append("\n");

        return sb.toString();
    }
}
