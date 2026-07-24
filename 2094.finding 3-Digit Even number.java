import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findEvenNumbers(int[] digits)
        int[] freq = new int[10];
        for (int digit : digits) {
            freq[digit]++;
        }

        List<Integer> resultList = new ArrayList<>();

        for (int num = 100; num < 1000; num += 2) {
            int d1 = num / 100;     
            int d2 = (num / 10) % 10; 
            int d3 = num % 10;     

          
            int[] currentFreq = new int[10];
            currentFreq[d1]++;
            currentFreq[d2]++;
            currentFreq[d3]++;

    
            if (currentFreq[d1] <= freq[d1] &&
                currentFreq[d2] <= freq[d2] &&
                currentFreq[d3] <= freq[d3]) {
                resultList.add(num);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
