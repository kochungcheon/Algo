
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        for (int i=0; i<8; i++) {
            String arr = br.readLine();
            // 짝수가 하양
            if (i % 2 == 0) {
                for (int j=0; j<=6; j+=2) {
                    if (arr.charAt(j) == 'F') {
                        ans++;
                    }
                }
            }
            // 홀수가 하양
            else if (i % 2 == 1) {
                for (int j=1; j<=7; j+=2) {
                    if (arr.charAt(j) == 'F') {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
