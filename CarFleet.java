import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < position.length; i++) map.put(position[i], speed[i]);
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, Collections.reverseOrder(Map.Entry.comparingByKey()));

        for (Map.Entry<Integer, Integer> pair : entryList) {
            stack.push((target - (double) pair.getKey()) / (double) pair.getValue());
            if (stack.size() >= 2) {
                double timePopped = stack.pop();
                if (timePopped <= stack.peek()) {
                    continue;
                }
                stack.push(timePopped);
            }   
        }
        
        return stack.size(); 
    }

    public static void main(String[] args) throws Exception {
        CarFleet cf = new CarFleet();
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed =    {2, 4,1,1,3};

        System.out.println(cf.carFleet(target, position, speed));
    }
}

// Put each position in a hashmap with its speed as its value
// Sort the hashmap by key
// Calculate how long it takes to get to target ((target - position)/speed)
// If car in a lower position is faster than an car in front of it, it must be part of the same fleet
// while (stack is not empty) {
//  int currentPos = stack.pop()
//  double calc1 = (target - currentPos)/speed
//  double calc2 = (target - stack.peek())/speed
//  if (calc2 > calc1)  
//} 
//stack.push(i)

// --------------------------
// for each value in hashmap {
//  stack.add(target - m.)
//  if (length of stack >= 2 && stack.pop() <= stack.peek()) continue;
//  return stack.size()
//
// }
//
