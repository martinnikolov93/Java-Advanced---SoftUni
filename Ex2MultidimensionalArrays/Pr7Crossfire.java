package Ex2MultidimensionalArrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pr7Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[scanner.nextInt()][scanner.nextInt()];

        scanner.nextLine();

        int counter = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.toString(counter);
                counter++;
            }
        }

        String input;

        while (!"Nuke it from orbit".equals(input = scanner.nextLine())) {

            int[] command = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

            int row = command[0];
            int col = command[1];
            int radius = command[2];

            matrix[row][col] = "";

            //doom row right elemets
            for (int i = col; i <= col + radius; i++) {
                if (i >= matrix[row].length) {
                    break;
                }
                matrix[row][i] = "";
            }

            //doom row left elements
            for (int i = col; i >= col - radius; i--) {
                if (i < 0) {
                    break;
                }
                matrix[row][i] = "";
            }

            //doom col bottom elements
            for (int i = row; i <= row + radius; i++) {
                if (i >= matrix[col].length) {
                    break;
                }
                matrix[i][col] = "";
            }

            //doom col upper elements
            for (int i = row; i >= row - radius; i--) {
                if (i < 0) {
                    break;
                }
                matrix[i][col] = "";
            }

        }

        System.out.println("----");

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("")) {
                    continue;
                }
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
