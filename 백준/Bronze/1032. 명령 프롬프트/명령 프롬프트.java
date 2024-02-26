import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");
        int len = arr.length;
        for (int i=1; i<n; i++) {
            String[] next = br.readLine().split("");
            for (int j=0; j<len; j++) {
                if (!arr[j].equals(next[j])) {
                    arr[j] = "?";
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String a : arr) {
            ans.append(a);
        }
        System.out.println(ans);
    }
}