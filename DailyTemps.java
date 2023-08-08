import java.util.Arrays;
import java.util.Stack;

class DailyTemps {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int length = temperatures.length;
        int[] out = new int[length];

        for (int i = 0 ; i < length; i++) {
            while(!s.isEmpty() && temperatures[i] >= temperatures[s.peek()]) {
                int idx = s.pop();
                out[idx] = i - idx;
            }
            s.push(i);
        }

        return out;
    }

    public static void main(String[] args) throws Exception {
        DailyTemps dt = new DailyTemps();
        int[] temps = { 73, 74, 75, 71, 69, 72, 76, 73 };
        //            [ 1,  1,  4,  2,  1,  1,  0,  0]

        System.out.println((Arrays.toString(dt.dailyTemperatures(temps))));
    }
}



    //     int length = temperatures.length;
    //     int[] out = new int[length];

    //     for (int i = 0; i < length - 1; i++) {
    //         int diff = 1;
    //         while ((i + diff) < length && temperatures[i] >= temperatures[i + diff]) {
    //             diff++;
    //         }
            
    //         if (i + diff < length) {
    //             out[i] = diff;
    //         } else {
    //             out[i] = 0;
    //         }
            
    //     }

    //     return out;
    // }
    // passes 47/48 test cases - test48 is bs