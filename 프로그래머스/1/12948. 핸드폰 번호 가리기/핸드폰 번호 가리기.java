import java.util.*;
class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length();
        String s = phone_number.substring(len - 4);
        return "*".repeat(len - 4) + s;
    }
}