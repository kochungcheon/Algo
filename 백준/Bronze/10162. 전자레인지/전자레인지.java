import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] button = new int[] {300, 60, 10};
        int[] ans = new int[3];


        for (int i=0; i<button.length; i++) {
            ans[i] = N / button[i];
            N %= button[i];
        }

        if (N > 0) {
            System.out.println(-1);
        } else {
            for (int i=0; i<button.length; i++) {
                System.out.print(ans[i] + " ");
            }
        }
    }
}