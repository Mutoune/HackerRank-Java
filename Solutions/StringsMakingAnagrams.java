import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        Map<String, Long> mapa= Arrays.stream(a.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long rest = b.length();
        for (int i = 0; i < b.length(); i++) {
            if (mapa.containsKey(b.substring(i, i + 1)) && mapa.get(b.substring(i, i + 1)) > 0) {
                mapa.replace(b.substring(i, i + 1), mapa.get(b.substring(i, i + 1)) - 1);
                rest--;
            }
        }
        for (Long temp : mapa.values()) {
            rest += temp;
        }
        return (int)rest;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);
        System.out.println(res);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}
