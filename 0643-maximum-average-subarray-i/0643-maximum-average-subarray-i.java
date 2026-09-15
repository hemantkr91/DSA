class Solution {
    public double findMaxAverage(int[] nums, int k) {
        //int i = 0;
        int sum = 0;
        for(int i = 0; i<k; i++ ){
            sum = sum + nums[i];
        }
        int maxsum = sum;
        for(int j = k; j<nums.length; j++){
            sum = sum - nums[j-k] + nums[j];
            maxsum = Math.max(maxsum,sum);
            
        }
        return (double)maxsum/k;
        
    }
}