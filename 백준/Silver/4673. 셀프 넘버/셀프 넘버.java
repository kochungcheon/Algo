import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
// 양의 정수 n에 대하여 d(n) 을 N과 N의 각 자리수를 더라는 ㅎ ㅏㅁ수
public class Main {

    public static void main(String[] args) throws IOException {
        boolean[] arr = new boolean[10010];
        for (int i=1; i<=10000; i++) {
            int tmp = i;
            int now = i;

            while (tmp > 0) {
                now += (tmp % 10);
                tmp /= 10;
            }

            if (now >= 10001) continue;
            arr[now] = true;
        }

        for (int i=1; i<=10000; i++) {
            if (!arr[i]) System.out.println(i);
        }
    }
}