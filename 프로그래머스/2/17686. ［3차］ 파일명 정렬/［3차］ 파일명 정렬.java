import java.util.*;
import java.io.*;

class Solution {
    static class File {
        String head;
        int number;
        int index;
        
        public File(String head, int number, int index) {
            this.head = head.toLowerCase();
            this.number = number;
            this.index = index;
        }
        
        public String getHead() {
            return this.head;
        }
        public int getNumber() {
            return this.number;
        }
        public int getIndex() {
            return this.index;
        }
    }
    public String[] solution(String[] files) {
        int len = files.length;
        String[] answer = new String[len];
        PriorityQueue<File> pq = new PriorityQueue(
            Comparator.comparing(File::getHead).thenComparing(File::getNumber).thenComparing(File::getIndex)
        );
        for (int i=0; i<len; i++) {
            String file = files[i];
            
            int j = 0;
            while (j < file.length() && !Character.isDigit(file.charAt(j))) {
                j++;
            }
            
            int k = j;
            while (k < file.length() && Character.isDigit(file.charAt(k))) {
                k++;
            }
            pq.add(
            new File(
                file.substring(0, j),
                Integer.valueOf(file.substring(j, k)),
                i
            ) 
            );
        }
        int index = 0;
        while (!pq.isEmpty()) {
            File f = pq.poll();
            answer[index++] = files[f.getIndex()];
        }
        
        return answer;
    }
}