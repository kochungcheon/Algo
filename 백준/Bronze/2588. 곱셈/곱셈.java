import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String b = sc.next();
        for (int i=b.length()-1; i>=0; i--) {
            System.out.println( a * Integer.parseInt(String.valueOf(b.charAt(i))));
        }

        System.out.println(a * Integer.parseInt(b));
    }
}
