class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        if(s.length() < 10) {
            return new ArrayList<>();
        }

        Set<Integer> seen = new HashSet<>();
        Set<String> result = new HashSet<>();

        int k = 10;
        int rep = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        // First window
        for(int i = 0; i < k; i++) {
            int pow = k - i - 1;

            rep = rep +
                  (int)Math.pow(4, pow) *
                  map.get(s.charAt(i));
        }

        seen.add(rep);

        // Rolling hash
        for(int i = k; i < s.length(); i++) {

            // Remove outgoing character
            rep = rep -
                  (int)Math.pow(4, k - 1) *
                  map.get(s.charAt(i-k));

            // Shift
            rep = 4 * rep;

            // Add incoming character
            rep = rep + map.get(s.charAt(i));

            if(seen.contains(rep)) {
                result.add(s.substring(i-k+1, i+1));
            }

            seen.add(rep);
        }

        return new ArrayList<>(result);
    }
}