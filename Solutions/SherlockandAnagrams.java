import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static boolean check(String a, String b) {
        String[] lista = a.split("");
        String[] listb = b.split("");
        Arrays.sort(lista);
        Arrays.sort(listb);
        for (int i = 0; i < lista.length; i++) {
            if (!lista[i].equals(listb[i])) {
                return false;
            }
        }
        return true;
    }
    static int sherlockAndAnagrams(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.substring(i, i + 1).equals(s.substring(j, j + 1))) {
                    res++;
                    int k = 2;
                    while (j + k < s.length()) {
                        if (!check(s.substring(i, i + k),s.substring(j, j + k))) {
                            break;
                        }
                        res++;
                        k++;
                    }
                }
            }
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(String.valueOf(result));
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
