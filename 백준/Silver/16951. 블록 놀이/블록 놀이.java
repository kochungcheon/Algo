import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  
        int k = scanner.nextInt();
        int[] tops = new int[n];    
        for (int i = 0; i < n; i++) {
            tops[i] = scanner.nextInt(); 
        }

        int ans = n;
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                int now = k * (j - i) + tops[i];

                if (now < 1) {
                    tmp = n;
                    break;
                }
                if (now != tops[j]) {
                    tmp++;
                }
            }
            ans = Math.min(ans, tmp);
        }
        System.out.println(ans);
    }
}