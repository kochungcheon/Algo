class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int pCnt = 0; int yCnt = 0;
        for (char c : s.toCharArray()) {
            if (c == 'p' || c == 'P') pCnt++;
            else if (c == 'y' || c == 'Y') yCnt++;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        
        return pCnt == yCnt;
    }
}