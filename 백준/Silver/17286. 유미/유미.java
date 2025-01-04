import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int x;
        int y;
        public Pair (int x, int y) {
           this.x = x;
           this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        List<Pair> arr = new ArrayList<>();
        StringTokenizer st;
        for (int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        List<int[]> routes = new ArrayList<>();

        for (int i=1; i<=3; i++) {
            for (int j=1; j<=3; j++) {
                for (int h=1; h<=3; h++) {
                    if (i != j && j != h && i != h) {
                        routes.add(new int[]{i, j, h});
                    }
                }
            }
        }

        double ans = 1000.0;
        for (int[] route : routes) {
            Pair start = arr.get(0);
            double tmp = 0.0;
            for (int r : route) {
                Pair enc = arr.get(r);
                tmp += Math.sqrt((start.x - enc.x) * (start.x - enc.x) + (start.y - enc.y) * (start.y - enc.y));
                start = enc;
            }
            ans = Math.min(ans, tmp);
        }
        System.out.print((int)ans);
    }
}