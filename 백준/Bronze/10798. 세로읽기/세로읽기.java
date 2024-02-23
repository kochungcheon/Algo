import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[][] grid = new char[5][15];
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j=0; j<s.length(); j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<15; i++) {
            for (int j=0; j<5; j++) {
                if (grid[j][i] == '\0') continue;
                sb.append(grid[j][i]);
            }
        }
        System.out.println(sb);
    }
}