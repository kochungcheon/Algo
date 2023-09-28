class Solution {
    public String solution(String input) {
        String[] arr = input.split(" ");
        int s = Integer.parseInt(arr[0]);
        int e = Integer.parseInt(arr[0]);
        for (int i=0; i<arr.length; i++){
            if (s > Integer.parseInt(arr[i])){
                s = Integer.parseInt(arr[i]);
            } 
            if (e < Integer.parseInt(arr[i])){
                e = Integer.parseInt(arr[i]);
            }
        }
        String answer = s + " " + e;
        return answer;
    }
}