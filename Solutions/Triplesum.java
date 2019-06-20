import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        long rtn = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int indexA = 0, indexB = 0, indexC = 0;
        long countA = 0, countC = 0;
        while (indexB < b.length) {
            if (indexB > 0 && b[indexB] == b[indexB - 1]) {
                indexB++;
                continue;
            }
            while (indexA < a.length && a[indexA] <= b[indexB]) {
                if (indexA > 0 && a[indexA] == a[indexA - 1]) {
                    indexA++;
                    continue;
                }
                countA++;
                indexA++;
            }
            while (indexC < c.length && c[indexC] <= b[indexB]) {
                if (indexC > 0 && c[indexC] == c[indexC - 1]) {
                    indexC++;
                    continue;
                }
                countC++;
                indexC++;
            }
            rtn += countA * countC;
            indexB++;
        }
        return rtn;
    }

//    private static final Scanner scanner = new Scanner(System.in);
    private static final File file = new File("data.txt");

    public static void main(String[] args) throws IOException {
        
        Scanner scanner = new Scanner(file);
        
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);
        System.out.println(ans);

//        bufferedWriter.write(String.valueOf(ans));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
