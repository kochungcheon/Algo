
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String tmp = s;
        String[] arr = new String[]{"a", "e", "i", "o", "u"};
        int ans = 0;
        for (String a : arr) {
            tmp = tmp.replaceAll(a, "");
        }
        ans = s.length() - tmp.length();
        System.out.println(ans);
    }
}