import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the whatFlavors function below.
//    static void whatFlavors(int[] cost, int money) {
//        for (int i = 0; i < cost.length - 1; i++) {
//            for (int j = i + 1; j < cost.length; j++) {
//                if (cost[i] + cost[j] == money) {
//                    System.out.println((i + 1) + " " + (j + 1));
//                    return;
//                }
//            }
//        }
//    }
    static void whatFlavors(int[] cost, int money) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            if (map.containsKey(cost[i])) {
                List<Integer> temp = map.get(cost[i]);
                temp.set(0, temp.get(0) + 1);
                temp .add(i + 1);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(i + 1);
                map.put(cost[i], list);
            }
        }
        for (Integer key : map.keySet()) {
            List<Integer> keyList = map.get(key);
            keyList.set(0, keyList.get(0) - 1);
            if (map.containsKey(money - key)) {
                List<Integer> other = map.get(money - key);
                if (other.get(0) > 0) {
                    if (other == keyList) {
                        System.out.println(other.get(1) + " " + other.get(2));
                    } else {
                        if (keyList.get(1) < other.get(1)) System.out.println(keyList.get(1) + " " + other.get(1));
                        else System.out.println(other.get(1) + " " + keyList.get(1));
                    }
                    return;
                }
            }
            keyList.set(0, keyList.get(0) + 1);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
