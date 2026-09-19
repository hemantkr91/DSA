class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for(int i = 0; i<k; i++){
            sum = sum + arr[i];
        }
        int count = 0;
        if(sum /k >= threshold){
            count++;
        }
        //int avg = sum ;
        for(int j = k; j<arr.length; j++){
            sum = sum - arr[j-k] + arr[j];
            
             
            if(sum / k >= threshold ){
            
                count++;
            }
        }
        return count;

        
    }
}