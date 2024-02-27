import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('a' <= c && c <= 'm') c += 13;
            else if ('n' <= c && c <= 'z') c -= 13;
            else if ('A' <= c && c <= 'M') c += 13;
            else if ('N' <= c && c <= 'Z') c -= 13;
            sb.append(c);
        }
        System.out.println(sb);
    }
}