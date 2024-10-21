# VaronisWordSorter
# File Word Sorter

## Project Overview

The **File Word Sorter** is a simple Java command-line application that reads words from an input text file (`F1.txt`), processes them by removing duplicates, sorting them lexicographically, and writing the result to an output file (`F2.txt`). Additionally, the application can:
- Sort the words in either ascending or descending order.
- Print the most frequent word from the input file and its count.


## Object-Oriented Implementation

This project follows object-oriented programming (OOP) principles, with the following main components:

- **`FileAnalyzer`**: The central class that coordinates the analysis process. It interacts with the file handler to read and write words and uses `WordUtils` for sorting and duplicate removal.
  
- **`FileHandler` Interface**: Abstracts file handling operations. Concrete implementations like `TxtFileHandler` handle different file types.
  
- **`WordUtils`**: A utility class containing static methods to process words, including removing duplicates, sorting, and finding the most frequent word.
  
- **`FileHandlerFactory`**: A factory class used to instantiate appropriate file handlers based on file type.

This modular and extensible design allows for future support of additional file types by extending the `FileHandler` interface and adding new file handler classes.

---


## Running the Project

1. **Open Command Prompt or PowerShell** and navigate to the project directory:
    ```bash
    cd C:\path\to\your\project
    ```

2. **Build the Project** using Gradle:
    ```bash
    gradle build
    ```

3. **Run the Program** with the input file (`F1.txt`):
    ```bash
    java Main "C:\path\to\F1.txt"
    ```

4. **Choose Sorting Option**:
    - For ascending: `sort -a`
    - For descending: `sort -d`

The output file `F2.txt` will be automatically created in the same directory.
