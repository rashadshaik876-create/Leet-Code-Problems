class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int balance = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                balance++;
            } else {
                balance--;
            }
            
            // Whenever balance hits 0, we found a valid balanced substring
            if (balance == 0) {
                count++;
            }
        }
        
        return count;
    }
}
