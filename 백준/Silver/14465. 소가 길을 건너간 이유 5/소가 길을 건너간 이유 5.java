import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean[] isBroken = new boolean[N + 1];
        for (int i=0; i<B; i++) {
            isBroken[Integer.parseInt(br.readLine())] = true;
        }

        int cnt = 0;
        int ans = Integer.MAX_VALUE;

        // 초기 값 세팅
        for (int i=0; i<=K; i++) {
            cnt += isBroken[i] ? 1 : 0;
        }
        ans = Math.min(ans, cnt);

        for (int i=K+1; i<=N; i++) {
            cnt += isBroken[i] ? 1 : 0;
            cnt -= isBroken[i-K] ? 1 : 0;
            ans = Math.min(ans, cnt);
        }

        // 결과 출력
        System.out.print(ans);
    }
}
