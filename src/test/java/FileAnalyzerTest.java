import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FileAnalyzerTest {

    private FileHandler mockFileHandler;
    private FileAnalyzer fileAnalyzer;

    @BeforeEach
    public void setUp() {
        mockFileHandler = mock(FileHandler.class);
        fileAnalyzer = new FileAnalyzer(mockFileHandler);
    }

    @Test
    public void testAnalyzeFiles_WithAscendingSort() throws IOException {
        String inputFilePath = "input.txt";
        List<String> inputWords = Arrays.asList("apple", "banana", "apple", "cherry");

        when(mockFileHandler.readWords(inputFilePath)).thenReturn(inputWords);

        System.setIn(new java.io.ByteArrayInputStream("sort -a\n".getBytes()));

        fileAnalyzer.analyzeFiles(inputFilePath);

        ArgumentCaptor<List<String>> wordsCaptor = ArgumentCaptor.forClass(List.class);
        verify(mockFileHandler).writeWordsToFile(wordsCaptor.capture(), eq("F2.txt")); // F2.txt is expected

        List<String> writtenWords = wordsCaptor.getValue();

        assertEquals(Arrays.asList("apple", "banana", "cherry"), writtenWords);
    }

    @Test
    public void testAnalyzeFiles_WithDescendingSort() throws IOException {
        String inputFilePath = "input.txt";
        List<String> inputWords = Arrays.asList("apple", "banana", "apple", "cherry");

        when(mockFileHandler.readWords(inputFilePath)).thenReturn(inputWords);

        System.setIn(new java.io.ByteArrayInputStream("sort -d\n".getBytes()));

        fileAnalyzer.analyzeFiles(inputFilePath);

        ArgumentCaptor<List<String>> wordsCaptor = ArgumentCaptor.forClass(List.class);
        verify(mockFileHandler).writeWordsToFile(wordsCaptor.capture(), eq("F2.txt")); // F2.txt is expected

        List<String> writtenWords = wordsCaptor.getValue();

        assertEquals(Arrays.asList("cherry", "banana", "apple"), writtenWords);
    }

    @Test
    public void testAnalyzeFiles_WithMostFrequentWord() throws IOException {
        String inputFilePath = "input.txt";
        List<String> inputWords = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "banana");
        when(mockFileHandler.readWords(inputFilePath)).thenReturn(inputWords);

        System.setIn(new java.io.ByteArrayInputStream("sort -a\n".getBytes()));

        fileAnalyzer.analyzeFiles(inputFilePath);

        verify(mockFileHandler).writeWordsToFile(anyList(), eq("F2.txt")); // F2.txt is expected
    }
}
