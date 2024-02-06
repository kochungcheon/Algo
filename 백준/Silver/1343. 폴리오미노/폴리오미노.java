import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().replaceAll("XXXX", "AAAA").replaceAll("XX", "BB");
        System.out.println(str.contains("X") ? -1 : str);
    }
}