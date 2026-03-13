import java.util.*;
import java.io.*;

// 숫자 카드 2 (백준 10816)
public class Main {
    static int N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<N; i++) {
            map.put(cards[i], map.getOrDefault(cards[i], 0) + 1);
        }

        M = Integer.parseInt(br.readLine());
        int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder sb = new StringBuilder();
        for (int t : target) {
            sb.append(map.getOrDefault(t, 0)).append(" ");
        }
        System.out.println(sb);

    }
}
