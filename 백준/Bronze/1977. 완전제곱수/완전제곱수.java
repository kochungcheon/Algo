import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int max = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = N; i<=M; i++) {
            int num = (int) Math.sqrt(i);
            if (i == num * num) {
                max = Math.min(max, i);
                sum += i;
            }
        }
        if (sum > 0) {
            System.out.println(sum);
            System.out.println(max);
        } else {
            System.out.println(-1);
        }

    }
}