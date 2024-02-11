import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String com = br.readLine();
        // 정답
        int ans = 0;
        // 괄호 사이 값을 저장 한다
        int tmp = 1;

        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<com.length(); i++) {
            char now = com.charAt(i);
            if (now == '(') {
                stack.add(now);
                tmp *= 2;
            } else if (now == '[') {
                stack.add(now);
                tmp *= 3;
            }
            else {
                if (stack.size() == 0) {
                    ans = 0;
                    break;
                }
                char peek = stack.peekLast();
                char pre = com.charAt(i-1);

                if (now == ')') {
                    if (peek != '(') {
                        ans=0;
                        break;
                    }

                    if (pre == '(') {
                        ans += tmp;
                    }
                    stack.pollLast();
                    tmp /= 2;
                }

                else if (now == ']') {
                    if (peek != '[') {
                        ans = 0;
                        break;
                    }

                    if (pre == '[') {
                        ans += tmp;
                    }
                    stack.pollLast();
                    tmp /= 3;
                }
            }
        }

        if (!stack.isEmpty()) {
            ans = 0;
        }
        System.out.println(ans);
    }
}
