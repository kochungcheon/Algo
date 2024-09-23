import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] A;
    static int M;
    static int[] B;
    static int find(int x) {
        int s = 0;
        int e = N-1;
        while (e >= s) {
            int mid = (s + e) / 2;
            if (A[mid] == x) {
                return 1;
            }
            if (A[mid] > x) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = Integer.parseInt(br.readLine());
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(A);
        StringBuilder sb = new StringBuilder();
        for (int b : B) {
            sb.append(find(b)).append(" ");
        }
        System.out.print(sb);
    }
}
