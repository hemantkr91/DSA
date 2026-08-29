class Solution {
    public int sumofSquareOfDigits(int n){
        int sum = 0;
        while(n>0){
            int digit = n%10;
            sum = sum + (digit*digit);
            n = n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = n,
            fast = n;
        while(fast != 1){
            slow = sumofSquareOfDigits(slow);
            fast = sumofSquareOfDigits(sumofSquareOfDigits(fast));
            if(fast == 1){
                return true;
            }
            if(slow == fast){
                return false;
            }
        }
        return true;
        
    }
}