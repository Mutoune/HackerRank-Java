import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        List<Integer> list = Arrays.stream(q).boxed().collect(Collectors.toList());
        int step = 0;
        int target = q.length;
        while (target > 0) {
            int i = list.indexOf(target);
            int temp = 0;
            switch (target - i - 1) {
            case 0:
                break;
            case 1:
                temp = list.get(i + 1);
                list.set(i + 1, target);
                list.set(i, temp);
                step++;
                break;
            case 2:
                temp = list.get(i + 1);
                list.set(i + 1, list.get(i + 2));
                list.set(i, temp);
                list.set(i + 2, target);
                step += 2;
                break;
            default:
                System.out.println("Too chaotic");
                return;
            }
            target--;
        }
        System.out.println(step);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
