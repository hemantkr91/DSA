class Solution {
    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {

            // Current fruit add karo
            map.put(
                fruits[right],
                map.getOrDefault(fruits[right], 0) + 1
            );

            // Agar 2 se zyada different fruits ho gaye
            while (map.size() > 2) {

                int fruit = fruits[left];

                map.put(fruit, map.get(fruit) - 1);

                // Fruit ki frequency 0 ho gayi
                if (map.get(fruit) == 0) {
                    map.remove(fruit);
                }

                left++;
            }

            // Current valid window ki maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}