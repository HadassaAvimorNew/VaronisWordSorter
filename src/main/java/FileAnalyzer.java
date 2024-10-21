import java.io.IOException;
import java.util.*;

public class FileAnalyzer {
    private final FileHandler fileHandler;

    // Constructor accepting FileHandler
    public FileAnalyzer(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public void analyzeFiles(String inputFilePath) {
        // Automatically create the output file path as F2 based on the input file path
        String outputFilePath = inputFilePath.substring(0, inputFilePath.lastIndexOf('\\') + 1) + "F2.txt";

        try {
            // Read words from the input file
            List<String> words = fileHandler.readWords(inputFilePath);

            // Remove duplicates and convert to lower case using WordUtils
            Set<String> uniqueWords = WordUtils.removeDuplicates(words);

            // Get user input for sorting order
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter sorting option: sort -a (ascending), sort -d (descending)");
            String option = scanner.nextLine();
            boolean ascending = option.equals("sort -a");

            // Sort words based on user input
            List<String> sortedWords = WordUtils.sortWords(uniqueWords, ascending);

            // Write sorted words to the output file
            fileHandler.writeWordsToFile(sortedWords, outputFilePath);
            System.out.println("The file " + outputFilePath + " has been created.");

            // Print the most frequent word and its count using WordUtils
            Map.Entry<String, Integer> mostFrequentWord = WordUtils.getMostFrequentWord(words);
            System.out.println("The most frequent word is '" + mostFrequentWord.getKey() + "', count: " + mostFrequentWord.getValue());

        } catch (IOException e) {
            System.out.println("Error reading or writing files: " + e.getMessage());
        }
    }
}
