package asciimirror;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AsciiMirror {

    private final Scanner scanner;
    private List<String> lines;
    private List<String> mirrorLines;
    public AsciiMirror(Scanner scanner) {
        this.scanner = scanner;
        this.lines = new ArrayList<>();
    }

    public void run() {
        System.out.println("Input the file path:");
        String filepath = scanner.nextLine();

        try {
            new FileHandler(filepath, this.lines);
            modifyLines();
            reverseLines();
            printMirror();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }

    private void reverseLines() {
        StringReverser stringReverser = new StringReverser();
        this.mirrorLines = stringReverser.reverseLines(this.lines);
    }

    private void modifyLines() {
        int maxLineLength = findMaxLineLength();
        for (int i = 0; i < this.lines.size(); i++) {
            lines.set(i, String.format("%-" + maxLineLength + "s", lines.get(i)));
        }
    }

    private int findMaxLineLength() {
        int max = 0;
        for (String line: this.lines) {
            max = Math.max(line.length(), max);
        }
        return max;
    }

    private void printMirror() {
        for (int i = 0; i < this.lines.size(); i++) {
            System.out.printf("%1$s | %2$s%n", this.lines.get(i), this.mirrorLines.get(i));
        }
    }
}
