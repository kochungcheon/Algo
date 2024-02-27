import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        int ans = 0;
        int ans3 = 0;
        for (int i=1; i<=a; i++) {
            ans += i;
            ans3 += i * i * i;
        }
        System.out.println(ans);
        System.out.println(ans * ans);
        System.out.println(ans3);
    }
}