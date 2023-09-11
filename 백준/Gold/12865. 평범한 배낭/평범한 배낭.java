import java.util.*;
public class Main {
    static class Pair{
        int w, v;
        public Pair(int w, int v){
            this.w = w;
            this.v =v;
        }
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Pair[] arr = new Pair[n];
        for (int i=0; i<n; i++){
            int w = sc.nextInt();
            int v = sc.nextInt();
            arr[i] = new Pair(w, v);
        }
        int[] dp = new int[m+1];
        Arrays.fill(dp, -10001);
        dp[0] = 0;
        int ans = 0;
        for (int i=0; i<n; i++){
            for (int j=m; j>=0; j--){
                if (j >= arr[i].w){
                    if (dp[j-arr[i].w] == -10001) continue;
                    dp[j] = Math.max(dp[j], arr[i].v + dp[j-arr[i].w]);
                    ans = Math.max(ans, dp[j]);
                }
            }
        }
        System.out.print(ans);
    }
}