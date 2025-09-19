import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> arr = new ArrayList<>();

        int n = board.length;
        for (int move : moves) {
            int col = move - 1;

            for (int row = 0; row < n; row++) {
                int doll = board[row][col];
                if (doll == 0) continue;

                board[row][col] = 0;

                int size = arr.size();
                if (size > 0 && arr.get(size - 1) == doll) {
                    arr.remove(size - 1);
                    answer += 2;
                } else {
                    arr.add(doll);
                }
                break;
            }
        }
        return answer;
    }
}
