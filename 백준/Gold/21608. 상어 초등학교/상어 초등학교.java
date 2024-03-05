import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] grid;
    static int[][] prefer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        prefer = new int[N*N][5];
        grid = new int[N][N];

        int NN = N*N;

        for (int i=0; i<NN; i++) {
            prefer[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 룰에 따라 한 명씩 배정한다
        for (int i=0; i<NN; i++) {
            int people = prefer[i][0];
            // maxCnt 최대 개수
            // x, y 는 최초에 만난 걸 저장
            int maxCnt = -1;
            int maxblank = -1;
            int x = 0;
            int y = 0;

            for (int j=0; j<N; j++) {
                for (int h=0; h<N; h++) {
                    int cnt = 0;
                    int blank = 0;
                    if (grid[j][h] > 0) continue;
                    for (int z=0; z<4; z++) {
                        int nx = j + dx[z];
                        int ny = h + dy[z];
                        if (canGo(nx, ny)) {
                            for (int q=1; q<5; q++) {
                                if (grid[nx][ny] == prefer[i][q]) {
                                    cnt++;
                                    break;
                                } else if (grid[nx][ny] == 0) {
                                    blank++;
                                    break;
                                }
                            }
                        }
                    }

                    if (cnt > maxCnt) {
                        x = j;
                        y = h;
                        maxCnt = cnt;
                        maxblank = blank;
                    }
                    else if (maxCnt == cnt) {
                        if (blank > maxblank) {
                            x = j;
                            y = h;
                            maxblank = blank;
                        }
                    }


                }
            }

            grid[x][y] = people;
        }

        int ans = 0;

        for (int h=0; h<NN; h++) {
            int people = prefer[h][0];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    int now = grid[i][j];
                    if (people != now) continue;
                    int cnt = 0;
                    for (int z=0; z<4; z++) {
                        int nx = i + dx[z];
                        int ny = j + dy[z];
                        if (canGo(nx, ny)) {
                            for (int q=1; q<5; q++) {
                                if (grid[nx][ny] == prefer[h][q]) {
                                    cnt++;
                                    break;
                                }
                            }
                        }
                    }

                    if (cnt >= 4) {
                        ans += 1000;
                    } else if (cnt >= 3) {
                        ans += 100;
                    } else if (cnt >= 2) {
                        ans += 10;
                    } else if (cnt >= 1) {
                        ans++;
                    }

                }
            }
        }
        System.out.println(ans);
    }

    private static boolean canGo(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < N;
    }
}