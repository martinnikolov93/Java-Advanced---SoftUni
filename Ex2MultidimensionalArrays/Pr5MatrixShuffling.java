package Ex2MultidimensionalArrays;

import java.util.Scanner;

public class Pr5MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[scanner.nextInt()][scanner.nextInt()];
        scanner.nextLine();

        //Fill the matrix from input
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.next();
            }
            scanner.nextLine();
        }

        String input;

        while(!"END".equals(input = scanner.nextLine())){
            String[] data = input.split("\\s+");

            String command = data[0];

            if (!command.equals("swap") || data.length != 5) {
                System.out.println("Invalid input!");
                continue;

            }

            int row1 = Integer.parseInt(data[1]);
            int col1 = Integer.parseInt(data[2]);

            int row2 = Integer.parseInt(data[3]);
            int col2 = Integer.parseInt(data[4]);

            try {
                String valueToKeep = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = valueToKeep;
            } catch (Exception e) {
                System.out.println("Invalid input!");
                continue;
            }

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
            }

        }


    }
}
