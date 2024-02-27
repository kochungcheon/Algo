import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int minAns = Integer.MAX_VALUE;
    static int maxAns = -1;
    public static int solve(String n, int ans) {
        int cnt = 0;
        for (char c : n.toCharArray()) {
            if ((c - '0') % 2 == 1) {
                cnt++;
            }
        }
        ans += cnt;

        if (n.length() >= 3) {
            for (int i = 1; i < n.length() - 1; i++) {
                for (int j = i + 1; j < n.length(); j++) {
                    int a = Integer.parseInt(n.substring(0, i));
                    int b = Integer.parseInt(n.substring(i, j));
                    int c = Integer.parseInt(n.substring(j));
                    int newAns = solve(String.valueOf(a + b + c), ans);
                    minAns = Math.min(minAns, newAns);
                    maxAns = Math.max(maxAns, newAns);
                }
            }
        } else if (n.length() == 2) {
            int a = Integer.parseInt(n.substring(0, 1));
            int b = Integer.parseInt(n.substring(1));
            int newAns = solve(String.valueOf(a + b), ans);
            minAns = Math.min(minAns, newAns);
            maxAns = Math.max(maxAns, newAns);
        }

        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        solve(a, 0);
        minAns++;
        System.out.println(minAns + " " + maxAns);
    }
}