import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] balance = new long[N];
        long total = 0;
        for (int i = 0; i < N; i++) {
            balance[i] = Long.parseLong(st.nextToken());
            total += balance[i];
        }

        long J = Long.parseLong(br.readLine().trim());
        long C = Long.parseLong(br.readLine().trim());

        double start = balance[0];
        double result = start + (start / (double) total) * C * J;

        System.out.printf("%.15f%n", result);
    }
}
