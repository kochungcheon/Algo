import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        List<Integer> people = new ArrayList<>();
        boolean[] boom = new boolean[M+1];

        for (int i=0; i<N; i++) {
            int now = Integer.parseInt(br.readLine());
            if (set.contains(now)) continue;
            set.add(now);
            people.add(now);
        }

        int cnt = 0;

        for (int p : people) {
            for (int j=p; j<=M; j+=p) {
                if (boom[j]) continue;
                boom[j] = true;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}