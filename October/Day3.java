QUESTION:
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.


SOLUTION:

class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.replace(nums[i], map.get(nums[i])+1);
            }
        }
        int count = 0;
        if(k==0){
            for(Integer key : map.keySet()){
                if(map.get(key) > 1) count++;
            }
        }
        else{
            for(Integer key : map.keySet()){
                if(map.containsKey(k+key)) count++;
            }
        }
        return count;
    }
}
