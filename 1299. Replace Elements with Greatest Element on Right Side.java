class Solution {
    public int[] replaceElements(int[] arr) {
        int maxRight = -1;
        
        // Iterate backward from the last element to the first
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            arr[i] = maxRight;
            maxRight = Math.max(maxRight, current);
        }
        
        return arr;
    }
}
