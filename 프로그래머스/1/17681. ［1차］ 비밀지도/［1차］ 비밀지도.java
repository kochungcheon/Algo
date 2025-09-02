class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            
            // 이진법 계산
            int a1 = arr1[i];
            int a2 = arr2[i];
            for (int j=n-1; j>=0; j--) {
                int tmp = (int)Math.pow(2, j);
                boolean flag1 = false;
                boolean flag2 = false;
                if (a1 >= tmp) {
                    flag1 = true;
                    a1 -= tmp;
                }
                if (a2 >= tmp) {
                    flag2 = true;
                    a2 -= tmp;
                }
                if (flag1 || flag2) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}