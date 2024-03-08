import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void BFS(int x, int y) {
        visited[x][y] = true;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x, y));
        while(!queue.isEmpty()) {
            Node now = queue.poll();

            for (int dir=0; dir<4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                if (!canGo(nx, ny)) continue;
                if (isNotIceBerg(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(new Node(nx, ny));
            }

        }
    }

    private static boolean canGo(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;

        while (true) {
            // 방문 배열은 매번 초기화한다
            visited = new boolean[N][M];
            // 우선 두개로 쪼개지는 지 확인 한다
            int cnt = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    // 방문 한건 패스
                    if (visited[i][j]) continue;
                    // 빙하 아니면 넘어가~
                    if (isNotIceBerg(i, j)) continue;

                    cnt++;
                    BFS(i, j);
                }
            }

            if (isTwo(cnt)) {
                System.out.println(year);
                break;
            }

            year++;

            // 빙하 줄이자
            // 복사 복사
            int[][] copy = new int[N][M];
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    copy[i][j] = grid[i][j];
                }
            }

            // 줄이자
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    // copy 를 통해서 빙산인지 체크
                    if (copy[i][j] <= 0) continue;

                    // 빙산 주위로 물이 몇 개인지 체크
                    int waterCnt = 0;
                    for (int h=0; h<4; h++) {
                        int nx = i + dx[h];
                        int ny = j + dy[h];
                        if (!canGo(nx, ny)) continue;
                        if (copy[nx][ny] > 0) continue;
                        waterCnt++;
                    }

                    grid[i][j] -= waterCnt;
                }
            }

            // 만일 빙산이 다 녹을 때까지 분리되지 않으면 0을 출력한다.
            int iceCnt = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (grid[i][j] > 0) {
                        iceCnt++;
                    }
                }
            }
            if (iceCnt == 0) {
                System.out.println(0);
                break;
            }

        }
    }

    private static boolean isTwo(int cnt) {
        return cnt >= 2;
    }

    private static boolean isNotIceBerg(int i, int j) {
        return grid[i][j] <= 0;
    }
}