package Ex2MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class tests {
    public static void main(String[] args) {
        String[] matrix = new String[3];

        matrix[0] = "asan";
        matrix[1] = "";
        matrix[2] = "asan2";

        System.out.println(Arrays.toString(matrix));

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i] + " ");
        }

    }
}
