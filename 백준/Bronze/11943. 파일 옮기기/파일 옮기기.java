import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr1 = br.readLine().split(" ");
        String[] arr2 = br.readLine().split(" ");
        System.out.println(Math.min(Integer.parseInt(arr1[0]) + Integer.parseInt(arr2[1]), Integer.parseInt(arr1[1]) + Integer.parseInt(arr2[0])));
    }
}