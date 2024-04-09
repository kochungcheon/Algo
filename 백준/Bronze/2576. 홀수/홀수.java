import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 101;
        int total = 0;
        for (int i=0; i<7; i++) {
            int N = Integer.parseInt(br.readLine());
            if (N % 2 == 1) {
                total += N;
                ans = Math.min(ans, N);
            }
        }
        if (ans == 101) {
            System.out.println(-1);
        } else {
            System.out.println(total);
            System.out.println(ans);
        }
    }
}