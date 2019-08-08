package Ex2MultidimensionalArrays;

import java.util.Scanner;

public class Pr3DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        //Fill the matrix from input
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int input = scanner.nextInt();
                matrix[row][col] = input;
            }
            scanner.nextLine();
        }

        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        int row = 0;
        int col = 0;

        for (int i = 0; i < matrix.length; i++) {

            primaryDiagonalSum += matrix[row][col];
            secondaryDiagonalSum += matrix[row][matrix.length - 1 - i];

            row++;
            col++;
        }


        int diagonalSumDifference = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);

        System.out.println(diagonalSumDifference);
    }
}
