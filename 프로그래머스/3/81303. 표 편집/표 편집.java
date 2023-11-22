import java.util.LinkedList;
import java.util.Stack;
class Solution {
    public String solution(int n, int k, String[] cmd) {
		Stack<Integer> z_table = new Stack<Integer>();
		int len = n;
		for (String c : cmd) {
			String[] com = c.split(" ");
			if (com[0].equals("U") || com[0].equals("D")) {
				int cnt = Integer.valueOf(com[1]);
				if (com[0].equals("U")) {
					k -= cnt;
				} else {
					k += cnt;
				}
			} else if (com[0].equals("C")) {
				z_table.add(k);
				len--;
				if (k==len) {
					k--;
				}
			} else {
				if (z_table.pop() <= k) {
					k++;
				}
				len++;
			}
		}
		StringBuilder answer = new StringBuilder();
		for(int i=0; i<len; i++){
			answer.append("O");
		}
			
		while(!z_table.isEmpty()) {
			answer.insert(z_table.pop(), "X");	
		}
		return answer.toString();
	}
}