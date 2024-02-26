import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();
        System.out.println(d * d* Math.PI);
        System.out.println(d * d * 2);
    }
}
