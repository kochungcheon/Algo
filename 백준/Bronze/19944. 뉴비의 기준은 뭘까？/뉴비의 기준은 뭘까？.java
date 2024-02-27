import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        if (M <= 2) {
            System.out.println("NEWBIE!");
        }
        else if (M <= N) {
            System.out.println("OLDBIE!");
        }
        else {
            System.out.println("TLE!");
        }
    }
}