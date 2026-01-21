import java.util.*;
class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int len = arr.length;
        int sum = Arrays.stream(arr).sum();
    
        return (double)sum / len;
    }
}