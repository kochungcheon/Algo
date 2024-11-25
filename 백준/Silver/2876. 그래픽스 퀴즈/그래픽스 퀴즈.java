

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][2];
        for (int i = 0; i < N; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int minNumber = Integer.MAX_VALUE;
        int maxCount = -1;

        for (int number = 1; number <= 5; number++) {
            int maxTmp = 0;
            int tmp = 0;
            for (int i=0; i<N; i++) {
                if (grid[i][0] == number || grid[i][1] == number) {
                    tmp += 1;
                } else {
                    maxTmp = Math.max(maxTmp, tmp);
                    tmp = 0;
                }
            }
            maxTmp = Math.max(maxTmp, tmp);
            if (maxTmp > maxCount) {
                maxCount = maxTmp;
                minNumber = number;
            }
        }

        System.out.print(maxCount + " " + minNumber);
    }
}
