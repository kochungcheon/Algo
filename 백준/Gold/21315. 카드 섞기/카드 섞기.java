import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] end;
    static int[] arr;
    static int N;

    static Integer pow(int K) {
        int tmp = 1;
        for (int i=0; i<K; i++) {
            tmp *= 2;
        }
        return tmp;
    }

    static void shuffle(int K) {
        int twoK = pow(K);
        int[] copy = new int[N];
        for (int i=0; i<N; i++) {
            copy[i] = arr[i];
        }

        // 첫 번째 단계 : 2^K 개의 카드를 더미의 맨 위에 올린다
        int start = N - twoK;
        for (int i=start; i<N; i++) {
            arr[i-start] = copy[i];
        }

        for (int i=0; i<start; i++) {
            arr[twoK + i] = copy[i];
        }

        // 두 번째 단계 : "직전"에 맨 위로 올린 카드 중 밑에서 2^(K-i+1) 개의 카드를 더미 맨 위로 올린다 (i -> 2~K+1)
        // 직전 단계 index 기록
        int preIdx = twoK;
        for (int i=2; i<=K+1; i++) {
            // 밑에서 2^(K-i+1) 개의 카드
            twoK = pow(K-i+1);
            for (int j=0; j<N; j++) {
                copy[j] = arr[j];
            }

            // 2..1
            for (int j=preIdx-twoK; j<preIdx; j++) {
                arr[j-(preIdx-twoK)] = copy[j];
            }
            start = preIdx-twoK;
            for (int j=0; j<N; j++) {
                if (j >= preIdx-twoK && j < preIdx){
                    continue;
                }
                arr[start++] = copy[j];
            }

            preIdx = twoK;

//            for (int j=0; j<N; j++) {
//                System.out.print(arr[j] + " ");
//            }
//            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        N = Integer.parseInt(st.nextToken());
        end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        arr = new int[N];
        // 원본 세팅
        for (int i=0; i<N; i++) {
            arr[i] = i+1;
        }

        int max = N;
        int tmp = 1;
        for (int i=0; i<N; i++) {
            if (tmp * 2 >= max) {
                max = i;
                break;
            }
            tmp *= 2;
        }


        for (int i=1; i<=max; i++) {
            shuffle(i);
            boolean flag = false;
            int[] tmps = new int[N];
            for (int j=0; j<N; j++) {
                tmps[j] = arr[j];
            }
            for (int j=1; j<=max; j++) {
                shuffle(j);
                int cnt = 0;
                for (int h=0; h<N; h++) {
                    if (arr[h] == end[h]) {
                        cnt++;
                    }
                }
                if (cnt == N) {
                    flag = true;
                    System.out.println(i + " " + j);
                    break;
                }

                // 이번 턴 초기화
                for (int h=0; h<N; h++) {
                    arr[h] = tmps[h];
                }
            }

            if (flag) {
                break;
            }

            // 이번 턴 초기화
            for (int j=0; j<N; j++) {
                arr[j] = j+1;
            }
        }
    }
}