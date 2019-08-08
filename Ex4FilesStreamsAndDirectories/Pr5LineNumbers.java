package Ex4FilesStreamsAndDirectories;

import java.io.*;

public class Pr5LineNumbers {
    public static void main(String[] args) {

        String inputFile = "res/inputLineNumbers.txt";
        String outputPath = "res/output.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){

            String line = reader.readLine();
            int counter = 1;
            while (line != null){

                writer.println(counter + ". " + line);

                counter++;
                line = reader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
