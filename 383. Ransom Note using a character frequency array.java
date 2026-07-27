class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Quick check: if the ransom note is longer than the magazine, it's impossible
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // Frequency array for all 26 lowercase English letters
        int[] letterCounts = new int[26];

        // Count occurrences of each character in magazine
        for (char c : magazine.toCharArray()) {
            letterCounts[c - 'a']++;
        }

        // Decrement frequency for each character in ransomNote
        for (char c : ransomNote.toCharArray()) {
            if (letterCounts[c - 'a'] == 0) {
                return false; // Character not available or insufficient count
            }
            letterCounts[c - 'a']--;
        }

        return true;
    }
}
