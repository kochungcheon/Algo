import java.util.*;
class Solution {
    
    public long solution(int[] weights) {
        float[] x = {1.0F, 2.0F, 1.0F, 3.0F};
		float[] y = {1.0F, 3.0F, 2.0F, 4.0F};
		Map<Float, Integer> map = new HashMap<>();
		long answer = 0;
		int len = weights.length;
		Arrays.sort(weights);
		for (int i=0; i<len; i++) {
			if (map.containsKey((weights[i] * x[1])/y[1])) {
				answer += map.getOrDefault((weights[i] * x[1])/y[1], 0);
			}
			if (map.containsKey((weights[i] * x[2])/y[2])) {
				answer += map.getOrDefault((weights[i] * x[2])/y[2], 0);
			}
			if (map.containsKey((weights[i] * x[3])/y[3])) {
				answer += map.getOrDefault((weights[i] * x[3])/y[3], 0);
			}
			if (map.containsKey((weights[i] * x[0])/y[0])) {
				answer += map.getOrDefault((weights[i] * x[0])/y[0], 0);
			}
			map.put(weights[i] * 1.0F, map.getOrDefault(weights[i] * 1.0F, 0) + 1);
		} 
		return answer; 
    }
}

// x y 1 1, 4 3, 3 2, 2 1  

