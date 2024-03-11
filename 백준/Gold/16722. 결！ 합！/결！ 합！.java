import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static String[][] cards;
    static List<String> hArr = new ArrayList<>();

    static int N = 9;
    static int ans = 0;

    static boolean[] visit = new boolean[9];
    static List<Integer> chooseArr = new ArrayList<>();

    static void choose(int cur, int pre) {
        if (cur == 3) {

//            for (var i=0; i<3; i++) {
//                System.out.print(chooseArr.get(i));
//            }
//            System.out.println();
            // 합인지 확인하고 (그림의 세 가지 속성이 모두 같거나 모두 다른 세 장의 그림 조합)
            // 합이면 hArr에 넣는 다
            var tmpSum = 0;
            var one = chooseArr.get(0)-1;
            var two = chooseArr.get(1)-1;
            var three = chooseArr.get(2)-1;

            for (var i = 0; i < 3; i++) {
                var first = cards[one][i];
                var sec = cards[two][i];
                var third = cards[three][i];
                // 같거나
                if (first.equals(sec) && first.equals(third)) {
                    tmpSum++;
                } else if (!first.equals(sec) && !first.equals(third) && !sec.equals(third)) {
                    tmpSum++;
                }
            }

            // 3 미만이면 합 배열이 아니다
            if (tmpSum < 3) {
                return;
            }
            var now = "";
            int[] tmp = new int[3];
            for (var j = 0; j < 3; j++) {
                tmp[j] = chooseArr.get(j);
            }
            Arrays.sort(tmp);
            for (var j = 0; j < 3; j++) {
                now += tmp[j];
            }
            hArr.add(now);
            return;
        }

        for (var i = pre; i <= N; i++) {
            if (visit[i-1]) continue;
            visit[i-1] = true;
            chooseArr.add(i);
            choose(cur + 1, i);
            chooseArr.remove(chooseArr.size() - 1);
            visit[i-1] = false;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cards = new String[N][3];
        for (var i = 0; i < N; i++) {
            cards[i] = br.readLine().split(" ");
        }

        choose(0, 1);

        var cnt = Integer.parseInt(br.readLine());

        boolean gFlag = true;

        for (var i = 0; i < cnt; i++) {
            String[] com = br.readLine().split(" ");

            if (com[0].equals("H")) {
                String[] tmp = new String[3];
                for (var j = 1; j <= 3; j++) {
                    tmp[j-1] = com[j];
                }

                Arrays.sort(tmp);

                String now = "";
                for (var j = 0; j < 3; j++) {
                    now += tmp[j];
                }
                if (hArr.contains(now)) {
                    ans++;
                    hArr.remove(now);
                } else {
                    ans--;
                }
            } else {
                if (hArr.isEmpty() && gFlag) {
                    gFlag = false;
                    ans += 3;
                } else {
                    ans -= 1;
                }
            }
        }
        System.out.println(ans);
    }
}
