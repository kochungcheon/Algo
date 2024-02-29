import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            int last = Integer.parseInt(br.readLine());
            System.out.print(last / 25);
            last %= 25;
            System.out.print(" "+(last / 10));
            last %= 10;
            System.out.print(" "+(last / 5));
            last %= 5;
            System.out.println(" "+(last));
        }
    }
}