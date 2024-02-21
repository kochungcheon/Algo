import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());
        Integer M = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[10010];
        Arrays.fill(arr, true);
        arr[1] = false;
        arr[0] = false;
        for (int i=2; i*i<=10010; i++) {
            if (arr[i]) {
                for (int j= 2 * i; j<10010; j+= i) {
                    arr[j] = false;
                }
            }
        }

        int ans = 0;
        int min = -1;
        for (int i=N; i<=M; i++) {
            if (arr[i]) {
                ans += i;
                if (min == -1) {
                    min = i;
                }
            }
        }

        if (ans == 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
            System.out.println(min);
        }

    }
}