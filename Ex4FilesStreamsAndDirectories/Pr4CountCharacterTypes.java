package Ex4FilesStreamsAndDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Pr4CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String inputFile = "res/input.txt";
        String outputFile = "res/output.txt";

        String text = Files.readString(Path.of(inputFile)).replaceAll("\r\n", " ");

        int[] countData = new int[3];

        String vowels = "aeiou";

        String ponctuation = "!,.?";

        for (char symbol : text.toCharArray()) {
            if (vowels.contains(symbol + "")) {
                    countData[0]++;
            } else if(ponctuation.contains(symbol + "")) {
                countData[1]++;
            } else if (symbol != ' ') {
                countData[2]++;
            }
        }

        PrintWriter printer = new PrintWriter(outputFile);

        printer.printf("Vowels: %d\n" +
                "Consonants: %d\n" +
                "Punctuation: %d\n",countData[0],countData[2],countData[1]);

        printer.close();
    }
}
