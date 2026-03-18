import java.util.*;

class Solution {
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static boolean[][] visit;
    static class Pair {
        int x;
        int y;
        int dist;
        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static boolean canGo(int x, int y) {
        return 0 <= x && x < 5 && 0 <= y && y < 5;
    }
    static boolean BFS(int x, int y, String[] room) {         
        visit[x][y] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y, 0));
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int di=0; di<4; di++) {
                int nx = now.x + dx[di];
                int ny = now.y + dy[di];
                int nd = now.dist + 1;
                if (nd > 2) continue;
                if (!canGo(nx, ny)) continue;
                if (visit[nx][ny]) continue;
                if (room[nx].charAt(ny) == 'X') continue;
                if (room[nx].charAt(ny) == 'P') return false;
                 
                visit[nx][ny] = true;
                queue.add(new Pair(nx, ny, nd));
                
            }    
        }
        return true;
        
    }
    static int n, m;
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i =0; i<5; i++) {
            boolean safe = true;
            visit = new boolean[5][5];
            for (int r = 0; r< 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (places[i][r].charAt(c) == 'P') {
                        if (BFS(r, c, places[i])) continue;
                        safe = false;
                    }
                }
            }
            answer[i] = safe ? 1 : 0;
        }
        return answer;
    }
}
