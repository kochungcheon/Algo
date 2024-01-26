import java.util.*;

class Solution {
    static String[] opers = {"+-*", "+*-", "*+-", "*-+", "-+*", "-*+"};

    public long solution(String expression) {
        List<String> arr = new ArrayList<>();
        String tmp = "";

        for (int i = 0; i < expression.length(); i++) {
            Character c = expression.charAt(i);

            if (!Character.isDigit(c)) {
                arr.add(tmp);
                tmp = "";
                arr.add(String.valueOf(c));
            } else {
                tmp += c;
            }
        }
        arr.add(tmp);

        long answer = 0;
        for (String oper : opers) {
            ArrayList<String> tmpArr = new ArrayList<>(arr);
            for (int i = 0; i < 3; i++) {
                String now = String.valueOf(oper.charAt(i));
                for (int j = 0; j < tmpArr.size(); j++) {
                    if (tmpArr.get(j).equals(now)) {
                        long num1 = Long.parseLong(tmpArr.get(j - 1));
                        long num2 = Long.parseLong(tmpArr.get(j + 1));
                        long res = 0;

                        if (now.equals("+")) {
                            res = num1 + num2;
                        } else if (now.equals("-")) {
                            res = num1 - num2;
                        } else if (now.equals("*")) {
                            res = num1 * num2;
                        }

                        tmpArr.set(j - 1, String.valueOf(res));
                        tmpArr.remove(j); 
                        tmpArr.remove(j); 
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(tmpArr.get(0))));
        }

        return answer;
    }
}
