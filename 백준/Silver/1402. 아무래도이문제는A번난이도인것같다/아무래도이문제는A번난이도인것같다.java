import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int i=0; i<T; i++) {
            ans.append("yes").append('\n');
        }
        System.out.print(ans);
    }
}