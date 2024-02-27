import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int minAns = Integer.MAX_VALUE;
    static int maxAns = -1;
    public static int find_cnt(int n) {
        int tmp = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                tmp++;
            }
            n /= 10;
        }
        return tmp;
    }
    public static void solve(int n, int ans) {
        if (n < 10) {
            minAns = Math.min(ans, minAns);
            maxAns = Math.max(ans, maxAns);
        }

        else if (n < 100) {
            int tmp = n / 10 + n % 10;
            solve(tmp, find_cnt(tmp) + ans);
        }

        else {
            String s = String.valueOf(n);
            for (int i=0; i< s.length()-2; i++) {
                for (int j=i+1; j<s.length()-1; j++) {
                    String a = s.substring(0, i+1);
                    String b = s.substring(i+1, j+1);
                    String c = s.substring(j+1);
                    int now = Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c);
                    solve(now, ans + find_cnt(now));
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        solve(a, find_cnt(a));
        System.out.println(minAns + " " + maxAns);
    }
}