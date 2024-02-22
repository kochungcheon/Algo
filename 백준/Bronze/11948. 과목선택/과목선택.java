import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans= 0;
        int tmp = 101;
        for (int i=0; i<4; i++) {
            int now = Integer.parseInt(br.readLine());
            tmp = Math.min(tmp, now);
            ans += now;
        }
        ans -= tmp;

        tmp = 101;
        for (int i=0; i<2; i++) {
            int now = Integer.parseInt(br.readLine());
            tmp = Math.min(tmp, now);
            ans += now;
        }
        ans -= tmp;

        System.out.println(ans);
    }
}