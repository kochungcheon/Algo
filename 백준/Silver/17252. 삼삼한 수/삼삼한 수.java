import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            N = -1;
        }
        int[] threes = new int[20];

        int tmp  = 1;
        threes[0] = tmp;
        for (int i = 1; i < 20; i++) {
            tmp *= 3;
            threes[i] = tmp;
        }

        for (int i=19; i >= 0; i--) {
            if (N >= threes[i]) {
                N -= threes[i];
            }
        }
        
        System.out.print(N == 0 ? "YES" : "NO");
    }
}
