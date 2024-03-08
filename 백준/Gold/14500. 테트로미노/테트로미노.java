import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] grid;
    static int[][][] arr = new int[][][]{
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {-1, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {1, -1}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
            {{0, 0}, {1, 0}, {1, -1}, {2, -1}},
            {{0, 0}, {0, -1}, {1, -1}, {1, -2}},
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
            {{0, 0}, {1, 0}, {0, 1}, {0, 2}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
            {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
            {{0, 0}, {0, 1}, {1, 0}, {2, 0}},
            {{0, 0}, {1, 0}, {1, 1}, {1, 2}},
            {{1, 0}, {1, 1}, {1, 2}, {0, 2}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int h = 0; h < 19; h++) {
                    int sum = 0;
                    boolean isBlock = true;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + arr[h][dir][0];
                        int ny = j + arr[h][dir][1];
                        if (!canGo(nx, ny)) {
                            isBlock = false;
                            break;
                        }

                        sum += grid[nx][ny];
                    }

                    if (!isBlock) continue;

                    ans = Math.max(ans, sum);
                }
            }
        }

        System.out.println(ans);
    }

    private static boolean canGo(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
}
