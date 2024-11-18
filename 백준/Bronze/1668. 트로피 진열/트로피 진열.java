import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++ ) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 앞에서 부터 보기
        int max = -1;
        int cnt = 0;
        for (int i=0; i<N; i++) {
            if (max < arr[i]) {
                max = arr[i];
                cnt++;
            }
        }
        System.out.println(cnt);

        max = -1;
        cnt = 0;
        // 뒤에서 부터 보기
        for (int i=N-1; i>=0; i--) {
            if (max < arr[i]) {
                max = arr[i];
                cnt++;
            }
        }

        System.out.print(cnt);

    }
}
