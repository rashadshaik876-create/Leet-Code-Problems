class Solution {
    public int[] minOperations(String boxes) {
        int answer[] = new int[boxes.length()];
        for(int i = 0; i < boxes.length(); i++) {
            int operations = 0;
            for(int j = 0; j < boxes.length(); j++) {
                if(boxes.charAt(j) == '1') {
                    operations = operations + Math.abs(i - j);
                }
            }
            answer[i] = operations;
        }
        return answer;
    }
}
