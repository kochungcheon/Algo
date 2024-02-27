import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[][] map = new String[3][4];
        for (int i=0; i<3; i++) {
            String[] tmp = sc.nextLine().split(" ");
            for (int j=0; j<4; j++) {
                map[i][j] = tmp[j];
            }
        }

        for (int i=0; i<3; i++) {
            int ans = 4;
            for (int j=0; j<4; j++) {
                if (map[i][j].equals("1")) {
                    ans--;
                }
            }
            if (ans >= 4) {
                System.out.println("D");
            }
            else if (ans >= 3) {
                System.out.println("C");
            } else if (ans >= 2) {
                System.out.println("B");
            } else if (ans >= 1) {
                System.out.println("A");
            } else {
                System.out.println("E");
            }
        }
    }
}