import java.util.*;
import java.lang.*;
class Solution {
    static class Pair {
        int x;
        int y;
        int step;
        public Pair(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    static boolean canGo(int x, int y) {
        return 0 <= x && x < 5 && 0 <= y && y < 5;
    }
    static Integer BFS(int x, int y, String[] places) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visit = new boolean[5][5];
        visit[x][y] = true;
        q.add(new Pair(x, y, 0));
        while (!q.isEmpty()) {
            Pair now = q.poll();
            for (int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nstep = now.step + 1;
                if (nstep >= 3) {
                    continue;
                }
                if (canGo(nx, ny)) {
                    if (visit[nx][ny]) continue;
                    visit[nx][ny] = true;
                    // 파티션 만났을 때 종료
                    if (places[nx].charAt(ny)=='X') {
                        continue;
                    }

                    // 빈 테이블 만났을 때
                    if (places[nx].charAt(ny)=='O') {
                        q.add(new Pair(nx, ny, nstep));
                        
                    } 
                    // 다른 응시자 만났을 때
                    else {
                        if (now.step <= 2) { 
                            return 0;
                        }
                    }
                }
            }
        }
        return 1;
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        for (int i=0; i<5; i++) {
            int cnt = 1;
            for (int j=0; j<5 ; j++) {
                if (cnt == 0) break;
                for (int h=0; h<5; h++) {
                    if (cnt == 0) break;
                    if (places[i][j].charAt(h) == 'P') {
                        cnt = BFS(j, h, places[i]);
                    }
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}