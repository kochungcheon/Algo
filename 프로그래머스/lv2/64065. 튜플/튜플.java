import java.util.*;
public class Solution {
    public static List<Integer> solution(String S) {
        S = S.substring(2, S.length() - 2);
        String[] splitArray = S.split("\\},\\{");
        
        List<Set<String>> numArr = new ArrayList<>();
        for (int i = 0; i < splitArray.length; i++) {
            String[] s = splitArray[i].split(",");
            numArr.add(new HashSet<>(Arrays.asList(s)));
        }
        
        numArr.sort(Comparator.comparingInt(Set::size));

        Set<String> ans = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (Set<String> a : numArr) {
            Set<String> tmp = new HashSet<>(a);
            tmp.removeAll(ans);
            res.add(tmp.iterator().next());
            ans.addAll(tmp);
        }

        List<Integer> finalResult = new ArrayList<>();
        for (String item : res) {
            finalResult.add(Integer.parseInt(item));
        }

        return finalResult;
    }
}