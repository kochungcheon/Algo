import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    private static String[] splitFileName(String fileName) {
        Pattern pattern = 
            Pattern.compile("([a-zA-Z,\\- ]+)(\\d+)(.*)");
        Matcher matcher = pattern.matcher(fileName);
        
        if (matcher.matches()) {
            return new String[]{matcher.group(1), matcher.group(2), matcher.group(3)};
        } else {
            return null;
        }
    }

    static class Pair {
        String HEAD;
        int NUMBER;
        int INDEX;

        public Pair(String HEAD, int NUMBER, int INDEX) {
            this.HEAD = HEAD;
            this.NUMBER = NUMBER;
            this.INDEX = INDEX;
        }
    }

    public String[] solution(String[] files) {
        Pair[] pairs = new Pair[files.length];
        for (int i = 0; i < files.length; i++) {
            String[] parts = splitFileName(files[i]);
            pairs[i] = new Pair(parts[0].toLowerCase(), Integer.parseInt(parts[1]), i);
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                int headCompare = p1.HEAD.compareTo(p2.HEAD);
                if (headCompare != 0) return headCompare;
                int numberCompare = Integer.compare(p1.NUMBER, p2.NUMBER);
                if (numberCompare != 0) return numberCompare;
                return Integer.compare(p1.INDEX, p2.INDEX);
            }
        });

        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = files[pairs[i].INDEX];
        }

        return answer;
    }
}
