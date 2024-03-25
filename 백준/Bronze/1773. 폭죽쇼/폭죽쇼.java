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


        int[] people = new int[N];
        boolean[] boom = new boolean[M+1];

        for (int i=0; i<N; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(people);

        int cnt = 0;

        for (int i=0; i<N; i++) {
            int now = people[i];
            for (int j=now; j<=M; j+=now) {
                if (boom[j]) continue;
                boom[j] = true;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}