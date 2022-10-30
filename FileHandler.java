package asciimirror;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    private final Scanner scanner;

    public FileHandler(String filepath, List<String> lines) throws IOException {
        File file = new File(filepath);
        this.scanner = new Scanner(file);
        readLines(lines);
        readAllText(filepath);
        this.scanner.close();
    }

    public void readLines(List<String> lines) {
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
    }

    public void readAllText(String filepath) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(filepath)));
    }
}
