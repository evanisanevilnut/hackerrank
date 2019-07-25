import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        int minNumCharsNeeded = 0;


        String lowerCaseLetters = new String("abcdefghijklmnopqrstuvwxyz");
        String upperCaseLetters = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        String numbers = new String("0123456789");
        String specialCharacters = new String("!@#$%^&*()-+");
        


        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char c: password.toCharArray()) {
            if (hasLower && hasUpper && hasNumber && hasSpecial) {
                break;
            }
            if (!hasLower) {
                if (lowerCaseLetters.contains(""+c)) {
                    hasLower = true;
                }
            }
            if (!hasUpper) {
                if (upperCaseLetters.contains(""+c)) {
                    hasUpper = true;
                }
            }
            if (!hasNumber) {
                if (numbers.contains(""+c)) {
                    hasNumber = true;
                }
            }
            if (!hasSpecial) {
                if (specialCharacters.contains(""+c)) {
                    hasSpecial = true;
                }
            }
        }

        if (!hasLower) {
            minNumCharsNeeded++;
        }
        if (!hasUpper) {
            minNumCharsNeeded++;
        }
        if (!hasNumber) {
            minNumCharsNeeded++;
        }
        if (!hasSpecial) {
            minNumCharsNeeded++;
        }

        int passwordLength = password.length();

        if (passwordLength + minNumCharsNeeded < 6) {
            minNumCharsNeeded = (6 - passwordLength);
        }


        return minNumCharsNeeded;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String inputPassword = scanner.next();
//        System.out.println();
        System.out.println(minimumNumber(n, inputPassword));
        scanner.close();
    }
}
