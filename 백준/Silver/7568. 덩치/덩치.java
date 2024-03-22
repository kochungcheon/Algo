import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
// 양의 정수 n에 대하여 d(n) 을 N과 N의 각 자리수를 더라는 ㅎ ㅏㅁ수
public class Main {
    static class Pair {
        int w;
        int h;
        public Pair(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[N];
        int[] win = new int[N];

        for (int i=0; i<N; i++) {
            int[] wh = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int w = wh[0];
            int h = wh[1];
            arr[i] = new Pair(w, h);
        }

        for (int i=0; i<N-1; i++) {
            for (int j=i+1; j<N; j++) {
                if (arr[i].h > arr[j].h && arr[i].w > arr[j].w) {
                    win[j]++;
                } else if (arr[i].h < arr[j].h && arr[i].w < arr[j].w) {
                    win[i]++;
                }
            }
        }

        for (int i=0; i<N; i++) {
            System.out.print(win[i] + 1 + " ");
        }
    }
}