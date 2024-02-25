import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int ans = 0;
        int z = 1;
        for (int i=N.length()-1; i>=0; i--) {
            Character c = N.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                ans += z * ((c-'A')+10);
            } else {
                ans += z * (c-'0');
            }
            z *= B;
        }
        System.out.println(ans);
    }
}