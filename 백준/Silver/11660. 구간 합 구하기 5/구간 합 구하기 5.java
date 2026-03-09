

import java.io.*;
import java.util.*;

// 구간 합 구하기 5 (백준 11660)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        int[][] prefix = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            prefix[0][i + 1] = prefix[0][i] + grid[0][i];
            prefix[i + 1][0] = prefix[i][0] + grid[i][0];
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prefix[i][j] =
                    grid[i - 1][j - 1] +
                    prefix[i - 1][j] +
                    prefix[i][j - 1] -
                    prefix[i - 1][j - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int tmp =
                prefix[x2][y2] -
                prefix[x2][y1 - 1] -
                prefix[x1 - 1][y2] +
                prefix[x1 - 1][y1 - 1];
            System.out.println(tmp);
        }
    }
}
