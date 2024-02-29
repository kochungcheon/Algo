import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        while(s.length() % 3 != 0) {
            s = "0" + s;
        }

        for(int i=0; i<s.length(); i+=3) {
            sb.append(Integer.toOctalString(Integer.parseInt(s.substring(i, i+3), 2)));
        }

        System.out.println(sb);
    }
}
