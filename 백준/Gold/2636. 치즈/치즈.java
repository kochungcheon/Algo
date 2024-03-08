import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] grid;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;

    static boolean canGo(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static int BFS(int x, int y) {
        // 1을 만나면 줄이고 가지 않는
        visited[x][y] = true;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x, y));
        int cheese = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                if (!canGo(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (grid[nx][ny] > 0) {
                    grid[nx][ny] = 0;
                    cheese++;
                } else {
                    queue.add(new Node(nx, ny));
                }
                visited[nx][ny] = true;
            }
        }
        return cheese;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        visited = new boolean[N][M];
        int total = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] > 0) {
                    total++;
                }
            }
        }


        int time = 0;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] > 0) continue;
                visited = new boolean[N][M];
                time++;
                int minus = BFS(i, j);
                if (total - minus > 0) {
                    total -= minus;
                } else {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        System.out.println(time);
        System.out.println(total);

    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}