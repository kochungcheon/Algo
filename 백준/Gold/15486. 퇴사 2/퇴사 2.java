import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static Info[] arr;
    static int[] dp;

    // 현재 cur 번째 날일 때 앞으로 최대 얼마를 벌 수 있는 지 리턴
    static int recur(int cur) {
        if (cur > N) {
            return Integer.MIN_VALUE;
        }

        if (cur == N) {
            return 0;
        }

        if (dp[cur] != -987654321) {
            return dp[cur];
        }
        dp[cur] = Math.max(recur(cur + 1), arr[cur].cost + recur(cur + arr[cur].days));
        return dp[cur];

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Info[N];
        dp = new int[N+51];
        Arrays.fill(dp, -987654321);
        dp[N] = 0;
        for (int i=0; i<N; i++) {
            int[] com = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[i] = new Info(com[0], com[1]);
        }
        for (int i = N - 1 ; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + arr[i].days] + arr[i].cost);
        }
        System.out.println(recur(0));
    }
    static class Info{
        int days, cost;

        public Info(int days, int cost) {
            this.days = days;
            this.cost = cost;
        }
    }
}