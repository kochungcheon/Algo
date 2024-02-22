import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public enum Pair {
        SONGDO("SONGDO", "HIGHSCHOOL"),
        CODE("CODE", "MASTER"),
        YEAR_2023("2023", "0611"),
        ALGORITHM("ALGORITHM", "CONTEST");

        private String key;
        private String value;

        Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public static String getValueByKey(String key) {
            for (Pair pair : Pair.values()) {
                if (pair.getKey().equals(key)) {
                    return pair.getValue();
                }
            }
            return "kocc10";
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(Pair.getValueByKey(s));
    }
}