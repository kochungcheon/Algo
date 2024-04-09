import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(br.readLine());
        } else {
            int ans = 1;
            for (int i=0; i<N; i++) {
                ans += Integer.parseInt(br.readLine()) - 1;
            }
            System.out.println(ans);
        }
    }
}