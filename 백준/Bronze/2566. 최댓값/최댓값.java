import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] grid = new String[9][9];
        int max = -1;
        int[] dxdy = new int[2];
        for (int i=0; i<9; i++) {
            String[] s = br.readLine().split(" ");
            for (int j=0; j<9; j++) {
                grid[i][j] = s[j];
                if (Integer.parseInt(grid[i][j]) > max) {
                    max = Integer.parseInt(grid[i][j]);
                    dxdy[0] = i+1;
                    dxdy[1] = j+1;
                }
            }
        }

        System.out.println(max);
        System.out.println(dxdy[0] + " " + dxdy[1]);


    }
}