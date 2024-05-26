
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        if (n.contains("D2") || n.contains("d2")) {
            System.out.println("D2");
        } else {
            System.out.println("unrated");
        }
    }
}