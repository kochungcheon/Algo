import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] visit;
    static String s;
    static void choose(int l, int r) {
        int end = 200;
        int start = 200;
        int idx = -1;
        for (int i=l; i < r+1; i++) {
            if (visit[i]) continue;
            if (start > s.charAt(i)) {
                start = s.charAt(i);
                idx = i;
            }
        }

        if (start == end) return;
        visit[idx] = true;
        StringBuilder sb= new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (visit[i]) {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);
        choose(idx + 1, r);
        choose(l, idx - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        visit = new boolean[s.length()+1];
        choose(0, s.length()-1);
    }
}
