import java.util.*;
import java.lang.*;
class Solution {
    static class Pair {
        int num;
        int play;
        public Pair(int num, int play) {
            this.num = num;
            this.play = play;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> hash = new HashMap<>();
        for (int i=0; i<plays.length; i++) {
            hash.put(genres[i], hash.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<String> sortedGenres = new ArrayList<>(hash.keySet());
        Collections.sort(sortedGenres,  (a, b) -> hash.get(b) - hash.get(a));
       
        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<sortedGenres.size(); i++) {
            String now = sortedGenres.get(i);
            List<Pair> pairs = new ArrayList<>();
            for (int j=0; j<plays.length; j++) {
                if (genres[j].equals(now)) {
                    pairs.add(new Pair(j, plays[j]));
                }
            }
            
            Collections.sort(pairs, (a, b) -> b.play != a.play ? b.play - a.play : a.num - b.num);
            int cnt = 0;
            for (Pair pair : pairs) {
                if (cnt>=2) break;
                ans.add(pair.num);
                cnt++;
            }
        }
        int[] answer = new int[ans.size()];
        for (int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}