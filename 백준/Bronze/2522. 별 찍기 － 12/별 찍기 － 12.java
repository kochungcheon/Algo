import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            int b = N-i-1;
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<b; j++) {
                sb.append(" ");
            }
            for (int j=0; j<=i; j++) {
                sb.append("*");
            }
            System.out.println(sb);
        }

        for (int i=N-1; i>0; i--) {
            int b = N-i;
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<b; j++) {
                sb.append(" ");
            }
            for (int j=0; j<i; j++) {
                sb.append("*");
            }
            System.out.println(sb);
        }


    }
}