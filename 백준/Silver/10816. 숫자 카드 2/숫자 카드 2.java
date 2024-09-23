import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] A;
    static int M;
    static int[] B;
    static int findMin(int x) {
        int s = 0;
        int e = N - 1;
        int val = N;
        while (e >= s) {
            int mid = (s + e) / 2;

            if (A[mid] == x) {
                val = Math.min(val, mid);
                e = mid - 1;
                continue;
            }
            if (A[mid] > x) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return val;
    }
    static int findMax(int x) {
        int s = 0;
        int e = N - 1;
        int val = -1;
        while (e >= s) {
            int mid = (s + e) / 2;
            if (A[mid] == x) {
                val = Math.max(val, mid);
                s = mid + 1;
                continue;
            }
            if (A[mid] >= x) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return val;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(A);
        M = Integer.parseInt(br.readLine());
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        for (int b : B) {
            int maxx = findMax(b);
            int minx = findMin(b);
            if (maxx < 0) {
                sb.append(0).append(" ");
            } else {
                sb.append(maxx + 1 - minx).append(" ");
            }
        }
        System.out.print(sb);
    }
}
