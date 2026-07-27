class Solution {
    public boolean isAnagram(String s, String t) {
        // Anagrams must be of equal length
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        // Increment counts for s, decrement counts for t
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Check if all counts return to zero
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}
