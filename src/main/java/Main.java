public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: sort words <input_file_path>");
            return;
        }

        String inputFilePath = args[0];;

        // Use FileHandlerFactory to get the appropriate FileHandler
        FileHandler fileHandler = FileHandlerFactory.getFileHandler(inputFilePath);

        // Create FileAnalyzer
        FileAnalyzer fileAnalyzer = new FileAnalyzer(fileHandler);

        // Analyze the files
        fileAnalyzer.analyzeFiles(inputFilePath);
    }
}
