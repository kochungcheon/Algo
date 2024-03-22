import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S1 = Integer.parseInt(st.nextToken());
        int S2 = Integer.parseInt(st.nextToken());
        int S3 = Integer.parseInt(st.nextToken());

        int maxCnt = 0;
        int ans = -1;

        int[] sumArr = new int[110];

        for (int i=1; i <= S1; i++) {
            for (int j=1; j<= S2; j++) {
                for (int h=1; h<= S3; h++) {
                    sumArr[i+j+h]++;
                }
            }
        }

        for (int i=0; i<sumArr.length; i++) {
            if (sumArr[i] > maxCnt) {
                ans = i;
                maxCnt = sumArr[i];
            }
        }
        System.out.println(ans);
    }
}