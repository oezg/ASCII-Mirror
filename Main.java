package asciimirror;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AsciiMirror asciiMirror = new AsciiMirror(scanner);
        asciiMirror.run();
        scanner.close();
    }
}