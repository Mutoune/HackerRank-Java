import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Map;
import java.util.HashMap;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        int[] list = new int[26];
        for (int i = 0; i < s.length(); i++) {
            list[s.charAt(i) - 'a']++;
        }
        Arrays.sort(list);
        int i = 0;
        while (list[i] == 0 && i < 26) i++;
        int temp = list[i];
        int count = 26 - i;
        int step1 = 0;
        int step2 = 0;
        while (i < 26) {
            if (list[i] - temp != 0) {
                if (list[i] - temp == 1) {
                    step1++;
                } else if (temp - list[i] == 1) {
                    step2++;
                } else return "NO";
            }
            i++;
        }
        if ((step1 == 1 & step2 == 0) || (step1 == 0 && step2 == 0) || (step1 == 0 && step2 == 1)
                || (step1 == count - 1) || (step2 == count - 1)) {
            return "YES";
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);
        System.out.println(result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
