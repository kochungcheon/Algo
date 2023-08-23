import java.util.*;
class Solution {
    static final int MAX_NUM = 100;
    static int tmp;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    static ArrayList<Integer>[] graph = new ArrayList[MAX_NUM+1];
    static void DFS(int vertex){
        for(int i =0; i<graph[vertex].size(); i++){
            int curV = graph[vertex].get(i);
            if(visited[curV]) continue;
            visited[curV] = true;
            tmp++;
            DFS(curV);
        }
    }
    public int solution(int n, int[][] wires) {
        for (int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i=0;i<wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        for (int i=0; i<wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            graph[v1].remove((Integer)v2);
            graph[v2].remove((Integer)v1);
            visited = new boolean[n+1];
            
            visited[1] = true;
            tmp = 1;
            DFS(1);
            
            answer = Math.min(answer, Math.abs(tmp - (n - tmp)));
            System.out.println(" answer: " + answer + " n: " + n + " tmp: " + tmp);
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        return answer;
    }
}