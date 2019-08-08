package Ex4FilesStreamsAndDirectories;

import java.io.*;

public class Pr3AllCapitals {
    public static void main(String[] args) {

        String inputFile = "res/input.txt";
        String outputPath = "res/output.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {

            String line = reader.readLine();

            while (line != null){
                writer.println(line.toUpperCase());
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
