import java.util.*;
class Solution {
    static int visit[];
    static void DFS(int now, int n, int[][] computers){
        for (int i=0; i<n; i++){
            if (visit[i] == 0 && computers[now][i] == 1){
                visit[i] = 1;
                DFS(i, n, computers);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        visit = new int[n];
        int answer = 0;
        for (int i=0; i<n; i++){
            if (visit[i] == 0){
                DFS(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
}