import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + 10000;
            int y = Integer.parseInt(st.nextToken()) + 10000;

            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);

            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
        }
        System.out.println((maxX - minX) * (maxY - minY));
    }
}