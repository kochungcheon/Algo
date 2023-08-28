import java.util.*;
class Solution {
    static class Pair{
        int x, y, step;
        public Pair(int x, int y, int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    static int grid_y;
    static int grid_x;
    static int ans = -1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Pair> q = new LinkedList<>();
    static int[][] visit;
    static void push(int x, int y, int step){
        visit[x][y] = step;
        q.add(new Pair(x, y, step));
    }
    static void BFS(int[][] maps){
        push(0, 0, 1);
        while (!q.isEmpty()){
            Pair cur = q.poll();
            for (int i=0; i<4; i++){
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                if (canGo(nx, ny, maps)){
                    push(nx, ny, cur.step+1);
                }
            }
        }
    }
    static boolean canGo(int x, int y, int[][] maps){
        if (!inRage(x, y)) return false;
        if (visit[x][y] > 0 || maps[x][y] == 0) return false;
        return true;
    }
    static boolean inRage(int x, int y){
        return 0 <= x && x < grid_x && 0 <= y && y < grid_y;
    }
    public int solution(int[][] maps) {
        grid_x = maps.length;
        grid_y = maps[0].length;
        visit = new int[grid_x][grid_y];
        BFS(maps);
        // for (int i=0; i<grid_x; i++){
        //     for (int j=0; j)
        // }
        if (visit[grid_x-1][grid_y-1] > 0){
            ans = visit[grid_x-1][grid_y-1];
        }
        return ans;
    }
}