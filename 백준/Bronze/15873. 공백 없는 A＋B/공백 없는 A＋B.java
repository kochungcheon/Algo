
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if (s.length() >= 4) {
            System.out.println(20);
        }
        else if (s.length() >= 3) {
            if (s.startsWith("10")) {
                System.out.println(10 + Integer.parseInt(String.valueOf(s.charAt(2))));
            }
            else {
                System.out.println(Integer.parseInt(String.valueOf(s.charAt(0))) + 10);
            }
        } else {
            System.out.println(Integer.parseInt(String.valueOf(s.charAt(0))) + Integer.parseInt(String.valueOf(s.charAt(1))));
        }
    }
}