import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, W, T, K, ans;
    static int[] fire;
    // 0 1 2
    static int[] dx = {-1, 0, 1};
    static List<Integer> chooseList = new ArrayList<>();
    static void choose(int cur) {
        if (cur == T-1) {
//             한번 점검하고

            // 계산
            cal();
            return;
        }
        for (var i=0; i<3; i++) {
            chooseList.add(i);
            choose(cur+1);
            chooseList.remove(chooseList.size()-1);
        }
    }

    private static void cal() {
        // 현재 위치
        int calW = W;
        boolean[] wood = new boolean[N];
        int[] copy = Arrays.copyOf(fire, fire.length);
        // 시간은 지난 다
        for (var i=1; i<=T; i++) {
            // 화력 감소 카피 배열 어쩌고
            int[] copycopy = Arrays.copyOf(copy, copy.length);
            // wood true 면 노노노
            for (var j=0; j<N; j++) {
                if (wood[j]) continue;
                // 인접 0 개는 -3
                // 인접 1 개는 -2
                // 인접 0 개는 -1
                int neighbor = 0;
                var left = j-1;
                var right = j+1;
                if (canGo(left) && copy[left] > 0) {
                    neighbor++;
                }
                if (canGo(right) && copy[right] > 0) {
                    neighbor++;
                }

                if (neighbor == 0) {
                    copycopy[j] -= 3;
                } else if (neighbor == 1) {
                    copycopy[j] -= 2;
                } else if (neighbor == 2) {
                    copycopy[j] -= 1;
                }
            }
            // 원본에 넣자
            copy = Arrays.copyOf(copycopy, copycopy.length);

            // 마지막 시간엔 아무것도 못넣음
            if (i == T) continue;

            // 장작을 넣자
            wood = new boolean[N];
            // 이동
            calW += dx[chooseList.get(i-1)];
            // 만약 벽을 벗어나는 움직이면 거기서 끗
            if (!canGo(calW)) return;
            wood[calW] = true;
        }

        // 조건에 맞는 지 확인 K 개 있어야 한다
        var tmp = 0;
        for (var i=0; i<N; i++) {
            if (copy[i] > 0) {
                tmp++;
            }
        }

        if (tmp >= K) {
            ans++;
        }

    }

    private static boolean canGo(int x) {
        return 0 <= x && x < N;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 모닥불 개수
        N = Integer.parseInt(st.nextToken());
        // 시작 위치
        W = Integer.parseInt(st.nextToken());
        // 놀이 시간
        T = Integer.parseInt(st.nextToken());
        // 최소 유지 개수
        K = Integer.parseInt(st.nextToken());

        fire = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        choose(0);

        System.out.println(ans);
    }
}