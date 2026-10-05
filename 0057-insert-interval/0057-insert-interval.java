class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();
        int i = 0;

        // 1. Jo intervals newInterval se pehle hain
        while (i < intervals.length &&
               intervals[i][1] < newInterval[0]) {

            list.add(intervals[i]);
            i++;
        }

        // 2. Jo intervals overlap kar rahe hain
        while (i < intervals.length &&
               intervals[i][0] <= newInterval[1]) {

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        // 3. Merged newInterval add karo
        list.add(newInterval);

        // 4. Remaining intervals add karo
        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }

        // List<int[]> -> int[][]
        int[][] res = new int[list.size()][2];

        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }

        return res;
    }
}