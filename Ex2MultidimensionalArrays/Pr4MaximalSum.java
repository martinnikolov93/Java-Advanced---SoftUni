package Ex2MultidimensionalArrays;

import java.util.Scanner;

public class Pr4MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[scanner.nextInt()][scanner.nextInt()];
        scanner.nextLine();

        //Fill the matrix from input
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        
        int bestIndexRow = -1;
        int bestIndexCol = -1;

        int maxSum = Integer.MIN_VALUE;

        for (int row = 0; row <= matrix.length - 3; row++) {
            for (int col = 0; col <= matrix[row].length - 3; col++) {

                int sum = 0;

                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                       int number = matrix[i][j];
                       sum += number;
                    }
                }

                if (sum > maxSum) {
                    maxSum = sum;
                    bestIndexRow = row;
                    bestIndexCol = col;
                }
                
            }
        }

        System.out.println("Sum = " + maxSum);

        for (int row = bestIndexRow; row < bestIndexRow + 3; row++) {
            for (int col = bestIndexCol; col < bestIndexCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }
}
