import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0;
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<truck_weights.length; i++) {
            int truck = truck_weights[i];
            while (true) {
                if (q.isEmpty()) {
                    q.add(truck);
                    sum += truck;
                    time++;
                    break;
                } 
                else if (q.size() == bridge_length) {
                    sum -= q.poll();
                }
                else {
                    if (sum + truck <= weight) {
                        q.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }
                    else {
                        q.add(0);
                        time++;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}