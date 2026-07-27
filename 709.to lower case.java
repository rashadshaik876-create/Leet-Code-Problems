class Solution {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            // Check if character is an uppercase letter ('A' - 'Z')
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                // Convert to lowercase by adding the offset between 'a' and 'A' (32)
                chars[i] = (char) (chars[i] + ('a' - 'A'));
            }
        }

        return new String(chars);
    }
}
