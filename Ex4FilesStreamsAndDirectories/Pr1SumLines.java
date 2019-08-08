package Ex4FilesStreamsAndDirectories;

import java.io.*;


public class Pr1SumLines {
    public static void main(String[] args) {

        String inputFile = "res/input.txt";
        String outputFile = "res/output.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            PrintWriter output = new PrintWriter(new FileWriter(outputFile))){
            String line = reader.readLine();
            while(line != null){
                long sum = 0;

                for (char c : line.toCharArray()) {
                    sum += c;
                }

                output.println(sum);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
