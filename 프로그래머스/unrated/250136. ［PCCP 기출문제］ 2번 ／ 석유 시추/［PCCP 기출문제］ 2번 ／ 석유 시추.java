import java.util.*;
class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0,0,1,-1};
    
    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    // color 는 2 이상
    static void BFS(Pair start, int[][] land, int color) {
        land[start.x][start.y] = color;
        Queue<Pair> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            Pair now = q.poll();
            for (int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (canGo(nx, ny, land.length, land[0].length)) {
                    if (land[nx][ny] == 1) {
                        land[nx][ny] = color;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }
    static boolean canGo(int x , int y , int mx, int my) {
        return 0 <= x && x < mx && 0 <= y && y < my;
    }
    public int solution(int[][] land) {
        int answer = 0;
        int color = 2;
        for (int i=0; i<land.length; i++) {
            for (int j=0; j<land[0].length; j++) {
                if (land[i][j] == 1) {
                    BFS(new Pair(i, j), land, color++);
                }
            }
        }
        int[] color_cnt = new int[color+1];
        for (int i=0; i<land.length; i++) {
            for (int j=0; j<land[0].length; j++) {
                if (land[i][j] >= 2) {
                    color_cnt[land[i][j]]++;
                }
            }
        }
        for (int i=0; i<land[0].length; i++) {
            boolean[] c = new boolean[color+1];
            int tmp = 0;
            for (int j=0; j<land.length; j++) {
                if (land[j][i] >= 2) {
                    c[land[j][i]] = true;
                }
            }
            for (int z=2; z<color; z++) {
                if (c[z]) {
                    tmp += color_cnt[z];
                }
            }
            answer = Math.max(tmp, answer);
        }
        return answer;
    }
}