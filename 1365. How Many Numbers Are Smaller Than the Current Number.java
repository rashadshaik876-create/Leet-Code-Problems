class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        
        // Count frequencies of each number
        for (int num : nums) {
            count[num]++;
        }
        
        // Compute running sum: count[i] will store how many numbers are smaller than i
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            int currentFreq = count[i];
            count[i] = sum;
            sum += currentFreq;
        }
        
        // Map the original array elements to their counts
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = count[nums[i]];
        }
        
        return result;
    }
}
