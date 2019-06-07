import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static void swap(int[] array,int left, int right){
        int temp = array[right];
        array[right] = array[left];
        array[left] = temp;
    }
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int i = 0;
        while (i < arr.length) {
            int target = i + 1;
            if (target - arr[i] != 0) {
                int j = i + 1;
                while (j < arr.length && arr[j] != target) j++;
                if (arr[j] == target) {
                    swap(arr, i, j);
                    swaps++;
                }
            }
            i++;
        }
        return swaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
