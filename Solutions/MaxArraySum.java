import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int[] res = new int[arr.length];
        int max = arr[0];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res[i] = arr[i];
            for (int j = 0; j < i - 1; j++) {
                res[i] = Math.max(res[i], res[j] + arr[i]);
            }
            max = Math.max(max, res[i]);
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);
        System.out.println(res);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}
