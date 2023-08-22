import java.util.*;

class Solution {
    static int N;
    static String com;
    static HashSet<Integer> set = new HashSet<>();

    static void check(int now) {
        if (now  == 2){
            set.add(now);
            return;
        }
        if (now % 2 == 0) {
            return;
        }
        for (int i = 3; i*i <= now; i += 2) {
            if (now % i == 0) {
                return;
            }
        }
        set.add(now);
    }
    static boolean[] visit; 
    static void choose(int cur, String ans) {
        if (cur > 0) {
            int now = Integer.parseInt(ans);
            if (now > 1) {
                check(now);
            }
        }
        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            choose(i + 1, ans + com.charAt(i));
            visit[i] = false;
        }
    }

    public int solution(String numbers) {
        com = numbers;
        N = numbers.length();
        visit = new boolean[N];
        choose(0, "");
        for (Integer a : set){
            System.out.println(a);
        }
        
        return set.size();
    }
}
