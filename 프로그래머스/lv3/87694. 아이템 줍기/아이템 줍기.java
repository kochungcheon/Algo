import java.util.*;

class Solution {
    static int xx = 0;
    static int yy = 0;

    static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] == 1;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < 101 && 0 <= y && y < 101;
    }

    static int[][] visit = new int[101][101];
    static int[][] grid = new int[101][101];

    static class Pair {
        int x, y, step;

        public Pair(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    static Queue<Pair> q = new LinkedList<>();

    static void push(int x, int y, int step) {
        visit[x][y] = step;
        q.add(new Pair(x, y, step));
    }

    static void BFS() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            Pair now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (canGo(nx, ny) && (visit[nx][ny] == 0 || visit[nx][ny] > now.step + 1)) {
                    push(nx, ny, now.step + 1);
                }
            }
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        xx = itemX * 2;
        yy = itemY * 2;

        for (int[] box : rectangle) {
            int x1 = box[0] * 2;
            int y1 = box[1] * 2;
            int x2 = box[2] * 2;
            int y2 = box[3] * 2;
            for (int i = x1; i <= x2; i++) {
                grid[i][y1] = 1;
                grid[i][y2] = 1;
            }
            for (int j = y1; j <= y2; j++) {
                grid[x1][j] = 1;
                grid[x2][j] = 1;
            }
        }

        for (int[] box : rectangle) {
            int x1 = box[0] * 2;
            int y1 = box[1] * 2;
            int x2 = box[2] * 2;
            int y2 = box[3] * 2;
            for (int i = x1 + 1; i < x2; i++) {
                for (int j = y1 + 1; j < y2; j++) {
                    grid[i][j] = 0;
                }
            }
        }

        // 시작 위치 넣기
        push(characterX * 2, characterY * 2, 1);
        BFS();

        // 최종 위치
        int answer = visit[xx][yy];
        return answer / 2;
    }
}
