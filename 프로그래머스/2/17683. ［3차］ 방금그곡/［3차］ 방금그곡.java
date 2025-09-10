import java.util.*;
class Solution {
	public static String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		int maxTime = 0;

		m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");

		for (String musicinfo : musicinfos) {
			String[] info = musicinfo.split(",");
			String[] start = info[0].split(":");
			String[] end = info[1].split(":");
			int time = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60 + Integer.parseInt(end[1]) - Integer.parseInt(start[1]);

			info[3] = info[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");

			String melody = "";
			for (int i = 0; i < time; i++) {
				melody += info[3].charAt(i % info[3].length());
			}

			if (melody.contains(m) && time > maxTime) {
				maxTime = time;
				answer = info[2];
			}
		}

		return answer;
	}
}
