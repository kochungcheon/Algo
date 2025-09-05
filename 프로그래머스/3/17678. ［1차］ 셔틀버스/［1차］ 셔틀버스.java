import java.util.*;
import java.io.*;

class Solution {
    static int maxTime = convert("23:59");
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        List<Integer> converTimeTable = new ArrayList<>();
        for (String time : timetable) {
            int ct = convert(time);
            converTimeTable.add(ct);
            System.out.println(ct);
        }
        Collections.sort(converTimeTable);
        
        int busTime = convert("09:00");
        int peopleIdx = 0;
        int lastTime = 0;
        
        // n개 회차
        for (int i=0; i<n; i++) {
            // 이번 회차에 태울 수 있는 크루원을 다 태운다
            int boarder = 0;
            while (boarder < m && peopleIdx < converTimeTable.size() && busTime >= converTimeTable.get(peopleIdx)) {
                lastTime = converTimeTable.get(peopleIdx);
                peopleIdx++;
                boarder++;
            }
            if (i == n-1) {
                if (boarder == m) {
                    return converString(lastTime - 1);
                } else {
                    return converString(busTime);
                }
            }
                
            busTime += t;
        }
        
        return answer;
    }
    
    static int convert(String time) {
        String[] token = time.split(":");
        return Integer.parseInt(token[0]) * 60 + Integer.parseInt(token[1]);
    }
    
    static String converString(int time) {
        String hour = String.valueOf(time / 60);
        String min =String.valueOf(time % 60);
        if (hour.length() == 1) {
            hour = "0" + hour;
        }
        if (min.length() == 1) {
            min = "0" + min;
        }
        return hour + ":" + min;
    }
    
    static boolean canGo(int time) {
        return maxTime >= time;
    }
}