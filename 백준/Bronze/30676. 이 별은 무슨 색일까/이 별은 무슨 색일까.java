import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[]{620, 590, 570, 495, 450, 425, 380};
        String[] color = new String[] {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};
        for (int i=0; i<arr.length; i++) {
            if (N >= arr[i]) {
                System.out.println(color[i]);
                break;
            }
        }

    }
}