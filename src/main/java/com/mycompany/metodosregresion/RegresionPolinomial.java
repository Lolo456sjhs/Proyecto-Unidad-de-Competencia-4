package com.mycompany.metodosregresion;

import javax.swing.table.DefaultTableModel;
import org.apache.commons.math3.linear.*;

/**
 * Clase para realizar regresión polinomial
 */
public class RegresionPolinomial {

    /**
     * Calcula regresión polinomial y genera procedimiento paso a paso
     * @param x vector de predictor
     * @param y vector de variable dependiente
     * @param grado grado del polinomio
     * @param modeloTabla JTable para mostrar los datos
     * @return String con procedimiento y ecuación final
     */
    public static String calcular(double[] x, double[] y, int grado, DefaultTableModel modeloTabla) {
        int n = x.length;

        // Construir matriz de Vandermonde
        double[][] Xmat = new double[n][grado + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= grado; j++) {
                Xmat[i][j] = Math.pow(x[i], j);
            }
        }

        RealMatrix Xrm = new Array2DRowRealMatrix(Xmat);
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

        // Llenar JTable
        modeloTabla.setColumnIdentifiers(new Object[]{"i", "x", "y"});
        modeloTabla.setRowCount(0);
        for (int i = 0; i < n; i++) modeloTabla.addRow(new Object[]{i + 1, x[i], y[i]});

        // Construir resultado
        StringBuilder sb = new StringBuilder();
        sb.append("=== REGRESIÓN POLINOMIAL ===\n");
        sb.append("Grado: ").append(grado).append("\n\n");
        sb.append("=== COEFICIENTES ===\n");
        for (int i = 0; i < coef.getDimension(); i++) {
            sb.append(String.format("a%d = %.6f\n", i, coef.getEntry(i)));
        }

        sb.append("\n=== ECUACIÓN ===\n");
        sb.append("y = ");
        for (int i = 0; i < coef.getDimension(); i++) {
            sb.append(String.format("%.6f", coef.getEntry(i)));
            if (i > 0) sb.append("x^").append(i);
            if (i < coef.getDimension() - 1) sb.append(" + ");
        }
        sb.append("\n");

        return sb.toString();
    }
}
