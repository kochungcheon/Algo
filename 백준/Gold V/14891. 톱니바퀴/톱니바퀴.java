import java.io.*;
import java.util.*;


public class Main {
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[4][8];

        for (int i=0; i<4; i++) {
            String s = br.readLine();
            for (int j=0; j<8; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            int[] turn = new int[4];
            turn[num-1] = 1;
            // 왼쪽
            for (int j=num-2; j>=0; j--) {
                if (arr[j+1][6] != arr[j][2]) {
                    turn[j] = 1;
                }
                if (turn[j] == 0) break;
            }

            // 오른쪽
            for (int j=num; j<4; j++) {
                if (arr[j-1][2] != arr[j][6]) {
                    turn[j] = 1;
                }
                if (turn[j] == 0) break;
            }

            int[] newTurn = new int[4];
            newTurn[num-1] = dir;
            // 왼쪽 결정
            for (int j=num-2; j>=0; j--) {
                newTurn[j] = newTurn[j+1] * -1;
            }
            // 오른쪽 결정
            for (int j=num; j<4; j++) {
                newTurn[j] = newTurn[j-1] * -1;
            }

            for (int j=0; j<4; j++) {
                // 돌릴 필요 없으면 패스~
                if (turn[j] == 0) continue;
                // 오른쪽으로 돌려
                if (newTurn[j] == 1) {
                    int tmp = arr[j][7];
                    for (int h=6; h>=0; h--) {
                        arr[j][h+1] = arr[j][h];
                    }
                    arr[j][0] = tmp;

                }
                // 왼쪽으로 돌려
                else if (newTurn[j] == -1) {
                    int tmp = arr[j][0];
                    for (int h=0; h<7; h++) {
                        arr[j][h] = arr[j][h+1];
                    }
                    arr[j][7] = tmp;
                }
            }

        }
        int ans = 0;
        if (arr[0][0] == 1) ans++;
        if (arr[1][0] == 1) ans+=2;
        if (arr[2][0] == 1) ans+=4;
        if (arr[3][0] == 1) ans+=8;
        System.out.println(ans);
    }
}