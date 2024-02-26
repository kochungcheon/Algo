import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i=n; i>=1; i--) {
            int blank = n-i;
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<blank; j++) {
                sb.append(" ");
            }
            int star = (i-1) * 2 + 1;
            for (int j=0; j<star; j++) {
                sb.append("*");
            }
            System.out.println(sb);
        }
    }
}