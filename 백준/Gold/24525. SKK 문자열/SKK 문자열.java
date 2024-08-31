import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String SKK = br.readLine();
        int len = SKK.length();
        int[] arr = new int[len];
        int[] sCnt = new int[len + 1];
        int[] kCnt = new int[len + 1];

        for (int i = 0; i < len; i++) {
            char now = SKK.charAt(i);
            if (now == 'S') {
                arr[i] = -2;
                sCnt[i + 1] = sCnt[i] + 1;
                kCnt[i + 1] = kCnt[i];
            } else if (now == 'K') {
                arr[i] = 1;
                kCnt[i + 1] = kCnt[i] + 1;
                sCnt[i + 1] = sCnt[i];
            } else {
                sCnt[i + 1] = sCnt[i];
                kCnt[i + 1] = kCnt[i];
            }
        }

        int[] prefix = new int[len + 1];

        for (int i = 0; i < len; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        // val, index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int ans = -1;

        for (int i = 1; i <= len; i++) {
            int now = prefix[i];
            if (map.containsKey(now)) {
                int minIdx = map.get(now);
                int s_cnt = sCnt[i] - sCnt[minIdx];
                int k_cnt = kCnt[i] - kCnt[minIdx];

                if (s_cnt > 0 && s_cnt * 2 == k_cnt) {
                    ans = Math.max(ans, i - minIdx);
                }
            } else {
                map.put(now, i);
            }
        }
        System.out.print(ans);
    }
}
