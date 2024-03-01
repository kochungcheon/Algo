import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] original = new int[N][M];

        // 넘어진것은 "S" 넘어지지 않은 것은 "F"
        String[][] ans = new String[N][M];

        // 배열 만들기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j< M; j++) {
                int now = Integer.parseInt(st.nextToken());
                original[i][j] = now;
                ans[i][j] = "S";
            }
        }
        int cnt = 0;

        // 게임 시작
        for (int i=0; i<R; i++) {
            // 공격
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            String dir = st.nextToken();

            boolean canAttack = true;

            // 쓰러지지 않은 것만 공격 할 수 있다
            if (ans[x][y].equals("F")) {
                canAttack = false;
            }
            if (canAttack) {
                // 동

                if (dir.equals("E") ) {
                    int max = Math.min(original[x][y] - 1 + y, M - 1);
                    for (int j=y; j<=max; j++) {
                        // 넘어지지 않은 것
                        if (ans[x][j].equals("S")) {
                            cnt++;
                            // 얼만큼 넘어트릴지 계산한다
                            int tmpMax = Math.min(original[x][j] - 1 + j, M - 1);
                            max = Math.max(max, tmpMax);

                            // 넘어트린다
                            ans[x][j] = "F";
                        }
                    }
                }
                // 서

                else if (dir.equals("W")) {
                    int min = Math.max(0, y-(original[x][y]-1));
                    for (int j=y; j>=min; j--) {
                        // 얼만큼 넘어트릴지 계산한다
                        if (ans[x][j].equals("S")) {
                            cnt++;
                            int tmpMin = Math.max(0, j-(original[x][j]-1));
                            min = Math.min(tmpMin, min);

                            // 넘어트린다
                            ans[x][j] = "F";
                        }
                    }
                }

                // 남
                else if (dir.equals("S")) {
                    int max = Math.min(original[x][y] - 1 + x, N - 1);
                    for (int j=x; j<=max; j++) {
                        // 넘어지지 않은 것
                        if (ans[j][y].equals("S")) {
                            cnt++;
                            // 얼만큼 넘어트릴지 계산한다
                            int tmpMax = Math.min(original[j][y] - 1 + j, N - 1);
                            max = Math.max(max, tmpMax);

                            // 넘어트린다
                            ans[j][y] = "F";
                        }
                    }
                }

                // 북
                else if (dir.equals("N")) {
                    int min = Math.max(0, x-(original[x][y]-1));
                    for (int j=x; j>=min; j--) {
                        cnt++;
                        // 얼만큼 넘어트릴지 계산한다
                        if (ans[j][y].equals("S")) {
                            int tmpMin = Math.max(0, j-(original[j][y]-1));
                            min = Math.min(tmpMin, min);

                            // 넘어트린다
                            ans[j][y] = "F";
                        }
                    }
                }
            }

            // 수비
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            // 넘어졌으면 세운다
            if (ans[x][y].equals("F")) {
                ans[x][y] = "S";
            }
        }
        
        

        System.out.println(cnt);
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}