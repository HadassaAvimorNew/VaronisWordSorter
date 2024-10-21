import java.io.IOException;
import java.util.List;

public interface FileHandler {
    List<String> readWords(String filePath) throws IOException;
    void writeWordsToFile(List<String> words, String outputFilePath) throws IOException;
}
