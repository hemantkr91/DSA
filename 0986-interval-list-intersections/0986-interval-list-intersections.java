class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < firstList.length && j < secondList.length) {

            int s1 = firstList[i][0];
            int e1 = firstList[i][1];

            int s2 = secondList[j][0];
            int e2 = secondList[j][1];

            // Overlap check
            if(e1 >= s2 && e2 >= s1) {

                res.add(new int[]{
                    Math.max(s1, s2),
                    Math.min(e1, e2)
                });
            }

            // Jiska end chhota hai, usko move karo
            if(e1 < e2) {
                i++;
            } else {
                j++;
            }
        }

        int[][] ans = new int[res.size()][2];

        for(int k = 0; k < res.size(); k++) {
            ans[k] = res.get(k);
        }

        return ans;
    }
}