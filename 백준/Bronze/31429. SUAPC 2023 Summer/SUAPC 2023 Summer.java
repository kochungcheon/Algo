import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] s = new int[]{0, 12, 11, 11, 10, 9, 9, 9, 8, 7, 6, 6};
        int[] m = new int[]{0, 1600, 894, 1327, 1311, 1004, 1178, 1357, 837, 1055, 556, 773};
        System.out.println(s[N] + " " + m[N]);
    }
}