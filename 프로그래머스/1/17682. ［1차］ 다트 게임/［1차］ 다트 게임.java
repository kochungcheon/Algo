import java.util.*;
import java.io.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] points = new int[3];
        
        int index = -1;
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < dartResult.length(); i++) {
            char dartc = dartResult.charAt(i);
            
            if (Character.isDigit(dartc)) {
                num.append(dartc);
            }
            else if (dartc == 'S' || dartc == 'D' || dartc == 'T') {
                index++;
                int p = Integer.parseInt(num.toString());
                num = new StringBuilder();
                if (dartc == 'S') {
                    points[index] = (int)Math.pow(p, 1);
                }
                else if (dartc == 'D') {
                    points[index] = (int)Math.pow(p, 2);
                }
                else if (dartc == 'T') {
                    points[index] = (int)Math.pow(p, 3);
                }
            } else if (dartc == '*') {
                points[index] *= 2;
                if (index > 0) {
                    points[index - 1] *= 2;
                }
            } else if (dartc == '#') {
                points[index] *= -1;
            }
        }
        for (int point : points) {
            System.out.print(point + " ");
            answer += point;
        }
        return answer;
    }
}