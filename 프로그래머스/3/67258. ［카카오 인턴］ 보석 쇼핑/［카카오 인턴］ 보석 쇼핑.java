import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int size = 0;
        Set<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }
        size = set.size();

        int start = 0, end = 0;
        int length = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();

        while (end < gems.length) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            while (map.size() == size) {
                if (end - start < length) {
                    length = end - start;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }

                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start++;
            }
            end++;
        }
        return answer;
    }
}
