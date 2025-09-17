import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] left, right;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        left = new int[N+1];
        right = new int[N+1];
        visited = new boolean[N+1];
        StringTokenizer st;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            left[cur] = l;
            right[cur] = r;
        }
        int ans = 2*(N-1)-find(1 ,0);
        System.out.println(ans);
    }
	
    static int find(int cur, int depth) {
        if (right[cur] != -1) {
            return find(right[cur], depth+1);   
        }
        return depth;
    }
}