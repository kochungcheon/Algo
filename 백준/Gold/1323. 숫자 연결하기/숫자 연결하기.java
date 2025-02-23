import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int K = Integer.parseInt(st.nextToken());

        // 연산 횟수
        int ans = 0;
        long left = Long.parseLong(N);

        Set<String> visit = new HashSet<>();
        while (true) {
            left %= K;
            ans++;
            if (left == 0) {
                break;
            }
            left = Long.parseLong(left + N);
            if (visit.contains(String.valueOf(left))) {
                ans = -1;
                break;
            }
            visit.add(String.valueOf(left));
        }
        System.out.print(ans);
    }
}
