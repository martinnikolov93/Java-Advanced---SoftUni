package ExamPreparation.RetakeExam16April2019;

import java.util.Scanner;

public class Pr2HelensAbduction {
    public static int energy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        energy = Integer.parseInt(scanner.nextLine());

        int rows = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[rows][];

        int parisRow = 0;
        int parisCol = 0;

        int helenaRow = 0;
        int helenaCol = 0;

        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();

            if (line.contains("P")) {
                parisRow = i;
                parisCol = line.indexOf("P");
            }
            if (line.contains("H")) {
                helenaRow = i;
                helenaCol = line.indexOf("H");
            }
        }

        boolean isAbducted = false;

        while (energy > 0 && !isAbducted) {
            energy--;
            String direction = scanner.next();
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            scanner.nextLine();

            field[row][col] = 'S';
            field[parisRow][parisCol] = '-';
            if (direction.equals("up") && canMove(parisRow - 1, parisCol, field)) {
                parisRow--;
                isAbducted = moveParis(parisRow, parisCol, field);
            } else if (direction.equals("down") && canMove(parisRow + 1, parisCol, field)) {
                parisRow++;
                isAbducted = moveParis(parisRow, parisCol, field);
            } else if (direction.equals("left") && canMove(parisRow - 1, parisCol, field)) {
                parisRow--;
                isAbducted = moveParis(parisRow, parisCol, field);
            } else if (direction.equals("right") && canMove(parisRow + 1, parisCol, field)) {
                parisRow++;
                isAbducted = moveParis(parisRow, parisCol, field);
            }

            field[parisRow][parisCol] = 'P';
        }

        if (isAbducted) {
            field[parisRow][parisCol] = '-';
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
        } else {
            field[parisRow][parisCol] = 'X';
        }

        printField(field);
    }

    public static boolean moveParis(int newRow, int newCol, char[][] field) {
        boolean isAbducted = false;
        if (field[newRow][newCol] == 'S') {
            energy -= 2;
        } else if (field[newRow][newCol] == 'H') {
            isAbducted = true;
        }

        return isAbducted;
    }

    private static boolean canMove(int newRow, int newCol, char[][] field) {
        return newRow >= 0 && newRow < field.length && newCol >= 0 && newCol < field[newRow].length;
    }

    private static void printField(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }
    }


}
