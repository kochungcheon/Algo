import java.util.*;
import java.io.*;

public class Main {
    static int cal(int x, int y, int z) {
        return Math.abs(Math.max(x, Math.max(y, z)) - Math.min(x, Math.min(y, z)));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] brr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] crr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);
        Arrays.sort(brr);
        Arrays.sort(crr);

        int ans = Integer.MAX_VALUE; 

        for (int a : arr) {
            for (int b : brr) {
                ans = Math.min(ans, cal(a, b, crr[0]));
                ans = Math.min(ans, cal(a, b, crr[C - 1]));

                int min = Math.min(a, b);
                int s = 0;
                int e = C - 1;
                int idx = C;
                
                while (s <= e) { 
                    int mid = (s + e) / 2;
                    if (crr[mid] >= min) {
                        idx = mid; 
                        e = mid - 1;
                    } else {
                        s = mid + 1;
                    }
                }
                
          
                if (idx < C) {
                    ans = Math.min(ans, cal(crr[idx], a, b));
                }
            
                if (idx > 0) {
                    ans = Math.min(ans, cal(crr[idx - 1], a, b));
                }
            }
        }

        System.out.print(ans);
    }
}
