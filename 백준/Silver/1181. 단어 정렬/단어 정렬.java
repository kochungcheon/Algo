import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> words = new TreeSet<>(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words.add(word);
        }
        words.forEach(System.out::println);
    }
}