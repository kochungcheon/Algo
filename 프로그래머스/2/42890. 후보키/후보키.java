import java.util.*;
class Solution {
        static int N, M; 
    static List<Set<Integer>> candidateKeys = new ArrayList<>(); 

    public int solution(String[][] relation) {
        N = relation.length;
        M = relation[0].length;
        
        for (int i = 1; i < (1 << M); i++) {
            if (checkUniqueness(i, relation)) {
                if (checkMinimality(i)) {
                    candidateKeys.add(convertToSet(i)); 
                }
            }
        }
        
        return candidateKeys.size(); 
    }

    private boolean checkUniqueness(int subset, String[][] relation) {
        Set<String> set = new HashSet<>();
        for (String[] row : relation) {
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < M; j++) {
                if ((subset & (1 << j)) > 0) { 
                    key.append(row[j]).append(",");
                }
            }
            if (!set.add(key.toString())) { 
                return false;
            }
        }
        return true;
    }
    
    private boolean checkMinimality(int subset) {
        for (Set<Integer> key : candidateKeys) {
            if ((subset & setToInt(key)) == setToInt(key)) { 
                return false;
            }
        }
        return true; 
    }

    private Set<Integer> convertToSet(int subset) {
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < M; j++) {
            if ((subset & (1 << j)) > 0) {
                set.add(j);
            }
        }
        return set;
    }
    
    private int setToInt(Set<Integer> set) {
        int num = 0;
        for (int index : set) {
            num |= (1 << index);
        }
        return num;
    }
}