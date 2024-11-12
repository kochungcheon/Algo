import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean check(int target) {
        long tmp = 0;
        for (int tree : arr) {
            if (tree <= target) continue;
            tmp += tree - target;
        }
        return tmp >= M;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int s = 0;
        int e = 2_000_000_000;

        int ans = 0;
        while (e >= s) {
            int mid = (e - s) / 2 + s;
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
