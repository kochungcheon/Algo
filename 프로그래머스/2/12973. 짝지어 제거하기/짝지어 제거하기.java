import java.util.*;
import java.lang.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Deque<Character> ad = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if (ad.isEmpty() || ad.peek() != c){
                ad.push(c);
            } else {
                ad.pop();
            }
        }
        if (ad.isEmpty()){
            answer = 1;
        }

        return answer;
    }
}