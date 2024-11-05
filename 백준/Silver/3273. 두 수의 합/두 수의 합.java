import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr  = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int s = 0;
        int e = arr.length - 1;

        int ans = 0;
        while (s < e) {
            int now = arr[s] + arr[e];
            if (now == target) {
                ans++;
                s++;
                e--;
            }
            else if (now > target) {
                e--;
            } else {
                s++;
            }
        }
        System.out.print(ans);
    }
}
