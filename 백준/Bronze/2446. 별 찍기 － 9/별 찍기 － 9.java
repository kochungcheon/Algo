import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i=N-1; i>=0; i--) {
            StringBuilder sb= new StringBuilder();
            int blank = (N-1-i);
            for (int j=0; j<blank; j++) {
                sb.append(" ");
            }

            int star = (i*2 + 1);
            for (int j=0; j<star; j++) {
                sb.append("*");
            }
            System.out.println(sb);
        }

        for (int i=1; i<N; i++) {
            StringBuilder sb = new StringBuilder();
            int blank = (N-1-i);
            for (int j=0; j<blank; j++) {
                sb.append(" ");
            }
            int star = (i*2 + 1);
            for (int j=0; j<star; j++) {
                sb.append("*");
            }
            System.out.println(sb);
        }
    }
}