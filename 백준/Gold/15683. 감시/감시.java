import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int WALL = 6;
    static int N, M, CCTVCNT;
    static int[][] grid;
    static boolean[][] visit;
    static int ans = Integer.MAX_VALUE;
    static int WallCnt = 0;
    static List<Node> CCTVList = new ArrayList<>();
    // 동,서,남,북 / 남북,상하 / 동,서,남,북 / 동,서,남,북 / 원
    static List<Integer> CCTVDirList = new ArrayList<>();

    static void choose(int cur) {
        if (cur == CCTVCNT) {
            // 배열 초기화
            visit = new boolean[N][M];
            // 계산 하자
            cal();
            return;
        }

        var now = CCTVList.get(cur);
        if (now.num == 2) {
            for (var i = 0; i < 2; i++) {
                CCTVDirList.add(i);
                choose(cur + 1);
                CCTVDirList.remove(CCTVDirList.size() - 1);
            }
        } else if (now.num == 5) {
            CCTVDirList.add(0);
            choose(cur + 1);
            CCTVDirList.remove(CCTVDirList.size() - 1);
        } else {
            for (var i = 0; i < 4; i++) {
                CCTVDirList.add(i);
                choose(cur + 1);
                CCTVDirList.remove(CCTVDirList.size() - 1);
            }
        }
    }

    private static void cal() {
        for (var i = 0; i < CCTVCNT; i++) {
            var now = CCTVList.get(i);
            var dir = CCTVDirList.get(i);

            if (now.num == 1) {
                if (dir == 0) {
                    east(now);
                } else if (dir == 1) {
                    west(now);
                } else if (dir == 2) {
                    south(now);
                } else if (dir == 3) {
                    north(now);
                }
            } else if (now.num == 2) {
                // 동  서
                if (dir == 0) {
                    east(now);
                    west(now);
                    // 남 북
                } else if (dir == 1) {
                    south(now);
                    north(now);
                }

            } else if (now.num == 3) {
                    if (dir == 0) {
                        north(now);
                        east(now);
                    } else if (dir == 1) {
                        south(now);
                        east(now);
                    } else if (dir == 2) {
                        south(now);
                        west(now);
                    } else if (dir == 3) {
                        north(now);
                        west(now);
                    }
            } else if (now.num == 4) {
                if (dir == 0) {
                    north(now);
                    east(now);
                    west(now);
                } else if (dir == 1) {
                    north(now);
                    south(now);
                    east(now);
                } else if (dir == 2) {
                    south(now);
                    east(now);
                    west(now);
                } else if (dir == 3) {
                    north(now);
                    south(now);
                    west(now);
                }

            } else if (now.num == 5) {
                // 네 방향으로 쭉 가보자~
                north(now);
                south(now);
                east(now);
                west(now);
            }
        }

        var tmp = 0;

        for (var i =0; i<N; i++) {
            for (var j=0; j<M; j++) {
                if (!visit[i][j]) {
                    tmp++;
                }
            }
        }

        ans = Math.min(ans, tmp);
    }

    private static void west(Node now) {
        for (var j = 0; j < M; j++) {
            var ny = now.y - j;
            if (!canGo(now.x, ny)) return;
            visit[now.x][ny] = true;
        }
    }

    private static void east(Node now) {
        for (var j = 0; j < M; j++) {
            var ny = now.y + j;
            if (!canGo(now.x, ny)) return;
            visit[now.x][ny] = true;
        }
    }

    private static void south(Node now) {
        for (var j = 0; j < N; j++) {
            var nx = now.x + j;
            if (!canGo(nx, now.y)) return;
            visit[nx][now.y] = true;
        }

    }

    private static void north(Node now) {
        for (var j = 0; j < N; j++) {
            var nx = now.x - j;
            if (!canGo(nx, now.y)) return;
            visit[nx][now.y] = true;
        }
    }

    private static boolean canGo(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M && grid[x][y] != WALL;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        visit = new boolean[N][M];

        for (var i = 0; i < N; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        CCTVCNT = 0;

        for (var i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] > 0 && WALL > grid[i][j]) {
                    CCTVList.add(new Node(i, j, grid[i][j]));
                    CCTVCNT++;
                } else if (grid[i][j] == WALL) {
                    WallCnt++;
                }
            }
        }

        choose(0);
        System.out.println(ans-WallCnt);
    }

    static class Node {
        int x;
        int y;
        int num; // 1 ~ 5

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}