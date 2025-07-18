//Approach : Simple Iteration
// T C : O(n);
// S C : O(1)
/*
Let’s track the variables:

Index  i	nums[i]	        curr_sum	max_Sum
0	  -2	-2 (initial)	-2     (initial)
1	   1	max(1, 1+(-2)) = 1	   max(1, -2) = 1
2	-3	max(-3, 1+(-3)) =   -2	   max(1, -2) = 1
3	4	max(4, -2+4)    =    4     max(1, 4) = 4
4	-1	max(-1, 4+(-1)) =    3	   max(4, 3) = 4
5	2	max(2, 3+2)     =    5     max(4, 5) = 5
6	1	max(1, 5+1)     =    6     max(5, 6) = 6
7	-5	max(-5, 6+(-5)) =    1	   max(6, 1) = 6
8	4	max(4, 1+4)     =    5     max(6, 5) = 6
 */
class Solution {
    public int maxSubArray(int[] nums) {

      int max_Sum = nums[0];
      int curr_sum = nums[0];

      for(int i=1; i<nums.length; i++){

         curr_sum = Math.max(nums[i],nums[i]+curr_sum);

         max_Sum = Math.max(curr_sum,max_Sum);
        
      }

      return max_Sum;
        
    }
}