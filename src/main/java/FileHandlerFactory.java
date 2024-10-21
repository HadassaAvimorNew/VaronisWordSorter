public class FileHandlerFactory {
    public static FileHandler getFileHandler(String filePath) {
        if (filePath.endsWith(".txt")) {
            return new TxtFileHandler();
        } else {
            throw new UnsupportedOperationException("File type not supported");
        }
    }
}
