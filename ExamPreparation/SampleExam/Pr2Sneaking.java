package ExamPreparation.SampleExam;

import java.util.Scanner;

public class Pr2Sneaking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] field = new String[n][];

        int samRow = 0;
        int samCol = 0;

        int nikoladzeRow = 0;
        int nikoladzeCol = 0;

        // Fill the field
        for (int row = 0; row < field.length; row++) {
            String[] input = scanner.nextLine().split("");
            field[row] = new String[input.length];
            for (int col = 0; col < input.length; col++) {
                field[row][col] = input[col];
                if (input[col].equals("N")) {
                    nikoladzeRow = row;
                    nikoladzeCol = col;
                }

                if (input[col].equals("S")) {
                    samRow = row;
                    samCol = col;
                }
            }
        }

        String commands = scanner.nextLine();

        for (int i = 0; i < commands.length(); i++) {

            boolean isAlive = true;
            // Move enemies
            for (int row = 0; row < field.length; row++) {
                for (int col = 0; col < field[row].length; col++) {

                    String currentPosition = field[row][col];

                    if (currentPosition.equals("d") && col == 0) {
                        field[row][col] = "b";
                        if (killSamRight(field, row, col)) {
                            isAlive = false;
                        }
                        continue;
                    } else if (currentPosition.equals("b") && col == field[row].length - 1) {
                        field[row][col] = "d";
                        if (killSamLeft(field, row, col)) {
                            isAlive = false;
                        }
                        continue;
                    }

                    // Move enemy right
                    if (currentPosition.equals("b")) {

                        field[row][col] = ".";
                        field[row][col + 1] = "b";

                        // Kill sam if enemy is facing him
                        if (killSamRight(field, row, col)) {
                            isAlive = false;
                        }

                        col++;
                    }

                    // Move enemy left
                    else if (currentPosition.equals("d")) {

                        field[row][col] = ".";
                        field[row][col - 1] = "d";

                        // Kill sam if enemy is facing him
                        if (killSamLeft(field, row, col)) {
                            isAlive = false;
                        }

                        col++;
                    }

                }
            }
            // End moving enemies

            if (!isAlive){
                System.out.println(String.format("Sam died at %d, %d", samRow, samCol));
                printMatrix(field);
                return;
            }

            char command = commands.charAt(i);

            // Move Sam
            switch (command) {
                case 'U':
                    field[samRow][samCol] = ".";
                    field[samRow - 1][samCol] = "S";
                    samRow--;

                    break;

                case 'D':
                    field[samRow][samCol] = ".";
                    field[samRow + 1][samCol] = "S";
                    samRow++;

                    break;

                case 'L':
                    field[samRow][samCol] = ".";
                    field[samRow][samCol - 1] = "S";
                    samCol--;

                    break;

                case 'R':
                    field[samRow][samCol] = ".";
                    field[samRow][samCol + 1] = "S";
                    samCol++;

                    break;
                case 'W':
                    break;

            }

            /*** Debugging ***/
            /*System.out.println("--------------");
            printMatrix(field);
            System.out.println("--------------");*/

            if (printVictoryIfWon(field, samRow, nikoladzeRow, nikoladzeCol)) {
                return;
            }
        }

    }

    public static void printMatrix(String[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }

    public static boolean killSamRight(String[][] field, int row, int col) {
        for (int j = col; j < field[row].length; j++) {
            String sniperPosition = field[row][j];

            if (sniperPosition.equals("S")) {
                field[row][j] = "X";

                return true;
            }
        }

        return false;
    }

    public static boolean killSamLeft(String[][] field, int row, int col) {
        for (int j = col; j >= 0; j--) {
            String sniperPosition = field[row][j];

            if (sniperPosition.equals("S")) {
                field[row][j] = "X";

                return true;
            }
        }

        return false;
    }

    public static boolean printVictoryIfWon(String[][] field, int samRow, int nikoladzeRow, int nikoladzeCol) {
        if (samRow == nikoladzeRow) {
            field[nikoladzeRow][nikoladzeCol] = "X";
            System.out.println("Nikoladze killed!");
            printMatrix(field);
            return true;
        }

        return false;
    }
}
