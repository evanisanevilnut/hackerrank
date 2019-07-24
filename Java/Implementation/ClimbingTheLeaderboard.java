import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        int[] inputIntArray = new int[a.size()];
        for (int i = 0; i < inputIntArray.length; i++) {
            inputIntArray[i] = a.get(i);
        }


        int resultLargestListSize = 0;
        Set<Integer> uniqueIntsChecked = new HashSet<>();

//        List<Integer> currentBiggestList = new ArrayList<>();

        for (int currentElement : a ) {
            if (!uniqueIntsChecked.contains(currentElement)) {
                int countOfCurrentElement = 0;
                int countOfElementsOneGreater = 0;
                int countOfElementsOfLesser = 0;

                for (int crossCheckingElement: inputIntArray) {
                    if (currentElement == crossCheckingElement) {
                        countOfCurrentElement++;
                    } else if (crossCheckingElement - currentElement == 1) {
                        countOfElementsOneGreater++;
                    } else if (currentElement - crossCheckingElement == 1) {
                        countOfElementsOfLesser++;
                    }
                }

                int listSizeOfElementAndOneGreater = (countOfCurrentElement + countOfElementsOneGreater);
                int listSizeOfElementAndOneLesser = (countOfCurrentElement + countOfElementsOfLesser);

                int biggestListSizeOfCurrentElement = 0;
                if (listSizeOfElementAndOneGreater >= listSizeOfElementAndOneLesser) {
                    biggestListSizeOfCurrentElement = listSizeOfElementAndOneGreater;
                } else {
                    biggestListSizeOfCurrentElement = listSizeOfElementAndOneLesser;
                }

                if (biggestListSizeOfCurrentElement > resultLargestListSize) {
                    resultLargestListSize = biggestListSizeOfCurrentElement;
                }
            }
        }
        return resultLargestListSize;
    }


    public static void main(String[] args) throws IOException {

        Scanner reader = new Scanner(new InputStreamReader(System.in));

        String sizeOfInputListAsStringArray = reader.nextLine();
        int sizeOfInputArray = Integer.parseInt(sizeOfInputListAsStringArray);
        String[] InputArray = reader.nextLine().split(" ");
        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < sizeOfInputArray; i++ ) {
            int tempInt = Integer.parseInt(InputArray[i]);
            inputList.add(tempInt);
        }

        int result = pickingNumbers(inputList);

        System.out.println(result);
    }
}
