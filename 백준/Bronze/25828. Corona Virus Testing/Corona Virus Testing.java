import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int g = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        int original = g * p;
        int test = g + p * t;
        if (original == test) {
            System.out.println(0);
        } else if (original < test) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}