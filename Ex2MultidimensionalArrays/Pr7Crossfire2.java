package Ex2MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pr7Crossfire2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        List<List<Integer>> matrix = new ArrayList<>();

        // Fill the matrix
        int counter = 1;
        for (int row = 0; row < rows; row++) {
            List<Integer> rowList = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                rowList.add(counter);
                counter++;
            }
            matrix.add(rowList);
        }

        String input;
        while (!"Nuke it from orbit".equals(input = scanner.nextLine())) {

            int[] command = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

            int row = command[0];
            int col = command[1];
            int radius = command[2];

            if (row < 0 || row >= matrix.size() || col < 0 || col >= matrix.get(row).size()) {
                continue;
            }

            // set right elements to 0
            for (int i = col; i <= col + radius; i++) {
                if (i >= matrix.get(row).size()) {
                    break;
                }
                matrix.get(row).set(i,0);
            }

            //set left elements to 0
            for (int i = col; i >= col - radius; i--) {
                if (i < 0) {
                    break;
                }
                matrix.get(row).set(i,0);
            }

            //set lower elements to 0
            for (int i = row; i <= row + radius; i++) {
                if (i >= matrix.size()) {
                    break;
                }
                try {
                    matrix.get(i).set(col,0);
                }
                catch (Exception e) {
                    //continue with cycle
                }
            }

            // set upper elements to 0
            for (int i = row; i >= row - radius; i--) {
                if (i < 0) {
                    break;
                }
                try {
                    matrix.get(i).set(col,0);
                }
                catch (Exception e) {
                    //continue with cycle
                }
            }

            //set main element to 0
            matrix.get(row).set(col,0);

            //destroy the 0 elements
            for (int i = 0; i < matrix.size(); i++) {


                for (int j = 0; j < matrix.get(i).size(); j++) {
                    if (j >= matrix.get(i).size()) {
                        break;
                    }
                    if (matrix.get(i).get(j) == 0) {
                        matrix.get(i).remove(j);
                        j--;
                    }
                }

                if (matrix.get(i).size() == 0) {
                    matrix.remove(i);
                    i--;
                }
            }

        }

        for (int row = 0; row < matrix.size(); row++) {
            System.out.println(matrix.get(row).toString().replaceAll("\\[|\\]|,", ""));
        }

    }
}
