import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int n = 0;
        int cnt = 1;
        int ans = 0;
        boolean flag = true;
        while (flag) {
            n++;
            for (int i=0; i<n; i++) {
                if (cnt >= s) {
                    if (cnt > e) {
                        flag = false;
                        break;
                    }
                    ans += n;
                }
                cnt++;
            }
        }

        System.out.println(ans);
    }
}