package asciimirror;

import java.util.List;
import java.util.stream.Collectors;

public class StringReverser {

    public StringReverser() {

    }

    public List<String> reverseLines(List<String> lines) {
        return lines.stream()
                .map(this::reverseString)
                .collect(Collectors.toList());
    }

    private String reverseString(String line) {
        StringBuilder stringBuilder = new StringBuilder(line);
        stringBuilder.reverse();
        return stringBuilder.chars()
                .mapToObj(this::reverseBrackets)
                .collect(Collectors.joining());
    }

    private String reverseBrackets(int number) {
        char character = (char) number;
        String letter = String.valueOf(character);
        switch (character) {
            case '(':
                letter = ")";
                break;
            case ')':
                letter = "(";
                break;case '<':
                letter = ">";
                break;
            case '>':
                letter = "<";
                break;
            case '[':
                letter = "]";
                break;
            case ']':
                letter = "[";
                break;
            case '{':
                letter = "}";
                break;
            case '}':
                letter = "{";
                break;
            case '/':
                letter = "\\";
                break;
            case '\\':
                letter = "/";
                break;
            default:
                break;
        }
        return letter;
    }
}
