class Solution {
    public int maxDepth(String s) {
        int len = s.length();
        int para = 0;
        int res = 0;
        for(int i = 0; i<len; i++){
            if(s.charAt(i) == '('){
                para++;
            }else if(s.charAt(i) == ')'){
                para--;
            }
            res = Math.max(res,para);
        }
        return res;
        
    }
}