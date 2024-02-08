import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String com = br.readLine();
            if (com.equals("end")) break;

            sb.append("<").append(com).append("> is ");

            if (isGood(com)) {
                sb.append("acceptable. ");
            } else {
                sb.append("not acceptable. ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static char[] mo = {'a', 'e', 'i', 'o', 'u'};

    private static boolean isGood(String com) {
        if (!hasOne(com)) {
            return false;
        }

        if (hasTwo(com)) {
            return false;
        }

        if (!hasThree(com)) {
            return false;
        }

        return true;
    }

    private static boolean hasThree(String com) {
        for (int i=0; i<com.length()-1; i++) {
            char one = com.charAt(i);
            char two = com.charAt(i+1);
            if (one == 'e' || one == 'o') continue;
            if (one == two) return false;
        }
        return true;
    }

    private static boolean hasTwo(String com) {
        for (int i=0; i<com.length()-2; i++) {
            char one = com.charAt(i);
            char two = com.charAt(i+1);
            char three = com.charAt(i+2);

            if ((isVowel(one) && isVowel(two) && isVowel(three)) ||
                    (!isVowel(one) && !isVowel(two) && !isVowel(three))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isVowel(char c) {
        for (char m : mo) {
            if (c == m) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasOne(String com) {
        for (char m : mo) {
            if (com.contains(Character.toString(m))) {
                return true;
            }
        }
        return false;
    }
}