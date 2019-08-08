package Ex2MultidimensionalArrays;

import java.util.Scanner;

public class Pr2MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int rowLetterInt = row + 97;
                char rowLetter = (char)rowLetterInt;
                int middleLetterInt = col + row + 97;
                char middleLetter = (char)middleLetterInt;

                matrix[row][col] = "" + rowLetter + middleLetter + rowLetter;

                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }


    }
}
