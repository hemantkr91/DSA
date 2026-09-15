class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int maxlen = 0;
        for(int j = i; j<s.length(); j++){
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;

            }
            set.add(s.charAt(j));
            //int maxlen = j-i+1;
            maxlen = Math.max(maxlen, j-i+1);

        }
        return maxlen;
        
        
    }
}