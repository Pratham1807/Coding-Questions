QUESTION:
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.


Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]


SOLUTION:

class Solution {
    
    public void util(List<List<Integer>> res, int[] candidates, int target, List<Integer> row,int index){
        if(target == 0){
            List<Integer> newList = new ArrayList<>(row);
            res.add(newList);
        }
        for(int i=index;i<candidates.length && target>0;i++){
            row.add(candidates[i]);
            util(res,candidates,target-candidates[i],row,i);
            row.remove(row.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        util(res,candidates,target,new ArrayList<Integer>(),0);
        return res;
    }
}
