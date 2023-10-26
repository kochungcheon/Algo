class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int m = arr1.length;          
        int n = arr1[0].length;     
        int p = arr2[0].length;       

        int[][] answer = new int[m][p];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}

