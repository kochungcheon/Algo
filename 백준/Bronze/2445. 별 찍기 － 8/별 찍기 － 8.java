import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        for (int i=1; i<=N; i++) {
            StringBuilder sb= new StringBuilder();
            int star = i;
            for (int j=0; j<star; j++) {
                sb.append("*");
            }
            int blank = (N-star) * 2;
            for (int j=0; j<blank; j++) {
                sb.append(" ");
            }

            for (int j=0; j<star; j++) {
                sb.append("*");
            }
            System.out.println(sb);
        }

        for (int i=N-1; i>=1; i--) {
            StringBuilder sb = new StringBuilder();
            int star = i;
            for (int j=0; j<star; j++) {
                sb.append("*");
            }
            int blank = (N-star) * 2;
            for (int j=0; j<blank; j++) {
                sb.append(" ");
            }

            for (int j=0; j<star; j++) {
                sb.append("*");
            }
            System.out.println(sb);
        }

    }
}