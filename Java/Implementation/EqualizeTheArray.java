import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        Map<Integer, Integer> inputIntsAndCounts = new HashMap<>();

        for (int inputInt: arr) {
            if (!inputIntsAndCounts.containsKey(inputInt)) {
                inputIntsAndCounts.put(inputInt, 1);
            } else {
                int tempCount = inputIntsAndCounts.get(inputInt);
                tempCount++;
                inputIntsAndCounts.put(inputInt, tempCount);
            }
        }

        int maxCount = 0;

        for (int count : inputIntsAndCounts.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return (arr.length - maxCount);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String inputString = scanner.next();
        char[] inputStringAsCharArray = inputString.toCharArray();
        int[] inputInts = new int[inputStringAsCharArray.length];
        for(int i = 0; i < inputStringAsCharArray.length; i++) {
            inputInts[i] = inputStringAsCharArray[i];
        }
        System.out.println(equalizeArray(inputInts));
        scanner.close();
    }
}
