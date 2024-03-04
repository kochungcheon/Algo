import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] days = new int[367];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for (int j=s; j<=e; j++) {
                days[j]++;
            }
        }

        int ans = 0;

        int w = 0;
        int l = 0;

        for (int i=0; i<=366; i++) {
            if (days[i] > 0) {
                w++;
                l = Math.max(l, days[i]);
            } else {
                ans += w*l;
                w = 0;
                l = 0;
            }
        }
        System.out.println(ans);
    }
}