import java.util.*;
class Solution {
    public int[] solution(int[] arr, int d) {
        return Arrays.stream(arr).filter(a -> a % d == 0).toArray().length == 0 ? new int[]{-1} :
            Arrays.stream(arr).filter(a -> a % d == 0).sorted().toArray();
    }
}