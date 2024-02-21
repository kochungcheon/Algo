import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[10];
        dp[1] = 2;
        for (int i=2; i<10; i++) {
            dp[i] = dp[i-1] * 2;
        }
        System.out.println(dp[N]);
    }
}
