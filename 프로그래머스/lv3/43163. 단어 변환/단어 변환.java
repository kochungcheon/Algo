import java.util.*;
class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int N;
    static int ans = Integer.MAX_VALUE;
    
    static void DFS(int now, int count, String[] words, String target){
        if (target.equals(words[now])){
            ans = Math.min(ans, count);
            return;
        }
        for (int i=0; i<graph[now].size(); i++){
            if (visit[graph[now].get(i)]) continue;
            visit[graph[now].get(i)] = true;
            DFS(graph[now].get(i), count+1, words, target);
            visit[graph[now].get(i)] = false;
        }
    }
    static boolean isSimilar(String word1, String word2){
        int cnt = 0;
        for (int i=0;i<word1.length(); i++){
            if (word1.charAt(i) != word2.charAt(i)){
                cnt++;
                if (cnt>=2) return false;
            }
        }
        return true;
    }
    public int solution(String begin, String target, String[] words) {
        List<String> wordList = new ArrayList<>();
        wordList.add(begin);
        wordList.addAll(Arrays.asList(words));
        N = wordList.size();
        visit = new boolean[N];
        graph = new ArrayList[N];
        for (int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (i==j) continue;
                if (isSimilar(wordList.get(i), wordList.get(j))){
                    graph[i].add(j);
                }
                
            }
        }
        for (int i=0; i<N; i++){
            System.out.print(graph[i] + " ");
        } System.out.println();
        
        DFS(0, 0, wordList.toArray(new String[0]), target);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}