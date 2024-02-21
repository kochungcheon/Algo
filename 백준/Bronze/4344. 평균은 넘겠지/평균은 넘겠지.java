import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());

        for (int i=0 ; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int[num];
            float t = 0;
            for (int j=0; j<num; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                t += arr[j];
            }

            t = t/num;
            int cnt = 0;
            for (int j=0; j<num; j++) {
                if (arr[j] > t) {
                    cnt++;
                }
            }
            float ans = (float) cnt / (float) num * 100;
            String f = String.format("%.3f", ans) + "%";

            System.out.println(f);
        }
    }
}