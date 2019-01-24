package YandexOlymp;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the aVeryBigSum function below.
     */
    static long aVeryBigSum(int n, long[] ar) {
        /*
         * Write your code here.
         */
        long[] result = new long[Long.SIZE];

        for (int i = 0; i < n; i++) {
            long number = ar[i];
            int numLength = 0;
            while (number > 0) {
                int index = result.length - numLength - 1;
                result[index] += number % 10;
                if (result[index] > 9) {
                    result[index - 1] = result[index] / 10;
                    result[index] = result[index] % 10;
                }
                number = number / 10;
                numLength++;
            }
        }
        long resultLong = 0;
        for (int i = 0; i < result.length; i++) {
            resultLong = resultLong + result[result.length - 1 - i] * ((long) Math.pow(10, i));
        }
        return resultLong;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        int n = Integer.parseInt(scan.nextLine().trim());
        int n = Integer.parseInt(reader.readLine());

        long[] ar = new long[n];

//        String[] arItems = scan.nextLine().split(" ");
        String[] arItems = reader.readLine().split(" ");
        for (int arItr = 0; arItr < n; arItr++) {
            long arItem = Long.parseLong(arItems[arItr].trim());
            System.out.println(arItem);
            ar[arItr] = arItem;
        }


        long result = aVeryBigSum(n, ar);

        System.out.println(result);
//        bw.write(String.valueOf(result));
//        bw.newLine();
//
//        bw.close();
    }
}
