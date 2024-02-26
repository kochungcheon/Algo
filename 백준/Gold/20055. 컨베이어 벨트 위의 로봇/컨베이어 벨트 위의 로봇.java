import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] flag = new boolean[N];
        int cnt = 0;

        while (true) {
            cnt++;
            // 1 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다
            int last = arr[2*N-1];
            for (int i=2*N-2; i>=0; i--) {
                arr[i+1] = arr[i];
            }
            arr[0] = last;

            for (int i=N-1; i > 0; i--) {
                flag[i] = flag[i-1];
            }
            flag[N-1] =  flag[0] = false;


            // 2 가장 먼저 벨트에 올라간 로봇부터 벨트가 회전하는 방향으로 한 칸 이동 할 수 있다면 이동한다, 만약 이동할 수 없으면 가만히 있는 다
            for (int i=N-2; i>=0; i--) {
                // 옮기는 위치에 로봇 있냐?
                if (!flag[i]) continue;
                // 이동 하려는 위치에 로봇 있냐?
                if (flag[i+1]) continue;
                // 이동 하려는 벨트 내구도는 ?
                if (arr[i+1] <= 0) continue;
                flag[i+1] = true;
                flag[i] = false;
                // 즉시 반납
                flag[N-1] = false;
                arr[i+1]--;
            }

            // 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if (arr[0] >= 1) {
                flag[0] = true;
                arr[0]--;
            }

            // 4 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            int tmpK = 0;
            for (int i=0; i<2*N; i++) {
                if (arr[i] == 0) {
                    tmpK++;
                }
            }

            if (tmpK >= K) {
                break;
            }
        }
        System.out.println(cnt);
    }
}