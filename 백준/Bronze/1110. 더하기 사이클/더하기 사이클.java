import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());

        int cnt = 0;

        int M = N;
        while(N != M || cnt == 0) {
            cnt++;
            if (M < 10) {
                M = M + 10 * M;
            }
            else {
                int tmp = M % 10 + M / 10;
                M = (M % 10) * 10 + tmp  % 10;
            }
        }
        System.out.println(cnt);
    }
    // 10보자 작으면 앞에 0을 붙여 두 자리 수로 만들고
    // 각 자리 숫자를 더한다
    // 주어진 수의 가장 오른쪽 자리 수와
    // 앞서 구한 합의 가장 오른쪽 자리 수를 이어 붙여 새로운 수를 만들 수 있다
}