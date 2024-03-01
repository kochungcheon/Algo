import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer B = Integer.parseInt(br.readLine());

        Set<String> map = new HashSet<>();
        map.add("Never gonna give you up");
        map.add("Never gonna let you down");
        map.add("Never gonna run around and desert you");
        map.add("Never gonna make you cry");
        map.add("Never gonna say goodbye");
        map.add("Never gonna tell a lie and hurt you");
        map.add("Never gonna stop");

        boolean flag = true;
        for (int i=0; i<B; i++) {
            String a = br.readLine();
            if (!map.contains(a)) {
                flag = false;
            }
        }

        if (flag) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

    }
}