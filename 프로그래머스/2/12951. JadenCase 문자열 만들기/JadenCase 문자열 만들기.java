class Solution {
    public String solution(String s) {
        String answer = "";
        boolean flag = true;
        for (int i=0; i<s.length(); i++){
            String c = Character.toString(s.charAt(i));
            char cc = s.charAt(i);
            System.out.println(c);
            if (c.equals(" ")){
                flag = true;
                answer += " ";
                continue;
            }
            if (flag){
                if (cc >= 'a' && 'z' >= cc){
                    answer += c.toUpperCase();
                } else{
                    answer += c;
                }
                flag = false;
            } else {
                if (cc >= 'A' && 'Z' >= cc){
                    answer += c.toLowerCase();
                } else{
                    answer += c;    
                }
            }
        }
        return answer;
    }
}