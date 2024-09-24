import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int M;
    static int[] arr;
    static boolean check(int x) {
        long sum = 0;
        for (int a : arr) {
            if (a > x) {
                sum += a - x;
                if (sum >= M) return true;
            }
        }
        return sum >= M;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int s = 0;
        int e = 1_000_000_000;
        int ans = 0;

        while (e >= s) {
            int mid = s + (e - s)/ 2;
            if (check(mid)) {
                ans = Math.max(ans, mid);
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.print(ans);

    }
}
