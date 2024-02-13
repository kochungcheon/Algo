import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr =new int[W];
        for (int i=0; i<W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int[] left = new int[W];

        for (int i=0; i<W; i++) {
            if (i == 0) {
                left[i] = arr[i];
            }
            else {
                left[i] = Math.max(arr[i], left[i-1]);
            }
        }
        int[] right = new int[W];

        for (int i=W-1; i>=0; i--) {
            if (i == W-1) {
                right[i] = arr[i];
            }
            else {
                right[i] = Math.max(arr[i], right[i+1]);
            }
        }
        
        for (int i=0; i<W; i++) {
            ans += Math.min(left[i], right[i]) - arr[i];
        }
        System.out.println(ans);
    }
}