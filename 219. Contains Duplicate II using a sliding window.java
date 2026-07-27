import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // If the element is already present in our window of size k, we found a duplicate
            if (window.contains(nums[i])) {
                return true;
            }

            window.add(nums[i]);

            // Keep the window size at most k
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        return false;
    }
}
