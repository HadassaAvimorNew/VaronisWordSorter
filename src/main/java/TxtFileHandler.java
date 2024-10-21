import java.io.*;
import java.util.*;

public class TxtFileHandler implements FileHandler {

    // Method to read words from a .txt file
    @Override
    public List<String> readWords(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<String> words = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            String[] splitWords = line.split("\\W+");
            for (String word : splitWords) {
                if (!word.isEmpty()) {
                    words.add(word.toLowerCase());
                }
            }
        }

        reader.close();
        return words;
    }

    // Method to write words to a file
    @Override
    public void writeWordsToFile(List<String> words, String outputFilePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

        for (String word : words) {
            writer.write(word);
            writer.newLine();
        }

        writer.close();
    }
}
