class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            // Right se element add
            sum += nums[right];

            // Sum target tak pahunch gaya
            while (sum >= target) {

                // Current window ki length
                int len = right - left + 1;

                // Minimum update
                minLen = Math.min(minLen, len);

                // Left se element remove
                sum -= nums[left];
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }

        return minLen;
    }
}