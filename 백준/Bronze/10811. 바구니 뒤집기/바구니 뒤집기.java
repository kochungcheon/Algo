import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = i+1;
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int[] tmp = new int[N];
            for (int j=s; j<=e; j++) {
                tmp[j] = arr[e-j+s];
            }
            for (int j=s; j<=e; j++) {
                arr[j] = tmp[j];
            }
        }

        for (int i=0; i<N; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}