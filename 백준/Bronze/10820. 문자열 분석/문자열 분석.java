import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while ((s = br.readLine()) != null) {
            StringBuffer sb = new StringBuffer();
            int small = 0;
            int capital = 0;
            int number = 0;
            int space = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') space++;
                if (Character.isUpperCase(c)) capital++;
                if (Character.isLowerCase(c)) small++;
                if (Character.isDigit(c)) number++;
            }
            System.out.println(small + " " + capital + " " + number + " " + space);
        }
    }
}