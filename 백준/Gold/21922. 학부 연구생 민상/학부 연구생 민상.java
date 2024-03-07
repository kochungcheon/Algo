import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class AirCondition {
        int x;
        int y;
        public AirCondition(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] grid;
    // 동 서 남 북
    static boolean[][][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int N;
    static int M;

    static List<AirCondition> airConditions = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        grid = new int[N][M];
        visited = new boolean[N][M][4];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (isAirCondition(grid[i][j])) {
                    airConditions.add(new AirCondition(i, j));
                }
            }
        }

        for (AirCondition airCondition : airConditions) {
            for (int d=0; d<4; d++) {
                int directX = dx[d];
                int directY = dy[d];

                int dir = d;
                int nowX = airCondition.x + directX;
                int nowY = airCondition.y + directY;

                while (canGo(nowX, nowY, dir)) {
                    // 아 귀찮은 구현 해야함
                    // 재밌다 재밌다 최면 중

                    visited[nowX][nowY][dir] = true;
               
                    // grid 1 일 때 dir 0 이면 1, 1이면 0 , 나머진 가던 길 가라
                    if (grid[nowX][nowY] == 1) {
                        if (dir == 0) {
                            dir = 1;
                        } else if (dir == 1) {
                            dir = 0;
                        } else {

                        }
                    }

                    // grid 2 일 때 dir 2 이면 3, 3이면 2 , 나머진 가던 길 가라
                    else if (grid[nowX][nowY] == 2) {
                        if (dir == 2) {
                            dir = 3;
                        } else if (dir == 3) {
                            dir = 2;
                        } else {

                        }
                    }

                    // grid 3 일 때 dir 2 이면 1, 3 이면 0, 0 이면 3, 1이면 2
                    else if (grid[nowX][nowY] == 3) {
                        if (dir == 2) {
                            dir = 1;
                        } else if (dir == 3) {
                            dir = 0;
                        } else if (dir == 0) {
                            dir = 3;
                        } else if (dir == 1){
                            dir = 2;
                        }

                    }

                    // grid 4 일 때 dir 2 이면 0, 3 이면 1, 0 이면 2, 1 이면 3
                    else if (grid[nowX][nowY] == 4) {
                        if (dir == 2) {
                            dir = 0;
                        } else if (dir == 3) {
                            dir = 1;
                        } else if (dir == 0) {
                            dir = 2;
                        } else if (dir == 1){
                            dir = 3;
                        }
                    }

                    directX = dx[dir];
                    directY = dy[dir];

                    nowX += directX;
                    nowY += directY;
                }

            }
        }

        int ans = 0;

        for (AirCondition air : airConditions) {
            visited[air.x][air.y][0] = true;
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                for (int h = 0; h<4; h++) {
                    if (visited[i][j][h]) {
                        ans++;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);

    }

    private static boolean canGo(int directX, int directY, int dir) {
        return 0 <= directX && directX < N && 0 <= directY && directY < M && !visited[directX][directY][dir];
    }

    private static boolean isAirCondition(int i) {
        return i == 9;
    }
}