import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long idx = 1;
        long ans = 0;
        for (int i=0; i<len; i++) {
            ans += (s.charAt(i)-'A'-31) * idx;
            ans %= 1234567891;
            idx *= 31;
            idx %= 1234567891;
        }
        System.out.println(ans);

    }
}