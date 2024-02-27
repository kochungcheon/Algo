import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        for (int i=0; i<len; i++) {
            String[] tmp = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<tmp.length; j++) {
                sb.append(new StringBuilder(tmp[j]).reverse());
                if (j != tmp.length-1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}