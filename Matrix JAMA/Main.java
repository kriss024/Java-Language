package com.java.matrix;

import Jama.Matrix;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        double[][] array;
        array = new double[][]{{1.,2.,3},{4.,5.,6.},{7.,8.,10.}};
        Matrix A = new Matrix(array);
        System.out.println("Column dimension: " + A.getColumnDimension());
        System.out.println("Row dimension: " + A.getRowDimension());
        System.out.println(Arrays.deepToString(A.getArray()));

    }
}
