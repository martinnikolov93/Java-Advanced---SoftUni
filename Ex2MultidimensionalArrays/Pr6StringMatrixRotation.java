package Ex2MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pr6StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] cmd = sc.nextLine().split("[()]");
        int degree = Integer.parseInt(cmd[1]) % 360;
        List<String> words = new ArrayList<>();
        String input = "";

        int maxLength = 0;
        while (!"END".equals(input = sc.nextLine())) {
            words.add(input);
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
        }

        char[][] matrix = new char[words.size()][maxLength];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < maxLength; j++) {
                if (words.get(i).length() <= j) {
                    matrix[i][j] = ' ';
                } else {
                    matrix[i][j] = words.get(i).charAt(j);
                }
            }
        }
        if (degree == 90) {
            printMatrix(rotate90(matrix));

        } else if (degree == 180) {
            printMatrix(rotate180(matrix));
        } else if (degree == 270) {
            printMatrix(rotate270(matrix));
        } else {
            printMatrix(matrix);
        }
    }

    private static char[][] rotate270(char[][] matrix) {
        int rowsRotMatrix = matrix[0].length;
        int colsRotMatrix = matrix.length;
        char[][] rotMatrix = new char[rowsRotMatrix][colsRotMatrix];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rotMatrix[(rowsRotMatrix - 1) - j][i] = matrix[i][j];
            }
        }
        return rotMatrix;
    }

    private static char[][] rotate180(char[][] matrix) {
        char[][] rotMatrix = new char[matrix.length][matrix[0].length];
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                rotMatrix[i][j] = matrix[matrix.length - i - 1][matrix[0].length - j - 1];
            }
        }

        return rotMatrix;
    }

    private static char[][] rotate90(char[][] matrix) {
        int rowsRotMatrix = matrix[0].length;
        int colsRotMatrix = matrix.length;
        char[][] rotMatrix = new char[rowsRotMatrix][colsRotMatrix];
        for (int i = 0; i < colsRotMatrix; i++) {
            for (int j = 0; j < rowsRotMatrix; j++) {
                rotMatrix[j][(colsRotMatrix - 1) - i] = matrix[i][j];
            }
        }

        return rotMatrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
