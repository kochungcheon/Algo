class Solution {
    static boolean canGo(int x, int y) {
        return 0 <= x && x < 11 && 0 <= y && y < 11; 
    }
    static int rfind(int dir) {
        if (dir == 0) {
            return 1;   
        }
        if (dir == 1) {return 0;}
        if (dir == 2) {return 3;}
        if (dir == 3) {return 2;}
        return 1;
    }
    // U, D, R, L
    // 위 0 아래 1 오 2 왼 3
    static int find(String command) {
        switch (command) {
            case "U":
                return 0; 
            case "D": 
                return 1; 
            case "R": 
                return 2; 
            case "L": 
                return 3; 
            default:
                return 0;
        }
    }
    public int solution(String d) {
        String[] dirs = new String[d.length()];
        for (int i=0; i<d.length(); i++) {
            dirs[i] = String.valueOf(d.charAt(i));
        }
        int answer = 0;
        int[][][] grid = new int[11][11][4];
        
        // 위 아래 오 왼
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int init_x = 5;
        int init_y = 5;
        for (String command : dirs) {
            int now_dir = find(command);
            int nx = init_x + dx[now_dir];
            int ny = init_y + dy[now_dir];
            if (!canGo(nx, ny)) continue;
            
            if (grid[nx][ny][now_dir] == 0) {
                // System.out.println(init_x + " " + init_y);
                // System.out.println(nx + " " + ny + " " + now_dir);
                answer++;
                grid[init_x][init_y][rfind(now_dir)] = 1;
                
                grid[nx][ny][now_dir] = 1;
            }
            init_x = nx;
            init_y = ny;
        }
        
        return answer;
    }
}