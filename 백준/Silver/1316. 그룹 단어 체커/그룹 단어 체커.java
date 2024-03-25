import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i=0; i<N; i++) {
            ans++;
            String[] words = br.readLine().split("");
            String pre = "\n";
            Set<String> set = new HashSet<>();
            for (String w : words) {
                if (pre.equals("\n")) {
                    pre = w;
                    set.add(w);
                }
                else if (!Objects.equals(pre, w)) {
                  if (set.contains(w)) {
                      ans--;
                      break;
                  }
                  pre = w;
                  set.add(w);
                }
            }
        }
        System.out.println(ans);
    }
}