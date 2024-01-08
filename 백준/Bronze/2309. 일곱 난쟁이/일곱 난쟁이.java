import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dwarfs = new int[9];
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<9; i++) {
            dwarfs[i] = sc.nextInt();
            sum += dwarfs[i];
            map.put(dwarfs[i], i);
        }
        
        int diff = sum - 100;
        
        outerloop:
        for(int i=0; i<9; i++) {
            int target = diff - dwarfs[i];
            if(map.containsKey(target) && map.get(target) != i) {
                map.remove(dwarfs[i]);
                map.remove(target);
                break outerloop;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>(map.keySet());
        Collections.sort(result);
        for(int height : result){
            System.out.println(height);
        }        
    }
}
