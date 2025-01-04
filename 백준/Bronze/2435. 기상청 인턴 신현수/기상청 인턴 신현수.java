import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int ans = -10000;
        for (int i = 0; i <= N - K; i++) {
            int tmp = 0;
            for (int j=i; j<K+i; j++) {
                tmp += arr[j];
            }
            ans = Math.max(ans, tmp);
        }
        System.out.print(ans);
    }
}
