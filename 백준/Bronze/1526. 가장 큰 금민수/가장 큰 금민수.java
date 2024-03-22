import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
// 양의 정수 n에 대하여 d(n) 을 N과 N의 각 자리수를 더라는 ㅎ ㅏㅁ수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        boolean[] fourSeven = new boolean[1000010];

        for (int i=1; i<=1000000; i++) {
            if (isFourSeven(i)) {
                fourSeven[i] = true;
            }
        }

        for (int i=N; i>=4; i--) {
            if (fourSeven[i]) {
                System.out.println(i);
                break;
            }

        }


    }

    static boolean isFourSeven(int n) {
        while (n > 0) {
            int tmp = n % 10;
            if (tmp != 7 && tmp != 4) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}