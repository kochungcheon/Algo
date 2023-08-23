import java.util.*;
class Solution {
    static boolean[] visit;
    static int answer = -1;
    static void choose(int cur, int[][] dungeons, int health){
        int tmp = 0;
        for (boolean cnt: visit){
            if (cnt) tmp++;
        }
        answer = Math.max(answer, tmp);
        for (int i=0; i<dungeons.length; i++){
            if (visit[i]) continue;
            if (health < dungeons[i][0]) continue;
            visit[i] = true;
            choose(cur+1, dungeons, health - dungeons[i][1]);
            visit[i] = false;
        }
    }
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        choose(0, dungeons, k);
        return answer;
    }
}