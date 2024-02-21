import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 삼각 형 출력
        for (int i=0; i<N; i++) {
            int cnt = i * 2 + 1;
            int max = 2 * N - 1;
            int padding = (max - cnt)/2;
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<padding; j++) {
                sb.append(" ");
            }
            for (int j=0; j<cnt; j++) {
                sb.append("*");
            }
            System.out.println(sb);
        }

        for (int i=N-2; i>=0; i--) {
            int cnt = i * 2 + 1;
            int max = 2 * N - 1;
            int padding = (max - cnt)/2;
            StringBuilder sb = new StringBuilder();

            for (int j=0; j<padding; j++) {
                sb.append(" ");
            }
            for (int j=0; j<cnt; j++) {
                sb.append("*");
            }

            System.out.println(sb);
        }

    }
}