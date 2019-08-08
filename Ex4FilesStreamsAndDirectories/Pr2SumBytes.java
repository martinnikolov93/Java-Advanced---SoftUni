package Ex4FilesStreamsAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Pr2SumBytes {
    public static void main(String[] args) throws IOException {
        String inputFile = "res/input.txt";
        String outputFile = "res/output.txt";


        FileReader fileReader = new FileReader(inputFile);

        BufferedReader reader = new BufferedReader(fileReader);

        String line = reader.readLine();

        int sum = 0;

        while (line != null){

            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }

            line = reader.readLine();
        }

        PrintWriter printer = new PrintWriter(outputFile);

        printer.println(sum);

        printer.close();
    }
}
