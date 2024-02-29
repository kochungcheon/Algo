import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = 1;
        while (true) {
            int L = sc.nextInt();
            int P = sc.nextInt();
            int V = sc.nextInt();
            if (L == 0 && P == 0 && V == 0) break;
            int result = (V / P) * L;
            result += Math.min((V % P), L);
            System.out.println("Case " + s + ": " + result);
            s++;
        }
    }
}
