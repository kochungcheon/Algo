import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dist;
    static int N, M;
    public static void main(String[] args) throws IOException {
        input();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        dist = new int[N][N];

        for (int i=0; i<N; i++) {
            dist[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                for (int h=0; h<N; h++) {
                    dist[j][h] = Math.min(dist[j][h], dist[j][i] + dist[i][h]);
                }
            }
        }

        StringBuilder sb =new StringBuilder();
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken());

            if (dist[A][B] <= C) {
                sb.append("Enjoy other party\n");
            } else {
                sb.append("Stay here\n");
            }
        }
        System.out.println(sb.toString());
    }
}