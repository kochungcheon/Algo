import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Cloud {
        int x;
        int y;

        public Cloud (int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(int nx, int ny) {
            nx = circle(nx);
            ny = circle(ny);

            this.x = (this.x + nx) % N;
            this.y = (this.y + ny) % N;
        }

        private Integer circle(int x) {
            while (x < 0) {
                x += N;
            }
            return x;
        }
    }


    static int[][] grid;

    static List<Cloud> clouds = new ArrayList<>();
    // 팔방향 탐색
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    // 대각선 탐색
    static int[] ox = {1, 1, -1, -1};
    static int[] oy = {1, -1, 1, -1};

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최초 구름
        clouds.add(new Cloud(N-1, 0));
        clouds.add(new Cloud(N-1, 1));
        clouds.add(new Cloud(N-2, 0));
        clouds.add(new Cloud(N-2, 1));

        // 주의 1,1 부터 시작임 0,0 아니니깐 -1 -1 해줘야한다
        for (int i=0; i<M; i++) {
            // 커맨드 입력
            int[] com = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int di = com[0] - 1;
            int si = com[1];

            // 1. 모든 구름이 di 방향으로 si칸 이동한다
            int nx = dx[di] * si;
            int ny = dy[di] * si;

            for (Cloud cloud : clouds) {
                cloud.move(nx, ny);
                // 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가
                grid[cloud.x][cloud.y]++;
            }




            // 3. 구름이 모두 사라진다
            // 아래로 대체 될거임
            List<Cloud> newClouds = new ArrayList<>();

            // 4. 2.에서 물이 증가한 칸에 물 복사 버그 마법을 시전 (대각선 방향으로 거리가 1인 칸에 물이 있는 바구니 수만큼 해당 칸의 물 양이 증가)
            // 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다
            for (Cloud cloud : clouds) {
                int cnt = 0;
                for (int j=0; j<4; j++) {
                    if (canGo(cloud.x + ox[j], cloud.y + oy[j])) {
                        if (grid[cloud.x + ox[j]][cloud.y + oy[j]] > 0) {
                            cnt++;
                        }
                    }
                }
                grid[cloud.x][cloud.y] += cnt;
            }

            // 5. 바구니에 저장된 물의 양이 2인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다 (단, 구름이 생기는 칸은 3. 에서 구름이 사라진 칸이 아니어야한다)
            for (int j=0; j<N; j++) {
                for (int h=0; h<N; h++) {
                    if (grid[j][h] >= 2) {
                        boolean flag = true;
                        for (Cloud cloud : clouds) {
                            if (cloud.x == j && cloud.y == h) {
                               flag = false;
                                break;
                            }
                        }

                        if (flag) {
                            newClouds.add(new Cloud(j, h));
                            grid[j][h] -= 2;
                        }

                    }
                }
            }
            
            clouds = newClouds;
        }

        int ans = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                ans += grid[i][j];
            }
        }

        System.out.println(ans);


    }

    private static boolean canGo(int i, int i1) {
        return 0 <= i && i < N && 0 <= i1 && i1 <N;
    }
}
