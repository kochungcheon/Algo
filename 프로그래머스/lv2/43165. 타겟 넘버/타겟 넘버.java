import java.util.*;

class Solution {
    
    public int solution(int[] numbers, int target) {
        int N = numbers.length;
        return choose(0, target, numbers, new ArrayList<>());
    }
    
    private int cal(int[] numbers, List<Integer> arr){
        int now = 0;
        for (int i=0; i < arr.size(); i++){
            int tmp = numbers[i];
            int com = arr.get(i);
            if (com == 0){
                tmp *= -1;
            }
            now += tmp;
        }
        return now;
    }
    
    private int choose(int cur, int target, int[] numbers, List<Integer> arr){
        if (cur == numbers.length){
            return target == cal(numbers, arr) ? 1 : 0;
        }
        
        int ans = 0;
        
        for (int i=0; i<2; i++){
            arr.add(i);
            ans += choose(cur + 1, target, numbers, arr);
            arr.remove(arr.size()-1);
        }
        
        return ans;
    }
}
