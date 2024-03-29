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
        res[0] = Math.max(0, arr[0]);
        res[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            res[i] = Math.max(res[i - 1], res[i - 2] + arr[i]);
            res[i] = Math.max(res[i], arr[i]);
        }
        return res[arr.length - 1];
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
