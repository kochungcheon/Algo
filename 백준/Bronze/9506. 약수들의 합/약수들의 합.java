import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int a = Integer.parseInt(br.readLine());
            if (a == -1) break;
            List<Integer> arr = new ArrayList<>();
            int sum = 0;
            for (int i=1; i<=Math.sqrt(a); i++) {
                if (a % i == 0) {
                    arr.add(i);
                    sum += i;
                    int tmp = a/i;
                    if (i != tmp && i > 1) {
                        arr.add(tmp);
                        sum += tmp;
                    }
                }
            }
            Collections.sort(arr);

            if (a != sum) {
                System.out.println(a + " is NOT perfect.");
            }
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(a + " = ");
                sb.append(arr.get(0));
                for (int i=1; i<arr.size(); i++) {
                    sb.append(" + " + arr.get(i));
                }
                System.out.println(sb);
            }

        }
    }
}