import java.util.*;

class Solution {
    static class Num {
        int val;
        int i;
        int j;
        public Num(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }
    static List<Num> phone;
    public String solution(int[] numbers, String hand) {
        phone = new ArrayList<>();
        initPhone();
        StringBuilder typing = new StringBuilder();
        int rightHand = 10; int leftHand = 11;
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                typing.append("L");
                leftHand = number;
            }
            else if (number == 3 || number == 6 || number == 9) {
                typing.append("R");
                rightHand = number;
            } else {
                
                int rightDist = calDist(phone.get(number), phone.get(rightHand));
                int leftDist = calDist(phone.get(number), phone.get(leftHand));
                if (number == 0) {
                    System.out.println("L : " + leftHand + " " + leftDist);
                    System.out.println("R : " + rightHand + " " + rightDist);
                }
                
                // 단 위치가 같으면 이때는 무슨 손 잡이인지에 따라 결정된다
                if (rightDist == leftDist) {
                    if (hand.equals("right")) {
                        typing.append("R");
                        rightHand = number;
                    } else {
                        typing.append("L");
                        leftHand = number;
                        }
                    } 
                else if (rightDist > leftDist) {
                    typing.append("L");
                    leftHand = number;
                } 
                else {
                    typing.append("R");
                    rightHand = number;
                }
            }
        }
        return typing.toString();
    }
    // 번호 init 
    private void initPhone() {
        phone.add(new Num(0, 3, 1));
        int value = 1;
        for (int i=0; i<=2; i++) {
            for (int j=0; j<=2; j++) {
                phone.add(new Num(value++, i, j));
            }
        }
        phone.add(new Num(10, 3, 2));  // # (오른손 초기 위치)
        phone.add(new Num(11, 3, 0));  // * (왼손 초기 위치)
        
        for (int i=0; i<=11; i++) {
            Num num = phone.get(i);
            System.out.println(num.val + " " + num.i + " " + num.j);
        }
    }
    // 번호와 번호 사이의 거리
    // 오른손 왼손 중 어디가 더 가까운지 
    private int calDist(Num o1, Num o2) {
        return Math.abs(o1.i - o2.i) + Math.abs(o1.j - o2.j);
    }
}
// 1 4 7 왼손
// 3 6 9 오른손
// 2580 가까운 순 , 거리가 가까우면 오른손 잡이면 오른 손 왼손 잡이면 왼손
// 