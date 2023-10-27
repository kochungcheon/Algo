import java.util.*;
class Solution {
    static class Pair{
        int x;
        int index;
        Pair(int x, int index){
            this.x = x;
            this.index = index;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Pair> dq = new ArrayDeque<>();
        int len = priorities.length - 1;
        
        for (int i=0; i<priorities.length; i++){
            dq.add(new Pair(priorities[i], i));
        }
        Arrays.sort(priorities);
        // System.out.println(priorities[len]);
        while (!dq.isEmpty()){
            Pair now = dq.pollFirst();
            // System.out.println(now.x + " " + now.index);
            if (now.x == priorities[len]){
                answer+= 1;
                if (now.index == location){
                    len = -1;
                    break;
                }
                len--;
            } else {
                dq.addLast(now);
            }
        
        }
        return answer;
    }
}