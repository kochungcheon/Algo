import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int[] arr = new int[1001];
        for (int i=1; i<=1000; i++) {
            arr[i] = arr[i-1] + i;
        }

        while (T-- > 0) {
            int now = Integer.parseInt(br.readLine());

            int ans = 0;
            for (int i=1; i<= 1000; i++) {
                if (arr[i] > now) {
                    break;
                }
                for (int j=1; j<=1000; j++) {
                    if (arr[i] + arr[j] > now) {
                        break;
                    }
                    for (int h=1; h<=1000; h++) {
                        int tmp = arr[i] + arr[j] + arr[h];
                        if (tmp == now) {
                            ans = 1;
                            break;
                        }

                        if (tmp > now) {
                            break;
                        }
                    }
                    if (ans == 1) {
                        break;
                    }
                }
                if (ans == 1) {
                    break;
                }
            }

            System.out.println(ans);

        }
    }
}