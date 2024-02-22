import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x == 0) break;
            if (x > y && x % y == 0) {
                System.out.println("multiple");
            }

            else if (x < y && y % x == 0) {
                System.out.println("factor");
            }
            else {
                System.out.println("neither");
            }
        }
    }
}