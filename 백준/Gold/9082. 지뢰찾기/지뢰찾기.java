

import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = new int[] { -1, 0, 1 };

    static boolean canGo(int y, int len) {
        return 0 <= y && y < len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        // game cnt
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int m = Integer.parseInt(br.readLine());
            int[] cnt = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
            char[] arr = br.readLine().toCharArray();
            int len = arr.length;

            // 지뢰 수
            int ans = 0;
            for (int i = 0; i < len; i++) {
                // -1 0 1 전부 -1
                if (arr[i] == '*') {
                    ans++;
                    for (int di = 0; di < 3; di++) {
                        int ny = i + dy[di];
                        if (canGo(ny, len)) {
                            cnt[ny]--;
                        }
                    }
                }
            }

            // 시작점에 지뢰가 없고 시작점이 1 이상일때
            if (arr[0] != '*' && cnt[0] >= 1) {
                ans++;
                cnt[0]--;
                if (canGo(1, len)) {
                    cnt[1]--;
                }
            }
            for (int i = 1; i < len; i++) {
                // 이전 것이 1이상이면 설치해야한다
                if (cnt[i - 1] >= 1) {
                    ans++;
                    for (int di = 0; di < 3; di++) {
                        int ny = i + dy[di];
                        if (canGo(ny, len)) {
                            cnt[ny]--;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
