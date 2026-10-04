class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(meetings[0]);
        for(int i = 0; i<meetings.length; i++){
            int[] prev = list.get(list.size() - 1);
            int[] curr = meetings[i];
            if(curr[0] <= prev[1]){
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1] ,curr[1]);
            }else{
                list.add(meetings[i]);
            }
        }
        int meetingdays = 0;
        for(int i = 0; i<list.size(); i++){
            int [] interval = list.get(i);
            meetingdays += interval[1] - interval[0] +1 ;
        }
        return days - meetingdays;
        
    }
}