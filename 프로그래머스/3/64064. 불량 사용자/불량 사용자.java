import java.util.*;
class Solution {
    static List<Set<String>> bannedMatched = new ArrayList<>();
    static String[] bans;
    static Set<Set<String>> set= new HashSet<>();
    
    void dfs(int idx, Set<String> ban) {
        if (idx == bans.length) {
            set.add(new HashSet<>(ban));
            return;
        }
        
        for (String b : bannedMatched.get(idx)) {
            if (ban.contains(b)) continue;
            ban.add(b);
            dfs(idx+1, ban);
            ban.remove(b);
        }
    }
    
    boolean match(String user, String banned) {
        if (user.length() != banned.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (user.charAt(i) != banned.charAt(i)) return false;
        }
        return true;
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        bans = banned_id;
        for (String ban : banned_id) {
            Set<String> matches = new HashSet<>();
            for (String user : user_id) {
                if (match(user, ban)) {
                    matches.add(user);
                }
            }
            bannedMatched.add(matches);
        }
        
        dfs(0, new HashSet<>());
        
        return set.size();
    }
}