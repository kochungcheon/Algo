class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        if (triangle.length == 1){
            for (int i=0; i<triangle[0].length; i++){
                answer = Math.max(answer, triangle[0][i]);
            }
            return answer;
        }
        
        for (int i=1; i<triangle.length; i++){
            int[] tr = triangle[i];
            for (int j=0; j<tr.length; j++){
                if (j-1 < 0){
                    triangle[i][j] += triangle[i-1][j];
                } else if (j == tr.length - 1){
                    triangle[i][j] += triangle[i-1][j-1];
                } 
                else {
                    triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);   
                }
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        return answer;
    }
}