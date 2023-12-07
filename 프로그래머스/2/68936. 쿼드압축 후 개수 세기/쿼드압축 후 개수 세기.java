import java.util.*;
class Solution {
    public int[] solution(int[][] arr) {
        int len = arr.length;
        boolean[][] visit = new boolean[len][len];
        
        ArrayList<Integer> can = new ArrayList<>();
        
        int cnt = 1;
        can.add(1);
        while (cnt < len) {
            cnt *= 2;
            can.add(cnt);
        }
        
        int[] answer = new int[2];
        // 큰 거 부터 확인 한다
        for (int i=can.size()-1; i>=0; i--) {
            int now = can.get(i);
            int perpose = now * now;
            
            // 한 포인트 씩
            for (int j=0; j<len; j+=now) {
                for (int h=0; h<len; h+=now) {
                    int tmp = 0;
                    // 시작을 될 수 없는 값으로 시작한다
                    int compare = arr[j][h];
                    // 볼수 없는 곳에서 시작하면 넘어가이~
                    if (visit[j][h]) continue;
                    for (int x=0; x<now; x++) {
                        for (int y=0; y<now; y++) {
                            // 처음 시작이 아닌 데 이전과 값이 다르면 볼 필요가 없는 거다
                            if (compare != arr[j+x][h+y]) break;
                            tmp++;
                        }
                    }
                    // 갯수가 같으면
                    if (tmp == perpose) {
                        // 해당 숫자에 ++ 해준다
                        answer[compare]++;
                        for (int x=0; x<now; x++) {
                            for (int y=0; y<now; y++) {
                                visit[j+x][h+y] = true;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}