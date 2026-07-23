import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store number -> its index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            
            map.put(nums[i], i);
        }
        
        return new int[]{};
    }
}
