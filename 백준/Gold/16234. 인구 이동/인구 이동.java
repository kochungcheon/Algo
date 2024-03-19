import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[][] grid;
    static int[][] visit;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static Queue<Node> q = new ArrayDeque<>();

    static void BFS(int x, int y, int start) {
        visit[x][y] = start;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(x, y));
        int cnt = 1;
        int total = grid[x][y];
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = dx[dir] + now.x;
                int ny = dy[dir] + now.y;
                if (!canGo(nx, ny, now.x, now.y)) continue;
                cnt++;
                total += grid[nx][ny];
                visit[nx][ny] = start;
                queue.add(new Pair(nx, ny));
            }
        }
        q.add(new Node(start, cnt, total));
    }

    private static boolean canGo(int nx, int ny, int x, int y) {
        if (0 <= nx && nx < N && 0 <= ny && ny < N && visit[nx][ny] == 0) {
            return calCompare(nx, ny, x, y);
        }
        return false;
    }

    private static boolean calCompare(int nx, int ny, int x, int y) {
        int compare = grid[nx][ny];
        int tmp = Math.abs(grid[x][y] - compare);
        return L <= tmp && tmp <= R;
    }

    public static void main(String[] args) throws IOException {
        input();

        int ans = 0;
        for (int day = 1; day <= 2000; day++) {
            // 대충 방문 배열 int 되있는 거 선언
            visit = new int[N][N];

            // BFS 로 대충 확인 방문 배열에 슉슉
            int start = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j] > 0) continue;
                    // 오른 쪽/ 아래쪽 갈 수 있는 지 조건에 맞는 지 체크하고 || BFS
                    if (canRight(i, j) || canDown(i, j)) {
                        BFS(i, j, start);
                        start++;
                    }
                }
            }

            // 플래그면 바바이 ans = day
            if (start <= 1) {
                ans = day - 1;
                break;
            }

            // grid 최신화
            while (!q.isEmpty()) {
                Node now = q.poll();
                int avg = now.total / now.cnt;
                for (int i=0; i<N; i++) {
                    for (int j=0; j<N; j++) {
                        if (visit[i][j] == now.idx) {
                            grid[i][j] = avg;
                        }
                    }
                }
            }
        }
        System.out.println(ans);

    }

    private static boolean canDown(int i, int j) {
        if (0 <= i + 1 && i + 1 < N) {
            return calCompare(i + 1, j, i, j);
        }
        return false;
    }

    private static boolean canRight(int i, int j) {
        if (0 <= j + 1 && j + 1 < N) {
            return calCompare(i, j + 1, i, j);
        }
        return false;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }

    static class Node {
        int idx;
        int cnt;
        int total;

        public Node(int idx, int cnt, int total) {
            this.idx = idx;
            this.cnt = cnt;
            this.total = total;
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}