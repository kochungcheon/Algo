import java.util.*;
import java.io.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int len = musicinfos.length;
        // System.out.println(len);
        String target = convert(m);
        // 재생 시간
        int maxTime = -1;
        for (int i=0; i<len; i++) {
            String[] musicinfo = musicinfos[i].split(",");
            int startTime = convertTime(musicinfo[0].split(":"));
            int endTime = convertTime(musicinfo[1].split(":"));
            int time = converTimeTerm(startTime, endTime);
            
            String title = musicinfo[2];
            String melody = convertMusic(convert(musicinfo[3]), time);

            // System.out.println(melody);
            if (melody.contains(target) && time > maxTime) {
                maxTime = time;
                answer = title;
            }
            
            
        }
        return answer;
    }
    public String convert(String m) {
        return m.replaceAll("C#", "H").replaceAll("D#", "I").replaceAll("F#", "J").replaceAll("G#", "K").replaceAll("A#", "L").replaceAll("B#", "1").replaceAll("E#", "2");
    }
    
    public String convertMusic(String music, int time) {
        StringBuilder sb = new StringBuilder();
        int len = music.length();
        for (int i=0; i<time; i++) {
            sb.append(music.charAt(i % len));
        }
        // System.out.println(sb);
        return sb.toString();
    }
    
    public int convertTime(String[] time) {
        int hour = Integer.parseInt(time[0]) * 60;
        int min = Integer.parseInt(time[1]);
        return hour + min;
    }
    
    public int converTimeTerm(int startTime, int endTime) {
        return endTime - startTime;
    }
}