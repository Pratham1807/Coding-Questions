QUESTION:
Given a list of intervals, remove all intervals that are covered by another interval in the list.

Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.

After doing so, return the number of remaining intervals.

Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.


SOLUTION:

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<>(){
            @Override
            public int compare(int[] x, int[] y){
                if(x[0]>y[0]){
                    return 1;
                }
                else if(x[0]<y[0]){
                    return -1;
                }
                if(x[1]>y[1]){
                    return -1;
                }
                return 1;
            }
        });
        int count = intervals.length;
        int max = Integer.MIN_VALUE;
        for(int[] row : intervals){
            if(max>=row[1]){
                //System.out.print("["+row[0]+" "+row[1]+"]");
                count--;
                continue;
            }
            max = row[1];            
        }
        
        return count;
    }
}
