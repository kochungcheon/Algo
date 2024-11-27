import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int len = str.length();
        int[] arr = new int[26];
        int cnt = 0;
        int s = 0;
        int e = 0;
        int ans = 0;

        while (len > e) {
            int idx = str.charAt(e++) - 'a';
            arr[idx]++;
            if (arr[idx] == 1) {
                cnt++;
            }

            while (cnt > N) {
                int tmp = str.charAt(s++) - 'a';
                arr[tmp]--;
                if (arr[tmp] == 0) {
                    cnt--;
                }
            }
            ans = Math.max(ans, e - s);
        }

        System.out.print(ans);

    }
}
