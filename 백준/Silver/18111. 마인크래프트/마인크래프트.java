import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
// 양의 정수 n에 대하여 d(n) 을 N과 N의 각 자리수를 더라는 ㅎ ㅏㅁ수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 인벤에 있는 블록의 수
        int B = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][M];
        for (int i=0; i<N; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int ansPerpose = -1;
        int ansTime = Integer.MAX_VALUE;

        // 하나씩 확인
        for (int perpose = 0; perpose <= 256; perpose++) {
            int tmpTime = 0;
            int tmpB = 0;
            int need = 0;

            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    // 목표보다 크면 깍는 다
                    if (grid[i][j] > perpose) {
                        tmpB += grid[i][j] - perpose;
                        tmpTime += 2 * (grid[i][j] - perpose);
                    }
                    else if (grid[i][j] < perpose) {
                        tmpTime += perpose - grid[i][j];
                        need += perpose - grid[i][j];
                    }
                }
            }

            if (need <= tmpB + B) {
                if (ansTime >= tmpTime) {
                    ansTime = tmpTime;
                    ansPerpose = perpose;
                }
            }
        }
        System.out.println(ansTime + " " + ansPerpose);
    }
}