

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int MOD = 1_000_000_007;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        long w = 0;
        long h = 0;
        long e = 0;

        long ans = 0;
        for (char c : S.toCharArray()) {
            if (c == 'W') {
                w++;
            } else if (c == 'H') {
                h = (w + h) % MOD;
            } else if (c == 'E') {
                ans = ((2 * ans) % MOD + e) % MOD;
                e = (e + h) % MOD;
            }
        }
        System.out.print(ans);
    }
}
