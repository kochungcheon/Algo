import java.util.*;

class Solution {
    static Set<Set<String>> set = new HashSet<>();
    static String[] banned_id;
    static List<Set<String>> bannedMatch;

    boolean match(String user, String banned) {
        if (user.length() != banned.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (user.charAt(i) != banned.charAt(i)) return false;
        }
        return true;
    }

    void dfs(int index, Set<String> bannedUsers) {
        if (index == banned_id.length) {
            set.add(new HashSet<>(bannedUsers));
            return;
        }

        for (String user : bannedMatch.get(index)) {
            if (bannedUsers.contains(user)) continue;

            bannedUsers.add(user);
            dfs(index + 1, bannedUsers);
            bannedUsers.remove(user);
        }
    }

    public int solution(String[] users, String[] banned) {
        banned_id = banned;

        bannedMatch = new ArrayList<>();
        for (int i = 0; i < banned_id.length; i++) {
            Set<String> matches = new HashSet<>();
            for (String user : users) {
                if (match(user, banned_id[i])) {
                    matches.add(user);
                }
            }
            bannedMatch.add(matches);
        }

        dfs(0, new HashSet<>());

        return set.size();
    }
}
