import java.util.*;
class Solution {
    static int solution(String s) {
        int len = s.length();
        int answer = len;

        for (int num = 1; num <= len / 2; num++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, num);
            int count = 1;

            for (int i = num; i < len; i += num) {
                // 다음 부분 문자열을 가져옴
                String next = i + num > len ? s.substring(i) : s.substring(i, i + num);

                if (prev.equals(next)) {
                    count++;
                } else {
                    compressed.append(count > 1 ? count : "").append(prev);
                    prev = next;
                    count = 1;
                }
            }

            // 마지막 부분 처리
            compressed.append(count > 1 ? count : "").append(prev);

            // 최소 길이 업데이트
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }
}
