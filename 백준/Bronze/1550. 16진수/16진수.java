import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().split("");

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 11);
        map.put("C", 12);
        map.put("D", 13);
        map.put("E", 14);
        map.put("F", 15);

        int ans = 0;
        int idx = 1;
        for (int i = a.length-1; i>=0; i--) {
            if (map.containsKey(a[i])) {
                ans += map.get(a[i]) * idx;
            } else {
                ans += Integer.parseInt(a[i]) * idx;
            }
            idx *= 16;
        }
        System.out.println(ans);

    }
}