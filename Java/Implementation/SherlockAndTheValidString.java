import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        String result = "Error";

        char[] inputStringAsCharArray = s.toCharArray();

        Map<Character, Integer> charsSoFar = new HashMap<Character, Integer>();

        for (char inputChar : inputStringAsCharArray) {
            if (charsSoFar.containsKey(inputChar)) {
                int inputCharCount = charsSoFar.get(inputChar);
                inputCharCount++;

                charsSoFar.put(inputChar, inputCharCount);
            } else {
                charsSoFar.put(inputChar, 1);
            }
        }

        int firstValidCharCount = 0;
        boolean hasMultipleFirst = false;
        boolean hasOneFirst = false;
        int secondValidCharCount = 0;
        boolean hasOneSecond = false;
        boolean hasMultipleSecond = false;


        for (Integer value : charsSoFar.values()) {
            if (firstValidCharCount == 0) {
                firstValidCharCount = value;
                hasOneFirst = true;
            } else if (firstValidCharCount == value) {
                hasMultipleFirst = true;
                hasMultipleFirst = false;
            } else if (secondValidCharCount == 0) {
                secondValidCharCount = value;
                hasOneSecond = true;
            } else if (secondValidCharCount == value) {
                hasMultipleSecond = true;
                hasOneSecond = false;
            } else {
                // This else represents a third count, where it's no possible
                return "NO";
            }

            if (hasMultipleFirst && hasMultipleSecond) {
                return "NO";
            } else if (hasMultipleFirst && hasOneSecond) {
                if (secondValidCharCount - 1 != firstValidCharCount) {
                    return "NO";
                }
            } else if (hasMultipleSecond && hasOneFirst) {
                if (firstValidCharCount - 1 != secondValidCharCount ) {
                    return "NO";
                }
            }
        }

        return "YES";
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String inputString = scanner.next();
        System.out.println(isValid(inputString));
        scanner.close();
    }
}
